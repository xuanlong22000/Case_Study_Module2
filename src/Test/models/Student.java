package Test.models;

public class Student extends Person{
    private int idClassRoom;

    public Student(int id, String name, String dob, Gender gender, int phoneNumber, int idClassRoom) {
        super(id, name, dob, gender, phoneNumber);
        this.idClassRoom = idClassRoom;
    }

    public int getIdClassRoom() {
        return idClassRoom;
    }

    public void setIdClassRoom(int idClassRoom) {
        this.idClassRoom = idClassRoom;
    }

    @Override
    public String toString() {
        return "Student{" +
                super.toString() +
                " ,idClassRoom=" + idClassRoom +
                "} ";
    }
}
