package com.czc;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.czc.sys.entity.User;
import com.czc.sys.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class VueManageApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Test
    void test() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }
    @Test
    public void pageSelect(){
        IPage<User> page = new Page<>(2, 3);//第几页，每页长度
        userMapper.selectPage(page, null);
        System.out.println(page.getTotal()); //总共长度
        System.out.println(page.getCurrent()); //getCurrent（）,获取当前页
        System.out.println(page.getSize()); //getCurrent（）,获取当前页
        List<User> records = page.getRecords(); //getRecords（）,获取查询数据
        records.forEach(System.out::println);
    }

}
