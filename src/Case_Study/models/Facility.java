package Case_Study.models;

import java.util.Date;

public abstract class Facility {
    private String name;
    private double area;
    private double price;
    private int MaxCustomers;
    private String typeRenting;

    public Facility(String name, double area, double price, int maxCustomers, String typeRenting) {
        this.name = name;
        this.area = area;
        this.price = price;
        MaxCustomers = maxCustomers;
        this.typeRenting = typeRenting;
    }

    public String getName() {
        return name;
    }

    public double getArea() {
        return area;
    }

    public double getPrice() {
        return price;
    }

    public int getMaxCustomers() {
        return MaxCustomers;
    }

    public String getTypeRenting() {
        return typeRenting;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setMaxCustomers(int maxCustomers) {
        MaxCustomers = maxCustomers;
    }

    public void setTypeRenting(String typeRenting) {
        this.typeRenting = typeRenting;
    }

    @Override
    public String toString() {
        return "name=" + name +
                ", area=" + area +
                ", price=" + price +
                ", MaxCustomers=" + MaxCustomers +
                ", typeRenting='" + typeRenting + '\'';
    }
}
