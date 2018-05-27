package lwen.controller;

import lwen.entries.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    RestTemplate restTemplate;

    private static final String PRODUCER_URL_PREFIX = "http://localhost:8001";


    @GetMapping("/dept/list")
    public List findAll() {
        return restTemplate.getForObject(PRODUCER_URL_PREFIX + "/dept/list", List.class);
    }

    @PostMapping("/dept")
    public Boolean insertDept(Dept dept) {
        return restTemplate.postForObject(PRODUCER_URL_PREFIX + "/dept", dept, Boolean.class);
    }
}
