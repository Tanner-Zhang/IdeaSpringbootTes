package com.zyt.demo.service.impl;

import com.zyt.demo.service.ex.UpdateException;
import com.zyt.demo.service.ex.UserNotFoundException;
import com.zyt.demo.entity.User;

import java.util.List;

/**
 * 处理用户数据的业务层接口
 */
public interface IUserService {
    /**
     * 查询所有用户角色信息
     * @return 查询到的角色信息
     */
    List<User> getAllRolByDid(int deptId);
    /**
     * 查询所有用户角色信息
     */
    List<User> getAllRol();
    /**
     * 设置用户角色信息
     * @param user 要修改的用户信息
     * @param id 用户id
     */
    void modifyRolById(User user,int id) throws UserNotFoundException, UpdateException;

    /**
     * 删除用户角色
     * @param id 用户id
     * @return 受影响行数
     */
    int deleteRolById(int[] id);
}
