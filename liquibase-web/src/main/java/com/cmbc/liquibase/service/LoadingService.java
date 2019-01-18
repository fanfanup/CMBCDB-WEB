package com.cmbc.liquibase.service;



import java.util.List;

import com.cmbc.liquibase.model.Department;
import com.cmbc.liquibase.model.EmployeeType;
import com.cmbc.liquibase.model.SalaryType;
import com.cmbc.liquibase.model.UserType;

public interface LoadingService {

    public List<UserType> selectAllUserType();

    public List<EmployeeType> selectAllEmployeeType();

    public List<SalaryType> selectAllSalaryType();

    public List<Department> selectAllDepartment();
}
