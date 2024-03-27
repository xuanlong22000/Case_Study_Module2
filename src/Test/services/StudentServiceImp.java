package Test.services;

import models.ClassRoom;
import models.Person;
import models.Student;
import models.Teacher;
import utils.NotFoundStudentException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class StudentServiceImp extends StudentServiceAbs{
    private final String FILE_PATH = "C:\\Users\\longb\\IdeaProjects\\Test_Module2\\src\\data\\student.csv";
    private final String FILE_PATH_BATCH = "C:\\Users\\longb\\IdeaProjects\\Test_Module2\\src\\data\\batchs.csv";

    private final String FILE_PATH_TEACHER = "C:\\Users\\longb\\IdeaProjects\\Test_Module2\\src\\data\\teacher.csv";

    List<Student> students = readFileStudent();
    List<ClassRoom> classRooms = readFileClassroom();
    List<Teacher> teachers = readFileTeacher();




    @Override
    public void addStudent(Student student) {

        for (int i = 0; i < classRooms.size(); i++) {
            if (classRooms.get(i).getId() == student.getIdClassRoom()) {
                writeFileStudent(student,true);
                students.add(student);
                System.out.println("--------");
                System.out.println("Success ! ");
                System.out.println("--------");

                return;
            }
        }

        System.out.println("Class is not available");
    }

    @Override
    public void deleteStudent(int id) {
        Scanner scanner = new Scanner(System.in);

        try{
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getId() == id){

                    System.out.print("Yes/No : ");
                    String choice = scanner.next();

                    if (choice.equals("Yes")){
                        students.remove(i);
                        for (int j = 0; j < students.size(); j++) {
                            writeFileStudent(students.get(j), j != 0);
                        }

                        System.out.println(this.displayStudent());
                        return;
                    } else {
                        return;
                    }

                }
            }

            throw new NotFoundStudentException("Sinh vien ko ton tai");
        } catch (NotFoundStudentException e){
            System.out.println(e);
        }

    }

    @Override
    public void searchStudent(String name) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().contains(name) ){
                System.out.println(students.get(i));
                return;
            }
        }

        System.out.println("Student is not available");
    }

    @Override
    public List<Student> displayStudent() {
        return students;
    }

    @Override
    public List<Teacher> displayTeacher() {
        return teachers;
    }


    public List<Student> readFileStudent() {
        List<Student> studentReader = new LinkedList<>();

        try{
            FileReader fileReader = new FileReader(FILE_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            String[] data;

            while((line = bufferedReader.readLine()) != null){
                data = line.split(",");
                Student newStudent = new Student(Integer.parseInt(data[0]) ,data[1] ,data[2], Person.Gender.valueOf(data[3]) ,Integer.parseInt(data[4]) , Integer.parseInt(data[5]));
                studentReader.add(newStudent);
            }

            bufferedReader.close();
        }catch (Exception e){
            System.out.println(e);
        }

        return studentReader;
    }

    public void writeFileStudent(Student studentWrite, boolean newData){
        try {
            FileWriter fileWriter = new FileWriter(FILE_PATH,newData);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(studentWrite.getId() + "," + studentWrite.getName() + "," + studentWrite.getDob()+ "," + studentWrite.getGender()+ "," + studentWrite.getPhoneNumber()+ "," + studentWrite.getIdClassRoom());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public List<ClassRoom> readFileClassroom() {
        List<ClassRoom> classRoomReader = new LinkedList<>();

        try{
            FileReader fileReader = new FileReader(FILE_PATH_BATCH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            String[] data;

            while((line = bufferedReader.readLine()) != null){
                data = line.split(",");
                ClassRoom newClassRoom = new ClassRoom(Integer.parseInt(data[0]),data[1],Integer.parseInt(data[2]));
                classRoomReader.add(newClassRoom);
            }

            bufferedReader.close();
        }catch (Exception e){
            System.out.println(e);
        }

        return classRoomReader;
    }

    public List<Teacher> readFileTeacher() {
        List<Teacher> teacherReader = new LinkedList<>();

        try{
            FileReader fileReader = new FileReader(FILE_PATH_TEACHER);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            String[] data;

            while((line = bufferedReader.readLine()) != null){
                data = line.split(",");
                Teacher newTeacher = new Teacher(Integer.parseInt(data[0]) ,data[1] ,data[2], Person.Gender.valueOf(data[3]) ,Integer.parseInt(data[4]));
                teacherReader.add(newTeacher);
            }

            bufferedReader.close();
        }catch (Exception e){
            System.out.println(e);
        }

        return teacherReader;
    }

}
