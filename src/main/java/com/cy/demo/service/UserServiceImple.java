package com.cy.demo.service;

import com.cy.demo.service.ex.UserNotFoundException;
import com.cy.demo.service.impl.IUserService;
import com.cy.demo.dao.UserMapper;
import com.cy.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImple implements IUserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> getAllRolByDid(int deptId) {
        //获取该部门角色信息
        List<User>  userRols = userMapper.findAllRolByDid(deptId);
        //返回部门角色集合信息
        return userRols;
    }

    @Override
    public List<User> getAllRol() {
        //获取所有角色信息
        List<User>  userRols = userMapper.findAllRol();
        //返回所有角色集合信息
        return userRols;
    }

    @Override
    public void modifyRolById(User user, int id) {
        //根据用户id查找用户
        int rowl = userMapper.findByUid(id);
        if(rowl!=1){
            throw new UserNotFoundException("该用户不存在！");
        }
        //执行信息更改操作
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());
        try {
            user.setModifyTime(sdf.parse(date));
            user.setIsDelete(0);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        userMapper.modifyRol(user);
    }

    @Override
    public int deleteRolById(int[] id) {
        //ToDo
        return 0;
    }
}
