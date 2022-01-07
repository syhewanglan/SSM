package com.syhewanglan.ssm.mapper;

import com.syhewanglan.ssm.entity.Department;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: SSM
 * @author: syhewanglan
 * @create: 2021-12-20 18:25
 **/
@Repository
public interface DepartmentMapper {

    /**
     * 查询所有部门
     * @return
     */
    public List<Department> selectAllDepts();
}
