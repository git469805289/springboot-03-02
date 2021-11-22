package com.mgm.controller;

import com.mgm.dao.DepartmentDao;
import com.mgm.dao.EmployeeDao;
import com.mgm.pojo.Department;
import com.mgm.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Iterator;

/**
 * @ClassName EmployeeController
 * @Description TODO
 * @Author mgm
 * @Date 2021/11/19 15:06
 * @Version 1.0
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping(value = "/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAllEmployees();
        model.addAttribute("emps", employees);

        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("dpms", departments);


        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        employeeDao.addEmployee(employee);

        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id") Integer id, Model model) {

        Employee employee = employeeDao.getEmployeeById(id);
        model.addAttribute("emp", employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("dpms", departments);

        return "emp/update";
    }

    @RequestMapping("/update")
    public String update(Employee employee) {
        employeeDao.addEmployee(employee);

        return "redirect:/emps";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model) {
        employeeDao.delete(id);
        Collection<Employee> allEmployees = employeeDao.getAllEmployees();
        model.addAttribute("dpms", allEmployees);
        return "redirect:/emps";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();

        return "redirect:/";
    }
}
