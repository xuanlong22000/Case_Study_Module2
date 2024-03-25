package Case_Study.controllers;

import Case_Study.models.Booking;
import Case_Study.models.Customer;
import Case_Study.models.Employee;
import Case_Study.models.Person;
import Case_Study.services.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Set;

public class FuramaController {

    private static final EmployeeService employeeService = new EmployeeServiceImpl();
    private static final CustomerService customerService = new CustomerServiceImpl();
    private static final FacilityService facilityService = new FacilityServiceImpl();
    private static final BookingService bookingService = new BookingServiceImpl();
    private static final ContractService contractService = new ContractServiceImpl();
    private static final PromotionService promotionService = new PromotionServiceImpl();

    private static int id;
    public static void EmployeeManagement(){
        Scanner scanner = new Scanner(System.in);

        id = employeeService.findAll().size() + 1;
        while (true){
            System.out.println("1.Display list employees");
            System.out.println("2.Add new employee");
            System.out.println("3.Edit employee");
            System.out.println("4.Return main menu");
            System.out.println("-----------------------------");
            int select = scanner.nextInt();

            if (select == 4) {
                break;
            }

            switch (select){
                case 1:
                    System.out.println(employeeService.findAll());
                    break;
                case 2:
                    System.out.print("Name : ");
                    String name = scanner.next();
                    System.out.print("DOB : ");
                    String dob = scanner.next();
                    System.out.print("Gender (Male, Female): ");
                    Person.Gender gender = Person.Gender.valueOf(scanner.next());
                    System.out.print("Identification : ");
                    int identification = scanner.nextInt();
                    System.out.print("PhoneNumber : ");
                    int phoneNumber = scanner.nextInt();
                    System.out.print("Email : ");
                    String email = scanner.next();
                    System.out.print("Qualifications (Intermediate, College, University , Postgraduate) : ");
                    Employee.Qualifications qualifications = Employee.Qualifications.valueOf(scanner.next());
                    System.out.print("Position (receptionist, server, specialist, supervisor, manager, supervisor_governor) : ");
                    Employee.Position position = Employee.Position.valueOf(scanner.next());
                    System.out.print("Salary : ");
                    double salary = scanner.nextDouble();

                    Employee employee = new Employee(id,name,dob,gender,identification,phoneNumber,email,qualifications,position,salary);
                    employeeService.add(employee);
                    id++;

                    break;

                case 3:
                    System.out.print("Id : ");
                    int idUpd = scanner.nextInt();
                    employeeService.update(idUpd);
                    break;
                default:
                    System.out.println("Number not available");
                    break;
            }
        }
    }
    public static void CustomerManagement(){
        Scanner scanner = new Scanner(System.in);

        id = customerService.findAll().size() + 1;
        while (true){
            System.out.println("1.Display list customers");
            System.out.println("2.Add new customer");
            System.out.println("3.Edit customer");
            System.out.println("4.Return main menu");
            System.out.println("-----------------------------");
            int select = scanner.nextInt();

            if (select == 4) {
                break;
            }

            switch (select){
                case 1:
                    System.out.println(customerService.findAll());
                    break;
                case 2:
                    System.out.print("Name : ");
                    String name = scanner.next();
                    System.out.print("DOB : ");
                    String dob = scanner.next();
                    System.out.print("Gender (Male, Female): ");
                    Person.Gender gender = Person.Gender.valueOf(scanner.next());
                    System.out.print("Identification : ");
                    int identification = scanner.nextInt();
                    System.out.print("PhoneNumber : ");
                    int phoneNumber = scanner.nextInt();
                    System.out.print("Email : ");
                    String email = scanner.next();
                    System.out.print("TypeOfCustomer (Diamond, Platinum, Gold, Silver, Member) : ");
                    Customer.TypeOfCustomer typeOfCustomer = Customer.TypeOfCustomer.valueOf(scanner.next());
                    System.out.print("Address : ");
                    String address = scanner.next();

                    Customer customer = new Customer(id,name,dob,gender,identification,phoneNumber,email,typeOfCustomer,address);
                    customerService.add(customer);
                    id++;

                    break;

                case 3:
                    System.out.print("Id : ");
                    int idUpd = scanner.nextInt();
                    customerService.update(idUpd);
                    break;
                default:
                    System.out.println("Number not available");
                    break;
            }
        }
    }
    public static void FacilityManagement(){
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("1.Display list facility");
            System.out.println("2.Add new facility");
            System.out.println("3.Display list facility maintenance");
            System.out.println("4.Return main menu");
            System.out.println("-----------------------------");
            int select = scanner.nextInt();

            if (select == 4) {
                break;
            }

            switch (select){
                case 1:
                    System.out.println(facilityService.findAll());
                    break;
                case 2:
                    facilityService.add();
                    break;
                case 3:
                    facilityService.findAllMaintenance();
                    break;
                default:
                    System.out.println("Number not available");
                    break;
            }
        }
    }
    public static void BookingManagement() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        while (true){
            System.out.println("1.Add new booking");
            System.out.println("2.Display list booking");
            System.out.println("3.Create new contracts");
            System.out.println("4.Display list contracts");
            System.out.println("5.Edit contracts");
            System.out.println("6.Return main menu");
            System.out.println("-----------------------------");
            id = bookingService.findAll().size() + 1;

            int select = scanner.nextInt();

            if (select == 6) {
                break;
            }

            switch (select){
                case 1:
                    System.out.println("**Customer List**");
                    for (Customer customer : customerService.findAll()) {
                        System.out.println(customer);
                    }
                    System.out.println("-----------------------------");

                    System.out.println("**Facility List**");
                    Set<Object> keySet = facilityService.findAll().keySet();
                    for (Object key : keySet) {
                        System.out.println(key + " : " + facilityService.findAll().get(key));
                    }
                    System.out.println("-----------------------------");

                    System.out.print("Id Customer : ");
                    int idCustomer = scanner.nextInt();
                    System.out.print("Start Date : ");
                    String startDate = scanner.next();
                    System.out.print("End Date : ");
                    String endDate = scanner.next();
                    System.out.print("Name Service : ");
                    String nameService = scanner.next();
                    System.out.print("Type Of Service : ");
                    String typeOfService = scanner.next();
                    Booking booking = new Booking(id,idCustomer,dateFormat.parse(startDate),dateFormat.parse(endDate),nameService,typeOfService);
                    bookingService.add(booking, customerService.findAll(), facilityService.findAll());
                    break;
                case 2:
                    System.out.println(bookingService.findAll());
                    break;
                case 3:
                    contractService.createContracts(bookingService.findAllBookingQueue());
                    break;
                case 4:
                    System.out.println(contractService.findAllContracts());
                    break;
                case 5:
                    System.out.println("Id booking : ");
                    int idUpd = scanner.nextInt();
                    contractService.update(idUpd);
                    break;
                default:
                    System.out.println("Number not available");
                    break;
            }
        }
    }
    public static void PromotionManagement(){
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("1.Display list customers use service");
            System.out.println("2.Display list customers get voucher");
            System.out.println("3.Return main menu");
            System.out.println("-----------------------------");
            int select = scanner.nextInt();

            if (select == 3) {
                break;
            }

            switch (select){
                case 1:
                    System.out.print("Year : ");
                    int year = scanner.nextInt();
                    promotionService.displayCustomersByYear(year,bookingService.findAll(),customerService.findAll());
                    break;
                case 2:
                    promotionService.generateVoucher(2,0,0,bookingService.findAll(),customerService.findAll());
                    break;
                default:
                    System.out.println("Number is available");
            }
        }
    }
    public static void displayMainMenu(){

        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("1.Employee Management");
            System.out.println("2.Customer Management");
            System.out.println("3.Facility Management");
            System.out.println("4.Booking Management");
            System.out.println("5.Promotion Management");
            System.out.println("6.Exit");

            int select = scanner.nextInt();
            switch (select){
                case 1:
                    EmployeeManagement();
                    break;
                case 2:
                    CustomerManagement();
                    break;
                case 3:
                    FacilityManagement();
                    break;
                case 4:
                    try {
                        BookingManagement();
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 5:
                    PromotionManagement();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Number not available");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        displayMainMenu();
    }
}
