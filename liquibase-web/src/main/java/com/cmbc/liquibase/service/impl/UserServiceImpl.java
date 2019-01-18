package com.cmbc.liquibase.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmbc.liquibase.mapper.UserMapper;
import com.cmbc.liquibase.model.User;
import com.cmbc.liquibase.service.UserService;

import tk.mybatis.mapper.entity.Example;

/**
 * @Author ff 2018-12-20
 * 一组操作需要加事务
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;//这里会报错，但是并不会影响

    @Override
    public User findUserByLogin(String empId, String pwd){

        return userMapper.findUserByPhoneByLogin(empId, pwd);

    }


    @Override
    public void updateUser(User user) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("empId",user.getEmpId());
        userMapper.updateByExample(user, example);
    }
}
