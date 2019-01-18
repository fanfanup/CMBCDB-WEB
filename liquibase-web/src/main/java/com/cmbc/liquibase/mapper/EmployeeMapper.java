package com.cmbc.liquibase.mapper;


import org.apache.ibatis.annotations.*;

import com.cmbc.liquibase.Utils.BaseMapper;
import com.cmbc.liquibase.mapper.provider.EmployeeDynaSqlProvider;
import com.cmbc.liquibase.model.Employee;
import com.cmbc.liquibase.model.User;

import java.util.List;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {

    @SelectProvider(type = EmployeeDynaSqlProvider.class,method = "queryEmpAndUser")
    List<Employee> queryEmpAndUser(Employee emp);

    @SelectProvider(type = EmployeeDynaSqlProvider.class,method = "queryEmployees")
    @Results({
            @Result(id=true,property="empId",column="empid"),
            @Result(property="empName",column="emp_name"),
            @Result(property="empPhone",column="emp_phone"),
            @Result(property="empCardNum",column="emp_card_num"),
            @Result(property="empType",column="emp_type"),
            @Result(property="waltzDate",column="waltz_date"),
            @Result(property="departId",column="depart_id"),
            @Result(property="createTime",column="create_time"),
            @Result(property="updateTime",column="update_time"),
            @Result(property="baseSalary",column="base_salary")
    })
    List<Employee> queryEmployees(Employee employee);

    @SelectProvider(type = EmployeeDynaSqlProvider.class,method = "insertEmp")
    void insertEmp(Employee emp);

    @SelectProvider(type = EmployeeDynaSqlProvider.class,method = "insertUser")
    void insertUser(User user);

    @SelectProvider(type = EmployeeDynaSqlProvider.class,method = "modifyEmployee")
    void modifyEmployee(Employee employee);


}
