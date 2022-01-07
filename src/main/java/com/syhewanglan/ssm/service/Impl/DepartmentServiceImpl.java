package com.syhewanglan.ssm.service.Impl;

import com.syhewanglan.ssm.entity.Department;
import com.syhewanglan.ssm.mapper.DepartmentMapper;
import com.syhewanglan.ssm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: SSM
 * @author: syhewanglan
 * @create: 2021-12-20 18:23
 **/
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    public List<Department> selectAlldepts() {
        List<Department> departments = departmentMapper.selectAllDepts();
        return departments;
    }
}
