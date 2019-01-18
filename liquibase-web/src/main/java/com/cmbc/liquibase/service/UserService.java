package com.cmbc.liquibase.service;


import java.util.List;

import com.cmbc.liquibase.model.User;

public interface UserService {

    User findUserByLogin(String empid, String pwd);

    void updateUser(User user);
}