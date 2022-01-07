package com.syhewanglan.ssm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

/**
 * @program: SSM
 * @author: syhewanglan
 * @create: 2021-12-20 18:07
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private long id;
    private long empId;
    private String empName;
    private String gender;
    private String email;
    private long deptId;
    private Department department;
}
