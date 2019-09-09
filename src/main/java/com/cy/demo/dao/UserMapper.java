package com.cy.demo.dao;

import com.cy.demo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户管理接口
 * */
@Repository
public interface UserMapper {
    /**
     * 根据部门id查询所有角色信息
     * @param deptId 部门id
     * @return 查询部门内的用户角色信息
     */
    List<User> findAllRolByDid(int deptId);

    /**
     * 查找所有角色信息
     * @return 查询结果集
     */
    List<User> findAllRol();
    /**
     * 设置用户角色信息
     * @param user 要修改的用户信息
     * @return 受影响行数
     */
    int modifyRol(User user);
    /**
     * 删除用户角色
     * @param ids 用户id数组
     * @return 受影响行数
     */
    int deleteRolById(Integer[] ids);

    /**
     * 根据用户id查找用户
     * @param id 用户id
     * @return 符合条件行数
     */
    int findByUid(int id);
}
