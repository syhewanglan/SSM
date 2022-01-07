package com.syhewanglan.ssm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @program: SSM
 * @author: syhewanglan
 * @create: 2021-12-20 18:12
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private long id;
    private String deptId;
    private String deptName;
    private List<Employee> employees;

}
