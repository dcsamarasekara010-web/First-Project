import java.time.LocalDate;

public class Rental {
    private static int nextId = 1;
    private String rentalID;
    private String customerID;
    private String vehicleID;
    private LocalDate startDate;
    private LocalDate endDate;
    long totalDays;
    double totalCost;
    private String paymentStatus; // Pending/Completed

    public Rental(String customerID, String vehicleID, LocalDate startDate, LocalDate endDate, double ratePerDay) {
        this.rentalID = "R" + (nextId++);
        this.customerID = customerID;
        this.vehicleID = vehicleID;
        this.startDate = startDate;
        this.endDate = endDate;
        long daysDifference = endDate.toEpochDay() - startDate.toEpochDay();
        this.totalDays = daysDifference + 1;

        if (this.totalDays < 1)
            this.totalDays = 1;

        this.totalCost = this.totalDays * ratePerDay;
        this.paymentStatus = "Pending";
    }
    public String getRentalID() {
        return rentalID;
    }
    public String getCustomerID() {
        return customerID;
    }
    public double getTotalCost() {
        return totalCost;
    }
    public void setPaymentStatus(String completed) {
        this.paymentStatus = completed;
    }
}