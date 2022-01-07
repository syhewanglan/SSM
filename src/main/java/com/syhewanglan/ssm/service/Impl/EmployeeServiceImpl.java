package com.syhewanglan.ssm.service.Impl;

import com.github.pagehelper.PageHelper;
import com.syhewanglan.ssm.entity.Employee;
import com.syhewanglan.ssm.mapper.EmployeeMapper;
import com.syhewanglan.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @program: SSM
 * @author: syhewanglan
 * @create: 2021-12-20 18:24
 **/
@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeeMapper employeeMapper;


    public List<Employee> selectAllEmps(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<Employee> employees = employeeMapper.selectAllEmps();
        return employees;
    }

    public Integer saveEmployee(Employee employee) {
        Integer integer = employeeMapper.saveEmployee(employee);
        return integer;
    }

    public Integer deleteEmployee(long empId) {
        Integer integer = employeeMapper.deleteByEid(empId);
        return integer;
    }

    public Integer updateEmployee(Employee employee) {
        Integer integer = employeeMapper.updateEmployee(employee);
        return integer;
    }

    public List<Employee> search(Integer page, Integer limit, String empName, long deptId) {
        PageHelper.startPage(page, limit);
        List<Employee> employees = employeeMapper.search(empName, deptId);
        return employees;
    }

    @Override
    public Integer deleteAll(String[] data) {
        Integer integer = employeeMapper.deleteAll(data);
        return integer;
    }
}

