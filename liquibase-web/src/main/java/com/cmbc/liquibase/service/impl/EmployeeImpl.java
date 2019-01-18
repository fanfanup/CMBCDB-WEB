package com.cmbc.liquibase.service.impl;


import com.cmbc.liquibase.mapper.EmployeeMapper;
import com.cmbc.liquibase.mapper.UserMapper;
import com.cmbc.liquibase.model.Employee;
import com.cmbc.liquibase.model.ImportEmpInfo;
import com.cmbc.liquibase.model.User;
import com.cmbc.liquibase.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service(value = "employeeService")
public class EmployeeImpl implements EmployeeService {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo<Employee> findEmployee(String empId, String empName,String empType, Integer page, Integer pageSize){
        PageHelper.startPage(page, pageSize);
        Employee employee = new Employee();
        if(StringUtils.isNotBlank(empId)){
            employee.setEmpId(empId);
        }
        if(StringUtils.isNotBlank(empName)){
            employee.setEmpName(empName);
        }
        if(StringUtils.isNotBlank(empType)){
            employee.setEmpType(empType);
        }

        List<Employee> employeeList = employeeMapper.select(employee);
        PageInfo<Employee> pageInfo = new PageInfo<>(employeeList);
        return pageInfo;
    }

    @Override
    public Employee queryEmpForUser(String empId) {
        Employee employee = new Employee();
        if(StringUtils.isNotBlank(empId)){
            employee.setEmpId(empId);
        }
        Employee emp = employeeMapper.selectByPrimaryKey(employee);
        return emp;
    }

    @Override
    public List<Employee> getEmp(String empId) {
        Employee employee = new Employee();
        if(StringUtils.isNotBlank(empId)){
            employee.setEmpId(empId);
        }
        List<Employee> employees = employeeMapper.select(employee);
        return employees;
    }

    @Override
    public void modifyEmp(Employee employee) {
        this.employeeMapper.updateByPrimaryKeySelective(employee);
    }


    @Override
    public void deleteEmp(String empId) {
        Employee employee = new Employee();
        User user = new User();
        if(StringUtils.isNotBlank(empId)){
            employee.setEmpId(empId);
            user.setEmpId(empId);
        }
        employeeMapper.delete(employee);
        userMapper.delete(user);
    }

    @Override
    public List<Employee> queryEmpAndUser(String empId) {
        Employee employee = new Employee();
        employee.setEmpId(empId);
        List<Employee> employees = employeeMapper.queryEmployees(employee);

        return employees;
    }

	@Override
	public ImportEmpInfo importEmp(InputStream in, String fileName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}




}

