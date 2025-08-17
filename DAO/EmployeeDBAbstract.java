package DAO;

import Model.Employee;

public  abstract class EmployeeDBAbstract implements EmployeeDAO {
    public boolean updateEmployees(int id,Employee Employee) {
        return Employee.updateEmployees(id, this);
    }
}
