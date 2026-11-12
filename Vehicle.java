package vehicle.java;

public class Vehicle {
    private String name;
    private String type;
    private double value;
    private int capacity;
    public void setName(String name) {
        this.name = name;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setValue(double value) {
        this.value = value >= 0 ? value : 0;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity >=0 ? capacity : 0;
    }
    
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public double getValue() {
        return value;
    }
    public int getCapacity() {
        return capacity;
    }
    public Vehicle(String name, String type, double value, int capacity){
        setName(name);
        setType(type);
        setValue(value);
        setCapacity(capacity);
    }
    public double tax(){
        if(capacity < 100){
            return value * 0.01;
        }
        else if(capacity >=100 && capacity <=200){
            return value * 0.03;
        }
        else{
            return value *0.05;
        }
    }
    @Override
    public String toString(){
        return String.format("%15s %20s %20d %15.2f %15.2f",name,type,capacity,value,tax());
    }
    

}
