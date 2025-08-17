package DAO;

import Model.Employee;
import java.util.List;
public interface EmployeeDAO {
boolean insertEmployee( Employee employee );
Employee getempid(int id);
Employee getidbyname(String name);
List<Employee> getAllemployees();

boolean deleteemployee(int id);

int lastempid();

boolean updateEmployee(int id, Employee employee);

boolean employeeExists(int id);

}
