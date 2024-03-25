package Case_Study.models;

public abstract class Service {
    private int idBooking;
    private int idCustomer;

    public Service(int idBooking, int idCustomer) {
        this.idBooking = idBooking;
        this.idCustomer = idCustomer;
    }


    public int getIdBooking() {
        return idBooking;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    @Override
    public String toString() {
        return "idBooking=" + idBooking +
                ", idCustomer=" + idCustomer;
    }
}
