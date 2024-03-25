package Case_Study.services;

import Case_Study.models.Customer;
import Case_Study.models.Employee;
import Case_Study.models.Person;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService{
    private final String FILE_PATH = "C:\\Users\\longb\\IdeaProjects\\Module2_Java\\src\\Case_Study\\data\\customer.csv";

    List<Customer> customers = readFile();
    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public void add(Customer customer) {
        writeFile(customer,true);
        customers.add(customer);
    }

    @Override
    public void update(int id) {
        for (int i = 0; i < customers.size(); i++) {
            if(customers.get(i).getId() == id){
                Scanner scanner = new Scanner(System.in);
                System.out.print("Name : ");
                String name = scanner.next();
                System.out.print("DOB : ");
                String dob = scanner.next();
                System.out.print("Gender (Male, Female) : ");
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

                customers.get(i).setName(name);
                customers.get(i).setDob(dob);
                customers.get(i).setGender(gender);
                customers.get(i).setIdentification(identification);
                customers.get(i).setPhoneNumber(phoneNumber);
                customers.get(i).setEmail(email);
                customers.get(i).setTypeOfCustomer(typeOfCustomer);
                customers.get(i).setAddress(address);

                for (int j = 0; j < customers.size(); j++) {
                    writeFile(customers.get(j), j != 0);
                }
                return;
            }
        }
        System.out.println("Customer is unavailable");

    }

    public LinkedList<Customer> readFile() {
        LinkedList<Customer> customerReader = new LinkedList<>();

        try{
            FileReader fileReader = new FileReader(FILE_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            String[] data;

            while((line = bufferedReader.readLine()) != null){
                data = line.split(",");
                Customer customer = new Customer(
                        Integer.parseInt(data[0]),
                        data[1],
                        data[2],
                        Person.Gender.valueOf(data[3]) ,
                        Integer.parseInt(data[4]),
                        Integer.parseInt(data[5]) ,
                        data[6],
                        Customer.TypeOfCustomer.valueOf(data[7]),
                        data[8]
                );
                customerReader.add(customer);
            }

            bufferedReader.close();
        }catch (Exception e){
            System.out.println(e);
        }

        return customerReader;
    }
    public void writeFile(Customer customerWrite, boolean newData){
        try {
            FileWriter fileWriter = new FileWriter(FILE_PATH,newData);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(
                    customerWrite.getId() + "," +
                            customerWrite.getName() + "," +
                            customerWrite.getDob()+ "," +
                            customerWrite.getGender()+"," +
                            customerWrite.getIdentification()+ "," +
                            customerWrite.getPhoneNumber()+"," +
                            customerWrite.getEmail()+"," +
                            customerWrite.getTypeOfCustomer()+"," +
                            customerWrite.getAddress());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }

}
