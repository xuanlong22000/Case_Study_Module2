package Test.controllers;

import models.Person;
import models.Student;
import services.StudentServiceImp;

import java.util.Scanner;

public class StudentController {

    private static final StudentServiceImp studentService = new StudentServiceImp();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int id;
        try {
            id = studentService.displayStudent().get(studentService.displayStudent().size() - 1).getId() + 1;
        } catch (Exception e){
            id = 1;
        }

        while (true){
            System.out.println("1.Add student");
            System.out.println("2.Delete student");
            System.out.println("3.Display student list");
            System.out.println("4.Display teacher list");
            System.out.println("5.Search student");
            System.out.println("6.Exit");
            System.out.println("-----------------");

            int select = scanner.nextInt();

            switch (select){
                case 1:
                    try{
                        System.out.print("Name : ");
                        String name = scanner.next();
                        System.out.print("DOB : ");
                        String dob = scanner.next();
                        System.out.print("Gender ( Male ,Female ) : ");
                        Person.Gender gender = Person.Gender.valueOf(scanner.next());
                        System.out.print("Phone Number : ");
                        int phoneNumber = scanner.nextInt();
                        System.out.print("Id Class : ");
                        int idClassRoom = scanner.nextInt();

                        Student newStudent = new Student(id,name,dob,gender,phoneNumber,idClassRoom);

                        studentService.addStudent(newStudent);
                        id++;
                    } catch (Exception e){
                        System.out.println("Nhap lai !!");
                    }

                    break;
                case 2:
                    System.out.print("Id : ");
                    int idDelete = scanner.nextInt();
                    studentService.deleteStudent(idDelete);
                    break;
                case 3:
                    System.out.println(studentService.displayStudent());
                    break;
                case 4:
                    System.out.println(studentService.displayTeacher());
                    break;
                case 5:
                    System.out.print("Name : ");
                    String name = scanner.next();
                    studentService.searchStudent(name);
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Number not available");
                    break;
            }

        }

    }
}
