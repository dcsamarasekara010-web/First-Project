import java.time.LocalDate;

public class Booking {
    private static int nextId = 1;
    private String bookingID;
    private String customerID;
    private String vehicleID;
    private LocalDate bookingDate;
    private int numberOfDays;
    private String status; // Confirmed, Cancelled

    public Booking(String customerID, String vehicleID, LocalDate bookingDate, int numberOfDays) {
        this.bookingID = "B" + (nextId++);
        this.customerID = customerID;
        this.vehicleID = vehicleID;
        this.bookingDate = bookingDate;
        this.numberOfDays = numberOfDays;
        this.status = "Confirmed";
    }
    public String getBookingID() {
        return bookingID;
    }
    public String getVehicleID() {
        return vehicleID;
    }
    public String getCustomerID() {
        return customerID;
    }
    public String getStatus() {
        return status;
    }
    public LocalDate getBookingDate(){
        return bookingDate;
    }
    public int getNumberOfDays(){
        return numberOfDays;
    }
}