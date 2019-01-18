package com.cmbc.liquibase.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmbc.liquibase.mapper.LoadingMapper;
import com.cmbc.liquibase.model.Department;
import com.cmbc.liquibase.model.EmployeeType;
import com.cmbc.liquibase.model.SalaryType;
import com.cmbc.liquibase.model.UserType;
import com.cmbc.liquibase.service.LoadingService;

import java.util.List;

@Service(value = "loadingService")
public class LoadingServiceImpl implements LoadingService {

    @Autowired
    private LoadingMapper loadingMapper;

    @Override
    public List<UserType> selectAllUserType() {
        return loadingMapper.selectAllUserType();
    }

    @Override
    public List<EmployeeType> selectAllEmployeeType() {
        return loadingMapper.selectAllEmployeeType();
    }

    @Override
    public List<SalaryType> selectAllSalaryType() {
        return loadingMapper.selectAllSalaryType();
    }

    @Override
    public List<Department> selectAllDepartment() {
        return loadingMapper.selectAllDepartment();
    }
}
