package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ExpenseService {

    private static final String FILE = "expenses.cvs";
    private static List<Expense> expenses = new ArrayList<>();
    private static int nextId = 1;

    public static void addExpense(Expense expense) {
        expense.setId(nextId++);
        expenses.add(expense);
        saveToFile();
    }

    public static List<Expense> getAllExpenses(){
        loadFromFile();
        return new ArrayList<>(expenses);
    }

    public static void deleteExpense(int id){
        expenses.removeIf(e -> e.getId() == id);
        saveToFile();
    }


    // Load/save logic here
    private static void saveToFile() {
        try(PrintWriter writer = new PrintWriter(new FileWriter(FILE))) {
            writer.println("ID,Date,Description,Amount");
            for(Expense e: expenses){
                writer.printf("%d,%s,%s,%d%n", e.getId(), e.getDate(), e.getDescription(), e.getAmount());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void loadFromFile() {

    }
}
