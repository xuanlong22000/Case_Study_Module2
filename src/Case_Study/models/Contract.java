package Case_Study.models;

public class Contract extends Service {
    private int number;
    private double deposit;
    private double payment;

    public Contract(int idBooking, int idCustomer, int number, double deposit, double payment) {
        super(idBooking, idCustomer);
        this.number = number;
        this.deposit = deposit;
        this.payment = payment;
    }


    public int getNumber() {
        return number;
    }

    public double getDeposit() {
        return deposit;
    }

    public double getPayment() {
        return payment;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Contract{" +
                super.toString() +
                ", number=" + number +
                ", deposit=" + deposit +
                ", payment=" + payment +
                "} ";
    }
}
