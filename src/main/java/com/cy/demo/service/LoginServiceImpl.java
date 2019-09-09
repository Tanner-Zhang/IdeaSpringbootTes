package com.cy.demo.service;


import com.cy.demo.service.impl.LoginService;
import com.cy.demo.dao.Mapper;
import com.cy.demo.entity.User;
import com.cy.demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginServiceImpl  implements LoginService {

    @Autowired
    private Mapper mapper;




    @Override
    public Result login(String username, String password) {
        Result result =new Result();
        System.err.println(username);
        User user = mapper.login(username);

        if(user!=null){
            String passwordCheck=user.getPassword();
            if(password.equals(passwordCheck)) {
                result.setMessage("验证成功");
                result.setStatus(1);
                return result;
            }
        }

        result.setMessage("账号或密码错误");
        result.setStatus(0);


        return result;
    }
}
