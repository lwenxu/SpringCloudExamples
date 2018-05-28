package lwen.controller;

import lwen.entries.Dept;
import lwen.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptClientService deptClientService;


    @GetMapping("/dept/list")
    public List findAll() {
        return deptClientService.findAll();
    }

    @PostMapping("/dept")
    public Boolean insertDept(Dept dept) {
        return deptClientService.insertDept(dept);
    }
}
