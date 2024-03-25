package Case_Study.models;

public class Villa extends Facility{

    private String roomStandard ;
    private double poolArea;
    private int numberOfFloor;

    public Villa(String name, double area, double price, int maxCustomers, String typeRenting, String roomStandard, double poolArea, int numberOfFloor) {
        super(name, area, price, maxCustomers, typeRenting);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.numberOfFloor = numberOfFloor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    @Override
    public String toString() {
        return "Villa{" +
                super.toString()+
                ", roomStandard='" + roomStandard + '\'' +
                ", poolArea=" + poolArea +
                ", numberOfFloor=" + numberOfFloor +
                "} ";
    }
}
