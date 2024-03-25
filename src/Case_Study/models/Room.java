package Case_Study.models;

public class Room extends Facility {

    private String freeService;

    public Room(String name, double area, double price, int maxCustomers, String typeRenting, String freeService) {
        super(name, area, price, maxCustomers, typeRenting);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return "Room{" +
                super.toString()+
                "freeService='" + freeService + '\'' +
                "}";
    }
}
