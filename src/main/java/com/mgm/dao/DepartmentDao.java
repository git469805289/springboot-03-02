package com.mgm.dao;

import com.mgm.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName DepartmentDao
 * @Description TODO
 * @Author mgm
 * @Date 2021/11/19 1:37
 * @Version 1.0
 */
@Repository
public class DepartmentDao {

    private static Map<Integer, Department> departments = null;

    static {
        departments = new HashMap<Integer, Department>();
        departments.put(101, new Department(101, "教学部"));
        departments.put(102, new Department(102, "A部"));
        departments.put(103, new Department(103, "B部"));
        departments.put(104, new Department(104, "C部"));
        departments.put(105, new Department(105, "D部"));
    }

    ///得到所有部门的信息
    public Collection<Department> getDepartments() {
        return departments.values();
    }

    public Department getDepartmentById(Integer id) {
        return departments.get(id);
    }
}
