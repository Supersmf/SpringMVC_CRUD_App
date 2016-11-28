package com.oleg.list.employee.dao;

import com.oleg.list.employee.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addEmployee(Employee employee) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(employee);

    }

    @Override
    public void updateEmployee(Employee employee) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(employee);

    }

    @Override
    public void removeEmployee(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Employee employee = (Employee) session.load(Employee.class, id);

        if(employee!=null){
            session.delete(employee);
        }

    }

    @Override
    public Employee getEmployeeById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Employee employee = (Employee) session.get(Employee.class, id);

        return employee;
    }

    @Override
    public List<Employee> listEmployees() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Employee> employeeList = session.createQuery("from Employee").list();

        return employeeList;
    }

    @Override
    public List<Employee> sortListEmployees(String param) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Employee> employeeList = session.createQuery("from Employee order by " + param).list();
        return employeeList;
    }
}
