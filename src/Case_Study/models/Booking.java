package Case_Study.models;

import java.util.Date;

public class Booking extends Service {
    private Date startDate;
    private Date endDate;
    private String nameService;
    private String typeOfService;


    public Booking(int idBooking, int idCustomer, Date startDate, Date endDate, String nameService, String typeOfService) {
        super(idBooking, idCustomer);
        this.startDate = startDate;
        this.endDate = endDate;
        this.nameService = nameService;
        this.typeOfService = typeOfService;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getNameService() {
        return nameService;
    }

    public String getTypeOfService() {
        return typeOfService;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public void setTypeOfService(String typeOfService) {
        this.typeOfService = typeOfService;
    }

    @Override
    public String toString() {
        return "Booking{" +
                super.toString()+
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", nameService='" + nameService + '\'' +
                ", typeOfService='" + typeOfService + '\'' +
                "} ";
    }
}
