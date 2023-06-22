package com.czc.sys.controller;

import com.czc.common.vo.Result;
import com.czc.sys.entity.User;
import com.czc.sys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
