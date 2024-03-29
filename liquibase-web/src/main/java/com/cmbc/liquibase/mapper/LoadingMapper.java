package com.cmbc.liquibase.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.cmbc.liquibase.model.Department;
import com.cmbc.liquibase.model.EmployeeType;
import com.cmbc.liquibase.model.SalaryType;
import com.cmbc.liquibase.model.UserType;

import java.util.List;

@Mapper
public interface LoadingMapper {

    @Select("select * from s_user_type")
    @Results({
            @Result(id=true,property="userType",column="user_type"),
            @Result(property="typeName",column="type_name"),
    })
    public List<UserType> selectAllUserType();

    @Select("select * from s_emp_type")
    @Results({
            @Result(id=true,property="empType",column="emp_type"),
            @Result(property="typeName",column="emp_type_name"),
    })
    public List<EmployeeType> selectAllEmployeeType();

    @Select("select * from s_salary_type")
    @Results({
            @Result(id=true,property="salaryName",column="salary_name"),
            @Result(property="salaryType",column="salary_type"),
            @Result(property="type",column="type"),
            @Result(property="empType",column="emp_type"),
    })
    public List<SalaryType> selectAllSalaryType();

    @Select("select * from s_department")
    @Results({
            @Result(id=true,property="departid",column="depart_id"),
            @Result(property="departName",column="depart_name"),
    })
    public List<Department> selectAllDepartment();
}
