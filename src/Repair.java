import java.time.LocalDate;

public class Repair {
    private static int nextId = 1;
    final private String repairID;
    final private String vehicleID;
    final private String description;
    final private LocalDate repairDate;
    final private double cost;
    final private String mechanic;
    final private String status; // Pending/Completed

    public Repair(String vehicleID, String description, LocalDate repairDate, double cost, String mechanic) {
        this.repairID = "REP" + (nextId++);
        this.vehicleID = vehicleID;
        this.description = description;
        this.repairDate = repairDate;
        this.cost = cost;
        this.mechanic = mechanic;
        this.status = "Pending";
    }
}