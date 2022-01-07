package com.syhewanglan.ssm.service;

import com.syhewanglan.ssm.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @program: SSM
 * @author: syhewanglan
 * @create: 2021-12-20 18:20
 **/
public interface EmployeeService {

    public List<Employee> selectAllEmps(Integer page, Integer limit);

    public Integer saveEmployee(Employee employee);

    public Integer deleteEmployee(long empId);

    public Integer updateEmployee(Employee employee);

    public List<Employee> search(Integer page, Integer limit, String empName, long deptId);

    public Integer deleteAll(String[] data);

}
