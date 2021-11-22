package com.mgm.dao;

import com.mgm.pojo.Department;
import com.mgm.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName EmployeeDao
 * @Description TODO
 * @Author mgm
 * @Date 2021/11/19 1:42
 * @Version 1.0
 */
@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees = null;
    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<Integer, Employee>();
        employees.put(1001, new Employee(1001, "AA", "A123456@QQ.COM", 1, new Department(101, "教学部")));
        employees.put(1002, new Employee(1002, "BB", "B123456@QQ.COM", 0, new Department(102, "A部")));
        employees.put(1003, new Employee(1003, "CC", "C123456@QQ.COM", 1, new Department(103, "B部")));
        employees.put(1004, new Employee(1004, "DD", "D123456@QQ.COM", 0, new Department(104, "C部")));
        employees.put(1005, new Employee(1005, "EE", "E123456@QQ.COM", 1, new Department(105, "D部")));
    }

    private static Integer initId = 1006;

    public void addEmployee(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }


    public Collection<Employee> getAllEmployees() {
        return employees.values();
    }

    public Employee getEmployeeById(Integer id) {
        Employee employee = employees.get(id);
        return employee;
    }

    public void delete(Integer id) {
        employees.remove(id);
    }

}
