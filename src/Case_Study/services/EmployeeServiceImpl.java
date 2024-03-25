package Case_Study.services;

import Case_Study.models.Employee;
import Case_Study.models.Person;
import Text_File.CRUD.Product;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService{

    private final String FILE_PATH = "C:\\Users\\longb\\IdeaProjects\\Module2_Java\\src\\Case_Study\\data\\employee.csv";
    List<Employee> employees = readFile();
    @Override
    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public void add(Employee employee) {
        writeFile(employee,true);
        employees.add(employee);
    }

    @Override
    public void update(int id) {
        for (int i = 0; i < employees.size(); i++) {
            if(employees.get(i).getId() == id){
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
                System.out.print("Qualifications (Intermediate, College, University , Postgraduate) : ");
                Employee.Qualifications qualifications = Employee.Qualifications.valueOf(scanner.next());
                System.out.print("Position (receptionist, server, specialist, supervisor, manager, supervisor_governor) : ");
                Employee.Position position = Employee.Position.valueOf(scanner.next());
                System.out.print("Salary : ");
                double salary = scanner.nextDouble();

                employees.get(i).setName(name);
                employees.get(i).setDob(dob);
                employees.get(i).setGender(gender);
                employees.get(i).setIdentification(identification);
                employees.get(i).setPhoneNumber(phoneNumber);
                employees.get(i).setEmail(email);
                employees.get(i).setQualifications(qualifications);
                employees.get(i).setPosition(position);
                employees.get(i).setSalary(salary);
                for (int j = 0; j < employees.size(); j++) {
                    writeFile(employees.get(j), j != 0);
                }
                return;
            }

        }
        System.out.println("Employee is unavailable");
    }

    public ArrayList<Employee> readFile() {
        ArrayList<Employee> employeeReader = new ArrayList<>();

        try{
            FileReader fileReader = new FileReader(FILE_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            String[] data;

            while((line = bufferedReader.readLine()) != null){
                data = line.split(",");
                Employee employee = new Employee(
                        Integer.parseInt(data[0]),
                        data[1],
                        data[2],
                        Person.Gender.valueOf(data[3]) ,
                        Integer.parseInt(data[4]),
                        Integer.parseInt(data[5]) ,
                        data[6],
                        Employee.Qualifications.valueOf(data[7]) ,
                        Employee.Position.valueOf(data[8]) ,
                        Double.parseDouble(data[9])
                );
                employeeReader.add(employee);
            }

            bufferedReader.close();
        }catch (Exception e){
            System.out.println(e);
        }

        return employeeReader;
    }
    public void writeFile(Employee employeeWrite, boolean newData){
        try {
            FileWriter fileWriter = new FileWriter(FILE_PATH,newData);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(
                    employeeWrite.getId() + "," +
                            employeeWrite.getName() + "," +
                            employeeWrite.getDob()+ "," +
                            employeeWrite.getGender()+"," +
                            employeeWrite.getIdentification()+ "," +
                            employeeWrite.getPhoneNumber()+"," +
                            employeeWrite.getEmail()+"," +
                            employeeWrite.getQualifications()+"," +
                            employeeWrite.getPosition()+"," +
                            employeeWrite.getSalary());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
