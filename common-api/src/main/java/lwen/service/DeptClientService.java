package lwen.service;

import lwen.entries.Dept;
import lwen.rules.MyRuleConfig;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "CLOUD-DEPT",configuration = MyRuleConfig.class)
public interface DeptClientService {

    @GetMapping("/dept/list")
    List<Dept> findAll();

    @PostMapping("/dept")
    Boolean insertDept(Dept dept);
}
