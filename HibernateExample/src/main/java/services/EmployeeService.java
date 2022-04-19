package services;

import dao.GenericDao;
import model.Employee;

public class EmployeeService {

    GenericDao<Employee> employeeGenericDao = new GenericDao<>();

    public void addEmployee(Employee employee)
    {
        employeeGenericDao.add(employee);
    }

    public void deleteEmployee(Employee employee)
    {
        employeeGenericDao.delete(employee);
    }
}
