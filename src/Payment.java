import java.time.LocalDate;

public class Payment {
    private static int nextId = 1;
    private String paymentID;
    private String rentalID;
    private String customerID;
    private double amount;
    private LocalDate paymentDate;
    private String status; //Completed, Failed

    public Payment(String rentalID, String customerID, double amount) {
        this.paymentID = "P" + (nextId++);
        this.rentalID = rentalID;
        this.customerID = customerID;
        this.amount = amount;
        this.paymentDate = LocalDate.now();
        this.status = "Pending";
    }
    public String getStatus() {
        return status;
    }
    public void process() {
        if (amount <= 0) {
            status = "Failed";
        } else {
            status = "Completed";
        }
    }
    public void displayPayment() {
    System.out.println("--- Payment Details ---");
        System.out.println("Payment ID: " + paymentID);
        System.out.println("Rental ID : " + rentalID);
        System.out.println("Customer  : " + customerID);
        System.out.println("Amount    : " + amount);
        System.out.println("Date      : " + paymentDate);
        System.out.println("Status    : " + status);
    }
}