package com.syhewanglan.ssm.controller;

import com.syhewanglan.ssm.entity.Department;
import com.syhewanglan.ssm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: SSM
 * @author: syhewanglan
 * @create: 2021-12-20 18:18
 **/
@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/dept_list")
    @ResponseBody
    public Map<String, Object> dept_list() {
        List<Department> departments = departmentService.selectAlldepts();
        HashMap<String, Object> map = new HashMap<String, Object>();
//        map.put("msg", "success");
//        map.put("code", 0);
        map.put("departments", departments);
        map.put("length", 4);
        return map;
    }

}
