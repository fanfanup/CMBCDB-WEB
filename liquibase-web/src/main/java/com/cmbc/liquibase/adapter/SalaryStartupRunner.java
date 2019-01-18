package com.cmbc.liquibase.adapter;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cmbc.liquibase.Utils.ConverterSystem;
import com.cmbc.liquibase.model.Department;
import com.cmbc.liquibase.model.EmployeeType;
import com.cmbc.liquibase.model.SalaryType;
import com.cmbc.liquibase.model.UserType;
import com.cmbc.liquibase.service.LoadingService;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 服务启动执行
 * @Author ff 2018-12-20
 */
@Component
public class SalaryStartupRunner implements CommandLineRunner {

    @Resource
    private LoadingService loadingService;

    @Override
    public void run(String... args) throws Exception {

        /**
         * 加载所有科室信息
         */
        List<Department> departmentList = loadingService.selectAllDepartment();
        ConverterSystem.ALL_DEPARTMENT = departmentList.stream().collect(Collectors.toMap(Department::getDepartid, department -> department));
        /**
         * 加载所有员工类型信息
         */
        List<EmployeeType> employeeTypes = loadingService.selectAllEmployeeType();
        ConverterSystem.ALL_EMPLOYEE_TYPE = employeeTypes.stream().collect(Collectors.toMap(EmployeeType::getEmpType, employeeType -> employeeType));

        /**
         * 加载所有工资类型信息
         */
        List<SalaryType> salaryTypes = loadingService.selectAllSalaryType();
        ConverterSystem.ALL_SALARY_TYPE = salaryTypes.stream().collect(Collectors.toMap(SalaryType::getSalaryType, salaryType -> salaryType));
        ConverterSystem.FORMAL_SALARY_TYPE = salaryTypes.stream().filter(s-> s.getEmpType().indexOf("0")>-1).collect(Collectors.toList());
        ConverterSystem.PACT_SALARY_TYPE = salaryTypes.stream().filter(s-> s.getEmpType().indexOf("1")>-1).collect(Collectors.toList());

        /**
         * 加载所有用户类型
         */
        List<UserType> userTypes = loadingService.selectAllUserType();
        ConverterSystem.ALL_USER_TYPE = userTypes.stream().collect(Collectors.toMap(UserType::getUserType, userType -> userType));

    }

}