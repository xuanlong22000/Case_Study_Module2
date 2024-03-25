package Case_Study.models;

public class Customer extends Person{

    private TypeOfCustomer typeOfCustomer;
    private String address;

    public enum TypeOfCustomer {
        Diamond, Platinum, Gold, Silver, Member
    }
    public Customer(int id, String name, String dob, Gender gender, int identification, int phoneNumber, String email, TypeOfCustomer typeOfCustomer, String address) {
        super(id, name, dob, gender, identification, phoneNumber, email);
        this.typeOfCustomer = typeOfCustomer;
        this.address = address;
    }

    public TypeOfCustomer getTypeOfCustomer() {
        return typeOfCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setTypeOfCustomer(TypeOfCustomer typeOfCustomer) {
        this.typeOfCustomer = typeOfCustomer;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                super.toString() +
                ", typeOfCustomer=" + typeOfCustomer +
                ", address='" + address + '\'' +
                "} " ;
    }
}
