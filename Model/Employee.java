package Model;
import DAO.EmployeeDBAbstract;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class Employee {

    // Model, POJO, ValueClass
    private  int id;
    private  String name;
    private  LocalDate date;
    private  LocalTime check_in;
    private  LocalTime check_out;
    private  BigDecimal hours_worked;

    public Employee(int id, String name, LocalDate date , LocalTime check_in, LocalTime check_out, BigDecimal hours_worked ) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.check_in = check_in;
        this.check_out = check_out ;
        this.hours_worked = hours_worked;
    }

    public int getid() {
        return id;
    }

    public String getname() {
        return name;
    }

    public LocalDate getdate() {
        return date;
    }
    
    public LocalTime getcheck_in() {
        return check_in;
    }

    public LocalTime getcheck_out() {
        return check_out;
    }

    public BigDecimal gethours_worked() {
        return hours_worked;
    }


    public void set(String name) {
        this.name = name;
    }

    public void setdate(LocalDate date) {
        this.date = date;
    }
    public void setcheck_in(LocalTime check_in) {
        this.check_in = check_in;
    }
    public void setcheck_out(LocalTime check_out) {
        this.check_out = check_out;
    }
    public void sethours_worked(BigDecimal hours_worked) {
        this.hours_worked = hours_worked;
    }
    public Employee clone() {
        return new Employee(id, name, date, check_in, check_out, hours_worked);
    }

    @Override
    public String toString() {
        return String.format("[%d] %s | Date: %s | In: %s | Out: %s | Hours: %.2f)", id, name, date, check_in, check_out, hours_worked);
    }

    public boolean updateEmployees(int id, EmployeeDBAbstract employeeDBAbstract) {
        if ( ! employeeDBAbstract.deleteemployee(id) ) return false;
        return employeeDBAbstract.insertEmployee(this);
    
    }

    
}
