package Assignments.Assignment_5;
public class Animal {

    private String name;
    private String type;
    private int ArrivalOrder;

    public Animal(String name, String type, int arrivalOrder) {
        this.name = name;
        this.type = type;
        this.ArrivalOrder = arrivalOrder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getArrivalOrder() {
        return ArrivalOrder;
    }

    public void setArrivalOrder(int arrivalOrder) {
        ArrivalOrder = arrivalOrder;
    }
    
    
}
