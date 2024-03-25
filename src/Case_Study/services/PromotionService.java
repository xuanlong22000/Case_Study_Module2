package Case_Study.services;

import Case_Study.models.Booking;
import Case_Study.models.Customer;

import java.util.List;
import java.util.TreeSet;

public interface PromotionService extends Service{
    void displayCustomersByYear(int year, TreeSet<Booking> bookings, List<Customer> customers);
    void generateVoucher(int quantity10, int quantity20, int quantity50, TreeSet<Booking> bookings,List<Customer> customers);
}
