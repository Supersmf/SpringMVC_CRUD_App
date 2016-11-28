package com.oleg.list.employee.controller;

import com.oleg.list.employee.model.Employee;
import com.oleg.list.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired(required = true)
    @Qualifier(value = "employeeService")
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "employees", method = RequestMethod.GET)
    public String listEmployees(Model model){
        model.addAttribute("employee", new Employee());
        model.addAttribute("listEmployees", this.employeeService.listEmployees());

        return "employees";
    }

    @RequestMapping(value = "/employees/add", method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute("employee") Employee employee){
        if(employee.getId() == 0){
            this.employeeService.addEmployee(employee);
        }else {
            this.employeeService.updateEmployee(employee);
        }

        return "redirect:/employees";
    }

    @RequestMapping("/remove/{id}")
    public String removeEmployee(@PathVariable("id") int id){
        this.employeeService.removeEmployee(id);

        return "redirect:/employees";
    }

    @RequestMapping("edit/{id}")
    public String editEmployee(@PathVariable("id") int id, Model model){
        model.addAttribute("employee", this.employeeService.getEmployeeById(id));
        model.addAttribute("listEmployees", this.employeeService.listEmployees());

        return "employees";
    }

    @RequestMapping("/sort/{value}")
    public String sortTable(@PathVariable("value") String vaue, Model model){
        model.addAttribute("employee", new Employee());
        model.addAttribute("listEmployees", this.employeeService.sortListEmployees(vaue));

        return "employees";
    }

}
