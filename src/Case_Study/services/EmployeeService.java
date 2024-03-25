package Case_Study.services;

import Case_Study.models.Employee;

import java.util.ArrayList;
import java.util.List;

public interface EmployeeService extends Service{
    List<Employee> findAll();
    void add(Employee employee);
    void update(int id);

}
