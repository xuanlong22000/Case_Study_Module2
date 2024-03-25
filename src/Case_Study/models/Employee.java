package Case_Study.models;

public class Employee extends Person {

    private Qualifications qualifications;
    private Position position;
    private double salary;

    public enum Position {
        receptionist, server, specialist, supervisor, manager, supervisor_governor
    }

    public enum Qualifications {
        Intermediate, College, University , Postgraduate
    }



    public Employee(int id, String name, String dob, Gender gender, int identification, int phoneNumber, String email, Qualifications qualifications, Position position, double salary) {
        super(id, name, dob, gender, identification, phoneNumber, email);
        this.qualifications = qualifications;
        this.position = position;
        this.salary = salary;
    }

    public Qualifications getQualifications() {
        return qualifications;
    }

    public Position getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    public void setQualifications(Qualifications qualifications) {
        this.qualifications = qualifications;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                super.toString() +
                ", qualifications=" + qualifications +
                ", position=" + position +
                ", salary=" + salary +
                "} " ;
    }
}
