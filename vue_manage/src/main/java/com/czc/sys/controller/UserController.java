package com.czc.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.czc.common.vo.Result;
import com.czc.sys.entity.User;
import com.czc.sys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/table.json")
    public Result<List<User>> getAllUsers() {
        List<User> list = userService.list();
        return Result.success(list,"查询成功");
    }
}
