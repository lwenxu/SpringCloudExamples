package lwen.controller;


import lwen.entries.Dept;
import lwen.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    DeptService deptService;

    @GetMapping("/dept/list")
    public List<Dept> findAll() {
        return deptService.findAll();
    }

    @PostMapping("/dept")
    public Boolean insertDept(Dept dept) {
        return deptService.insertDept(dept);
    }
}
