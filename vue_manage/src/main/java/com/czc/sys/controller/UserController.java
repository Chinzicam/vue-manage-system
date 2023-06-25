package com.czc.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.czc.common.vo.Result;
import com.czc.sys.entity.User;
import com.czc.sys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author czc
 * @since 2023-06-14
 */
@RestController
@RequestMapping()
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/all")
    public Result<List<User>> getAllUsers() {
        List<User> list = userService.list();
        int pageTotal = list.size();
        return Result.success(list, "查询成功",pageTotal);
    }

    @GetMapping("/table.json")
    public Result<?> getUserListPage(@RequestParam(value = "address", required = false) String address,
                                     @RequestParam(value = "name", required = false) String name,
                                     @RequestParam("pageIndex") Long pageIndex,
                                     @RequestParam("pageSize") Long pageSize) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(name != null, User::getName, name);
        wrapper.eq(address != null, User::getAddress, address);
//        wrapper.orderByDesc(User::getId);
        Page<User> page = new Page<>(pageIndex, pageSize);
        userService.page(page, wrapper);

        Map<String, Object> data = new HashMap<>();
        data.put("pageTotal", page.getTotal());
        data.put("rows", page.getRecords());

        int pageTotal = Math.toIntExact(pageSize);
        return Result.success(data,"查询成功",pageTotal);
    }

    @PostMapping("/login")
    public Result login(@RequestBody User user){
        List<User> a = userService.lambdaQuery()
                .eq(User::getUsername,user.getUsername())
                .eq(User::getPassword,user.getPassword()).list();

        if(a.size()>0){
            User user1 = a.get(0);
            HashMap<String, Object> list = new HashMap();
            list.put("user",user1);
            return Result.success(list);
        }
        return Result.fail();
    }

}
