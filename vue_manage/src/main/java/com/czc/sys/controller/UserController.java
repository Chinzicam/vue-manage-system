package com.czc.sys.controller;

import com.czc.common.vo.Result;
import com.czc.sys.entity.User;
import com.czc.sys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;

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

    @GetMapping("/table.json")
    public Result<List<User>> getAllUsers() {
        List<User> list = userService.list();
        int pageTotal = list.size();
        return Result.success(list, "查询成功",pageTotal);
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
