package lwen.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lwen.entries.Dept;
import lwen.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DeptController {

    @Autowired
    DeptService deptService;

    @HystrixCommand(fallbackMethod = "findAllFallBack")
    @GetMapping("/dept/list")
    public List<Dept> findAll() {
        int a = 1 / 0;
        return deptService.findAll();
    }

    @PostMapping("/dept")
    public Boolean insertDept(Dept dept) {
        return deptService.insertDept(dept);
    }


    public List<Dept> findAllFallBack() {
        ArrayList<Dept> list = new ArrayList<>();
        list.add(new Dept().setName("No such data"));
        return list;
    }
}
