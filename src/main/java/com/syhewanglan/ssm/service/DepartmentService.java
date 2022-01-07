package com.syhewanglan.ssm.service;

import com.syhewanglan.ssm.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: SSM
 * @author: syhewanglan
 * @create: 2021-12-20 18:19
 **/
public interface DepartmentService {
    
    public List<Department> selectAlldepts();
}
