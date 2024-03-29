package com.cmbc.liquibase.Utils;




import java.util.List;
import java.util.Map;

import com.cmbc.liquibase.model.Department;
import com.cmbc.liquibase.model.EmployeeType;
import com.cmbc.liquibase.model.SalaryType;
import com.cmbc.liquibase.model.UserType;

/**
 * @Author ff 2018-12-20
 * 系统静态变量 和系统初始化数据
 */
public class ConverterSystem {
    //session用户key
    public static final String SESSION_USER_KEY = "salary_login_user";
    //所有用户类型
    public static Map<Integer,UserType> ALL_USER_TYPE = null;
    //所有员工类型信息
    public static Map<Integer,EmployeeType> ALL_EMPLOYEE_TYPE = null;
    //所有科室信息
    public static Map<Integer,Department> ALL_DEPARTMENT = null;
    //所有工资类型信息
    public static Map<Integer,SalaryType> ALL_SALARY_TYPE = null;
    //合同工资类型信息
    public static List<SalaryType> PACT_SALARY_TYPE = null;
    //正式工资类型信息
    public static List<SalaryType> FORMAL_SALARY_TYPE = null;
    //分页数据量
    public static final int PAGE_SIZE = 10;
    //扩大多少倍
    public static final double MULTIPLE = 10000;
    /** 允许上传的扩展名*/
    public static String [] EXTENSIONPERMIT = {"xlsx","xls"};


}

