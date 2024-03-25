package Case_Study.services;

import Case_Study.models.Booking;
import Case_Study.models.Contract;
import Case_Study.models.Customer;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Queue;
import java.util.TreeSet;

public interface BookingService extends Service{

    TreeSet<Booking> findAll();
    Queue<Booking> findAllBookingQueue();
    void add(Booking booking, List<Customer> customers, LinkedHashMap<Object,Integer> facilities);
}
