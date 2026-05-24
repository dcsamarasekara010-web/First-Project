public class Bike extends Vehicle {
    private String bikeType;

    public Bike(String vehicleID, String model, int year, double dailyRate, String bikeType) {
        super(vehicleID, "Bike", model, year, dailyRate);
        this.bikeType = bikeType;
    }
    @Override
    public void displayInfo() {
        System.out.println("---- BIKE ----");
        super.displayInfo();
        System.out.println("BikeType  : " + bikeType);
    }
}