import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerID;
    private String name;
    private String contactNumber;
    private String email;
    private List<String> bookingHistory; // list of rentalIDs

    public Customer(String customerID, String name, String contactNumber, String email) {
        this.customerID = customerID;
        this.name = name;
        this.contactNumber = contactNumber;
        this.email = email;
        this.bookingHistory = new ArrayList<>();
    }
    public String getCustomerID() {
        return customerID;
    }
    public void addBooking(String rentalID) {
        bookingHistory.add(rentalID);
    }
    public void displayCustomer() {
        System.out.println("Customer ID: " + customerID);
        System.out.println("Name       : " + name);
        System.out.println("Contact    : " + contactNumber);
        System.out.println("Email      : " + email);
        System.out.println("Bookings   : " + bookingHistory);
    }
}