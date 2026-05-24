import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    static List<Vehicle> vehicles = new ArrayList<>();
    static List<Customer> customers = new ArrayList<>();
    static List<Booking> bookings = new ArrayList<>();
    static List<Rental> rentals = new ArrayList<>();
    static List<Payment> payments = new ArrayList<>();
    static List<Repair> repairs = new ArrayList<>();
    static List<Emergency> emergencies = new ArrayList<>();
    static Finance finance = new Finance();

    public static void main(String[] args) {
        seedData();
        int choice;
        do {
            printMenu();
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println("Invalid input! Please enter a number from the Menu.");
                sc.nextLine();
                choice = 0;
                continue;
            }
            switch (choice) {
                case 1:
                    viewVehicles();
                    break;
                case 2:
                    addVehicle();
                    break;
                case 3:
                    registerCustomer();
                    break;
                case 4:
                    viewCustomers();
                    break;
                case 5:
                    makeBooking();
                    break;
                case 6:
                    confirmBookingToRental();
                    break;
                case 7:
                    processPayment();
                    break;
                case 8:
                    addRepair();
                    break;
                case 9:
                    reportEmergency();
                    break;
                case 10:
                    displayEmergency();
                    break;
                case 11:
                    finance.displaySummary();
                    break;
                case 12:
                    System.out.println("Exit.");
                    break;
                default:
                System.out.println("Invalid choice.");
            }
        } while (choice != 12);
    }
    static void printMenu() {
        System.out.println("\n--- VEHICLE RENTAL MENU ---");
        System.out.println(" 1. View All Vehicles");
        System.out.println(" 2. Add Vehicle");
        System.out.println(" 3. Register Customer");
        System.out.println(" 4. View Customers");
        System.out.println(" 5. Make Booking");
        System.out.println(" 6. Confirm Booking (create Rental)");
        System.out.println(" 7. Process Payment for Rental");
        System.out.println(" 8. Add Repair Vehical");
        System.out.println(" 9. Report Emergency");
        System.out.println("10. View Emergency Report");
        System.out.println("11. View Finance Summary");
        System.out.println("12. Exit");
        System.out.println(" ");
        System.out.print("Enter Choice: ");
    }

    static void seedData() {
        vehicles.add(new Car("C001","Toyota Axio",2018,5000,5,true));
        vehicles.add(new Car("C002","Suzuki Wagon R",2017,4500,5,true));
        vehicles.add(new Bike("B001","Honda Dio",2020,1500,"Scooter"));
        vehicles.add(new Bike("B002","Honda XR",2019,1800,"Sports"));

        customers.add(new Customer("CU001","Kasun","+94774567789","kasun111@example.com"));
        customers.add(new Customer("CU002","Nimal","+94721237788","nimal222@example.com"));
        customers.add(new Customer("CU003","Chathumi","+9478789779010","chathumi333@example.com"));
    }
    static void viewVehicles() {
        for (Vehicle v : vehicles) {
            v.displayInfo();
            System.out.println("----------------------");
        }
    }
    static void addVehicle() {
        System.out.print("Type (car/bike): ");
        String type = sc.nextLine().trim().toLowerCase();

        System.out.print("Vehicle ID: ");
        String id = sc.nextLine().trim();

        System.out.print("Model: ");
        String model = sc.nextLine().trim();

        System.out.print("Year: ");
        int year = sc.nextInt();

        System.out.print("Daily Rate: ");
        double rate = sc.nextDouble();
        sc.nextLine();

        if (type.equals("car")) {

            System.out.print("Seats: ");
            int seats = sc.nextInt();

            System.out.print("Has AC (true/false): ");
            boolean ac = sc.nextBoolean();
            sc.nextLine();

            vehicles.add(new Car(id, model, year, rate, seats, ac));
        } else if (type.equals("bike")) {

            System.out.print("Bike type (scooter/sports): ");
            String btype = sc.nextLine().trim();
            vehicles.add(new Bike(id, model, year, rate, btype));

        } else {
            System.out.println("Unknown type. Aborted.");
            return;
        }
        System.out.println("Vehicle added.");
    }
    static void registerCustomer() {
        System.out.print("Customer ID: ");
        String id = sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Contact: ");
        String contact = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        customers.add(new Customer(id, name, contact, email));
        System.out.println("Customer registered.");
    }
    static void viewCustomers() {
        for (Customer v : customers) {
            v.displayCustomer();
            System.out.println("----------------------");
        }
    }
    static Customer findCustomer(String id) {
        for (Customer c : customers) if (c.getCustomerID().equals(id)) return c;
        return null;
    }
    static Vehicle findVehicle(String id) {
        for (Vehicle v : vehicles) if (v.getVehicleID().equals(id)) return v;
        return null;
    }
    static void makeBooking() {
        System.out.print("Customer ID: ");
        String cu = sc.nextLine();
        Customer customer = findCustomer(cu);
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        System.out.print("Vehicle ID: ");
        String vid = sc.nextLine();
        Vehicle vehicle = findVehicle(vid);
        if (vehicle == null) {
            System.out.println("Vehicle not found.");
            return;
        }

        if (!vehicle.isAvailable()) {
            System.out.println("Vehicle not available.");
            return;
        }
        System.out.print("Booking Date (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(sc.nextLine());

        System.out.print("Number of days: ");
        int days = sc.nextInt(); sc.nextLine();

        Booking b = new Booking(customer.getCustomerID(), vehicle.getVehicleID(), date, days);
        bookings.add(b);
        System.out.println("Booking ID made: " + b.getBookingID());
    }

    static Booking findBooking(String id) {
        for (Booking b : bookings) if (b.getBookingID().equals(id)) return b;
        return null;
    }
    static void confirmBookingToRental() {
        System.out.print("Enter Booking ID to confirm: ");
        String bid = sc.nextLine();
        Booking b = findBooking(bid);

        if (b == null) {
            System.out.println("Booking not found.");
            return;
        }
        if (b.getStatus().equals("Cancelled")) {
            System.out.println("Booking cancelled.");
            return;
        }
        Vehicle v = findVehicle(b.getVehicleID());
        if (v == null || !v.isAvailable()) {
            System.out.println("Vehicle unavailable.");
            return;
        }
        // assume bookingDate is start date and numberOfDays -> calculate endDate
        LocalDate start = b.getBookingDate();
        LocalDate end = start.plusDays(b.getNumberOfDays()-1);


        Rental r = new Rental(b.getCustomerID(), b.getVehicleID(), start,end,v.getDailyRate());
        rentals.add(r);
        v.setAvailable(false);

        Customer c = findCustomer(b.getCustomerID());
        if (c != null) c.addBooking(r.getRentalID());
        System.out.println("RentalID created: " + r.getRentalID());
    }
    static Rental findRental(String id) {
        for (Rental r : rentals) if (r.getRentalID().equals(id)) return r;
        return null;
    }
    static void processPayment() {
        System.out.print("Enter Rental ID: ");
        String rid = sc.nextLine();
        Rental r = findRental(rid);
        if (r == null) {
            System.out.println("Rental not found."); return;
        }

        Payment p = new Payment(r.getRentalID(), r.getCustomerID(), r.getTotalCost());
        p.process();
        payments.add(p);
        if (p.getStatus().equals("Completed")) {
            r.setPaymentStatus("Completed");
            finance.addIncome(r.getTotalCost());
            System.out.println("Payment completed.");
        } else {
            System.out.println("Payment failed.");
        }
        p.displayPayment();
    }
    static void addRepair() {
        System.out.print("Vehicle ID: ");
        String vid = sc.nextLine();
        Vehicle v = findVehicle(vid);

        if (v == null) {
            System.out.println("Vehicle not found.");
            return;
        }
        System.out.print("Description: ");
        String desc = sc.nextLine();

        System.out.print("Cost: ");
        double cost = sc.nextDouble();
        sc.nextLine();

        System.out.print("Mechanic: ");
        String mec = sc.nextLine();

        Repair rep = new Repair(vid, desc, LocalDate.now(), cost, mec);
        repairs.add(rep);
        v.setAvailable(false);
        finance.addExpense(cost);
        System.out.println("Repair logged: " + vid);
    }
    static void reportEmergency() {
        System.out.print("Rental ID: ");
        String rid = sc.nextLine();
        Rental r = findRental(rid);

        if (r == null) {
            System.out.println("Rental not found.");
            return;
        }
        System.out.print("Vehicle ID: ");
        String vid = sc.nextLine();

        System.out.print("Customer ID: ");
        String cid = sc.nextLine();

        System.out.print("Type: ");
        String type = sc.nextLine();

        System.out.print("Location: ");
        String loc = sc.nextLine();

        Emergency em = new Emergency(rid, vid, cid, type, loc);
        emergencies.add(em);
        System.out.println("Emergency reported. ID created.");
    }
    static void displayEmergency() {
        for (Emergency v : emergencies) {
            v.displayEmergency();
            System.out.println("----------------------");
        }
    }
}
