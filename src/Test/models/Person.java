package Test.models;

public abstract class Person {
    private int id;
    private String name;
    private String dob;
    private Gender gender;
    private int phoneNumber;

    public enum Gender{
        Male,Female
    }

    public Person(int id, String name, String dob, Gender gender, int phoneNumber) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

     public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public Gender getGender() {
        return gender;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name=" + name +
                ", dob='" + dob + '\'' +
                ", gender=" + gender +
                ", phoneNumber=" + phoneNumber ;
    }
}
