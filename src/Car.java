public class Car extends Vehicle {
    private int seats;
    private boolean hasAC;

    public Car(String vehicleID, String model, int year, double dailyRate, int seats, boolean hasAC) {
        super(vehicleID, "Car", model, year, dailyRate);
        this.seats = seats;
        this.hasAC = hasAC;
    }
    @Override
    public void displayInfo() {
        System.out.println("---- CAR ----");
        super.displayInfo();
        System.out.println("Seats     : " + seats);
        System.out.println("AC        : " + (hasAC ? "Yes" : "No"));
    }
}