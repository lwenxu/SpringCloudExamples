package lwen.service;

import lwen.dao.DeptDao;
import lwen.entries.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService {
    @Autowired
    DeptDao deptDao;

    public List<Dept> findAll() {
        return deptDao.findAll();
    }

    public Boolean insertDept(Dept dept) {
        return deptDao.insertDept(dept);
    }
}
