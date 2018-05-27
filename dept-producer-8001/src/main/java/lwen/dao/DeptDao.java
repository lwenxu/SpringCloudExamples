package lwen.dao;


import lwen.entries.Dept;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DeptDao {
    @Select("select * from clouddb01.dept")
    public List<Dept> findAll();

    @Insert("insert into clouddb01.dept(name, db_name) values (#{name},database())")
    boolean insertDept(Dept dept);
}
