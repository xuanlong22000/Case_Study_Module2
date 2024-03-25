package Case_Study.models;

public abstract class Person {
    private int id;
    private String name;
    private String dob;
    private Gender gender;
    private int identification;
    private int phoneNumber;
    private String email;

    public enum Gender{
        Male,Female;
    }

    public Person(int id, String name, String dob, Gender gender, int identification, int phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.identification = identification;
        this.phoneNumber = phoneNumber;
        this.email = email;
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

    public int getIdentification() {
        return identification;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
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

    public void setIdentification(int identification) {
        this.identification = identification;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", gender='" + gender + '\'' +
                ", identification=" + identification +
                ", phoneNumber=" + phoneNumber +
                ", email=" + email ;
    }
}
