package com.syhewanglan.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.syhewanglan.ssm.entity.Employee;
import com.syhewanglan.ssm.service.EmployeeService;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: SSM
 * @author: syhewanglan
 * @create: 2021-12-20 18:18
 **/
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * 查询
     *
     * @param limit
     * @param page
     * @return
     */
    @GetMapping("/list")
    @ResponseBody //自动返回json格式
    public Map<String, Object> emp_list(@RequestParam(value = "limit") Integer limit,
                                        @RequestParam(value = "page") Integer page) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        System.out.println("page is :" + page);
        System.out.println("limit is :" + limit);
        try {
//            调用分页方法
            List<Employee> employees = employeeService.selectAllEmps(page, limit);
//        创建一个分页info对象,里面包含employees和分页完返回的信息
            PageInfo<Employee> pageInfo = new PageInfo(employees);
            map.put("code", 0);
//        count:是查询总条数
            map.put("count", pageInfo.getTotal());
//            data是查询分页完返回的结果
            map.put("data", pageInfo.getList());
            System.out.println(map);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", "");
        }
        return map;
    }

    /**
     * 新增
     *
     * @param employee
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public Map<String, Object> emp_add(@RequestBody Employee employee) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        try {
            Integer result = employeeService.saveEmployee(employee);
            if (result > 0) map.put("msg", "success");
            else map.put("msg", "");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", "");
        }
        return map;
    }

    /**
     * 删除
     *
     * @param empId
     * @return
     */
    @DeleteMapping("/delete")
    @ResponseBody
    public Map<String, Object> emp_delete(@RequestParam(value = "empId") long empId) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        try {
            Integer result = employeeService.deleteEmployee(empId);
            if (result > 0) map.put("msg", "success");
            else map.put("msg", "");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", "");
        }
        return map;
    }

    /**
     * 更新
     *
     * @param employee
     * @return
     */
    @PutMapping("/update")
    @ResponseBody
    public Map<String, Object> emp_update(@RequestBody Employee employee) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        try {
            Integer result = employeeService.updateEmployee(employee);
            if (result > 0) map.put("msg", "success");
            else map.put("msg", "");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", "");
        }
        return map;
    }

    @GetMapping("/search")
    @ResponseBody
    public Map<String, Object> emp_search(@RequestParam(value = "limit") Integer limit,
                                          @RequestParam(value = "page") Integer page,
                                          @RequestParam(value = "empName") String empName,
                                          @RequestParam(value = "deptId") long deptId) {

        System.out.println("page is :" + page);
        System.out.println("limit is :" + limit);
        System.out.println(empName);
        System.out.println(deptId);
        HashMap<String, Object> map = new HashMap<String, Object>();
        try {
            List<Employee> employees = employeeService.search(page, limit, empName, deptId);
            PageInfo<Employee> pageInfo = new PageInfo(employees);
            map.put("data", pageInfo.getList());
            map.put("count", pageInfo.getTotal());
            map.put("code", 0);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", "");
        }
        System.out.println(map);
        return map;
    }



    @RequestMapping("/deleteAll")
    @ResponseBody
    public Map<String, Object> emp_deleteAll(@RequestBody String[] data) {
        System.out.println(data);

        HashMap <String, Object> map = new HashMap<String, Object>();
        try {
            Integer result = employeeService.deleteAll(data);
            System.out.println(data);
//            int result = 1;
            if (result > 0) map.put("msg", "success");
            else map.put("msg", "");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", "");
        }
        return map;
    }

}
