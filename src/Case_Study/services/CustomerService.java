package Case_Study.services;

import Case_Study.models.Customer;

import java.util.LinkedList;
import java.util.List;

public interface CustomerService extends Service{
    List<Customer> findAll();
    void add(Customer customer);
    void update(int id);
}
