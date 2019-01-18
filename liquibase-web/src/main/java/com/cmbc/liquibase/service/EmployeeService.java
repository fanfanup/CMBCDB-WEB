package com.cmbc.liquibase.service;




import com.cmbc.liquibase.model.Employee;
import com.cmbc.liquibase.model.ImportEmpInfo;
import com.github.pagehelper.PageInfo;

import java.io.InputStream;
import java.util.List;


public interface EmployeeService {


	public PageInfo<Employee> findEmployee(String empId, String empName,String empType, Integer page, Integer pageSize);

    public Employee queryEmpForUser(String empId);

    public void deleteEmp(String empId);

    public List<Employee> queryEmpAndUser(String empId);

    public ImportEmpInfo importEmp(InputStream in, String fileName) throws Exception;

    //员工修改加载数据，有点重复了
    public List<Employee> getEmp(String empId);

    public void modifyEmp(Employee employee);


}
