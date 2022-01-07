package com.syhewanglan.ssm.mapper;

import com.syhewanglan.ssm.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @program: SSM
 * @author: syhewanglan
 * @create: 2021-12-20 18:25
 **/
@Repository
public interface EmployeeMapper {

    /**
     * 根据员工id查询员工信息
     *
     * @param eid
     * @return
     */
    public Employee selectByEid(long eid);


    /**
     * 查询所有在职员工
     *
     * @return
     */
    public List<Employee> selectAllEmps();

    /**
     * 更新员工信息
     *
     * @param employee
     * @return
     */
    public Integer updateEmployee(Employee employee);


    /**
     * 新增员工信息
     *
     * @param employee
     * @return
     */
    public Integer saveEmployee(Employee employee);

    /**
     * 删除员工
     *
     * @param eid
     * @return
     */
    public Integer deleteByEid(long eid);


    /**
     * 根据empName和deptId进行多条件查询
     * @param empName
     * @param deptId
     * @return
     */
    public List<Employee> search(String empName, long deptId);

    /**
     * 多选删除
     * @return
     */
    public Integer deleteAll(String[] data);

}
