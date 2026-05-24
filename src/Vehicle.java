
public class Vehicle {
    String vehicleID;
    String type;
    String model;
    int year;
    double dailyRate;
    boolean available; // true = available, false = rented/under repair

    public Vehicle(String vehicleID, String type, String model, int year, double dailyRate) {
        this.vehicleID = vehicleID;
        this.type = type;
        this.model = model;
        this.year = year;
        this.dailyRate = dailyRate;
        this.available = true;
    }
    public String getVehicleID() {
        return vehicleID;
    }
    public double getDailyRate() {
        return dailyRate;
    }
    public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
    // Using method overridden (polymorphism)
    public void displayInfo() {
        System.out.println("Vehicle ID: " + vehicleID);
        System.out.println("Type      : " + type);
        System.out.println("Model     : " + model);
        System.out.println("Year      : " + year);
        System.out.println("DailyRate : " + dailyRate);
        System.out.println("Available : " + (available ? "Yes" : "No"));
    }
}