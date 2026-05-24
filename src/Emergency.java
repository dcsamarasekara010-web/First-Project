import java.time.LocalDateTime;

public class Emergency {
    private static int nextId = 1;
    private String emergencyID;
    private String rentalID;
    private String vehicleID;
    private String customerID;
    private String emergencyType; // Breakdown, Accident, Medical, etc.
    private String location;
    private LocalDateTime reportTime;
    private String responseStatus; // Pending/Resolved

    public Emergency(String rentalID, String vehicleID, String customerID, String emergencyType, String location) {
        this.emergencyID = "E" + (nextId++);
        this.rentalID = rentalID;
        this.vehicleID = vehicleID;
        this.customerID = customerID;
        this.emergencyType = emergencyType;
        this.location = location;
        this.reportTime = LocalDateTime.now();
        this.responseStatus = "Pending";
    }
    public void displayEmergency() {
        System.out.println("Emergency ID: " + emergencyID);
        System.out.println("Rental ID   : " + rentalID);
        System.out.println("Vehicle ID  : " + vehicleID);
        System.out.println("Customer ID : " + customerID);
        System.out.println("Type        : " + emergencyType);
        System.out.println("Location    : " + location);
        System.out.println("Reported at : " + reportTime);
        System.out.println("Status      : " + responseStatus);
    }
}