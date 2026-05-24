import java.util.ArrayList;
import java.util.List;

public class Finance {
    final private List<Double> incomes;
    final private List<Double> expenses;

    public Finance() {
        incomes = new ArrayList<>();
        expenses = new ArrayList<>();
    }
    public void addIncome(double x) {
        if (x > 0) incomes.add(x);
    }
    public void addExpense(double x) {
        if (x > 0) expenses.add(x);
    }
    public double totalIncome() {
        double total = 0.0;
        for (Double income : incomes) {
            total += income;
        }
        return total;
    }
    public double totalExpenses() {
        double total = 0.0;
        for (Double expense : expenses) {
            total += expense;
        }
        return total;
    }
    public double profit() {
        return totalIncome() - totalExpenses();
    }
    public void displaySummary() {
        System.out.println("=== FINANCE SUMMARY ===");
        System.out.println("Total Income  : " + totalIncome());
        System.out.println("Total Expenses: " + totalExpenses());
        System.out.println("Profit/Loss   : " + profit());
    }
}