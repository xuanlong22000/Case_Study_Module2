package Case_Study.services;

import Case_Study.models.Booking;
import Case_Study.models.Customer;

import java.text.SimpleDateFormat;
import java.util.*;

public class PromotionServiceImpl implements PromotionService {
    private static Stack<Customer> voucherStack = new Stack<>();

    public void displayCustomersByYear(int year, TreeSet<Booking> bookings, List<Customer> customers) {
        for (Booking booking : bookings) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(booking.getStartDate());
            if (calendar.get(Calendar.YEAR) == year) {
                customers.stream().filter(item -> item.getId() == booking.getIdCustomer()).forEach(System.out::println);
            }
        }
    }

    public void generateVoucher(int quantity10, int quantity20, int quantity50, TreeSet<Booking> bookings,List<Customer> customers) {

        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);

        for (Booking booking : bookings) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(booking.getStartDate());

            if(calendar.get(Calendar.YEAR) == year && calendar.get(Calendar.MONTH) == month){
                customers.stream().filter(item -> item.getId() == booking.getIdCustomer()).forEach(item2 -> voucherStack.push(item2));
            }
        }

        int totalQuantity = quantity10 + quantity20 + quantity50;
        if (totalQuantity > voucherStack.size()) {
            System.out.println("Not enough customers for voucher generation.");
            return;
        }

        for (int i = 0; i < quantity10; i++) {
            Customer customer = voucherStack.pop();
            System.out.println("Give 10% voucher to customer: " + customer);
        }

        for (int i = 0; i < quantity20; i++) {
            Customer customer = voucherStack.pop();
            System.out.println("Give 20% voucher to customer: " + customer);
        }

        for (int i = 0; i < quantity50; i++) {
            Customer customer = voucherStack.pop();
            System.out.println("Give 50% voucher to customer: " + customer);
        }
    }
}
