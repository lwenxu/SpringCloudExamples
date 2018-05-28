package lwen.service;

import feign.hystrix.FallbackFactory;
import lwen.entries.Dept;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component // 不要忘记添加，不要忘记添加
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService>
{
    @Override
    public DeptClientService create(Throwable throwable)
    {
        return new DeptClientService() {
            @Override
            public List<Dept> findAll() {
                ArrayList<Dept> list = new ArrayList<>();
                list.add(new Dept().setName("No such data"));
                return list;
            }

            @Override
            public Boolean insertDept(Dept dept) {
                return null;
            }
        };
    }
}
