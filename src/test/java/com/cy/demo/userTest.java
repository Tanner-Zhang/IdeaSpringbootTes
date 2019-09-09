package com.cy.demo;

import com.cy.demo.dao.UserMapper;
import com.cy.demo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class userTest {

    @Test
    public void contextLoads() {
    }
    @Autowired
    DataSource dataSource;
    @Autowired
    UserMapper mapper;
    @Test
    public void getConnection() throws SQLException {
        Connection conn = dataSource.getConnection();
        System.err.println(conn);
    }
   @Test
    public  void findAllRol(){

        List<User> list = mapper.findAllRolByDid(4);
        for(User user:list){
            System.err.print(user);
        }
   }
    @Test
    public  void modifyRol(){
        User user = new User();
        user.setId(2);
        user.setUsername("zyt");
        user.setRealName("凯皇");
        user.setSex(0);
        user.setRole("系统管理员");
        user.setDeptId(1);
        user.setModifyTime(new Date());
        int row = mapper.modifyRol(user);
        System.err.print(row);
    }
    @Test
    public void deleteRol(){
        Integer[] ids = {5,6,7};
        int row = mapper.deleteRolById(ids);
        System.err.print(row);
    }
}
