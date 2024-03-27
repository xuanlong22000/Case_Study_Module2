package Test.services;

import models.Student;
import models.Teacher;

import java.util.LinkedList;
import java.util.List;

public abstract class StudentServiceAbs {
    abstract public void addStudent(Student student);
    abstract public void deleteStudent(int id);

    abstract public void searchStudent(String name);

    abstract public List<Student> displayStudent();

    abstract public List<Teacher> displayTeacher();

}
