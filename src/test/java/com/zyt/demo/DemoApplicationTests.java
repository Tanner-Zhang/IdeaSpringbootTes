package com.zyt.demo;

import com.zyt.demo.dao.MenuMapper;
import com.zyt.demo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
    }
    @Autowired
    DataSource dataSource;
    @Autowired
    MenuMapper mapper;
    @Test
    public void getConnection() throws SQLException {
        Connection conn = dataSource.getConnection();
        System.err.println(conn);
    }
   @Test
    public  void loginMapper(){

        String username = "zyt";
        //  String password = "123";
        User user = mapper.login(username);
        System.err.print(user);
    }
   @Test
    public  void findAllRol(){

        User user = mapper.findAll();
        System.err.print(user);
    }
}
