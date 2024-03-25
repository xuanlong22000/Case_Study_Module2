package Case_Study.models;

public class House extends Facility{

    private String roomStandard ;
    private int numberOfFloor;

    public House(String name, double area, double price, int maxCustomers, String typeRenting, String roomStandard, int numberOfFloor) {
        super(name, area, price, maxCustomers, typeRenting);
        this.roomStandard = roomStandard;
        this.numberOfFloor = numberOfFloor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    @Override
    public String toString() {
        return "House{" +
                super.toString()+
                "roomStandard='" + roomStandard + '\'' +
                ", numberOfFloor=" + numberOfFloor +
                "}";
    }
}
