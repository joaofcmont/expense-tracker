package org.example.commands;

import org.example.Expense;
import org.example.ExpenseService;
import picocli.CommandLine;
import picocli.CommandLine.Option;

import java.time.LocalDate;

@CommandLine.Command(name = "add", description = "Add expense")
public class AddExpense implements Runnable {

    @Option(names = "--description", required = true, description = "Expense description")
    String description;

    @Option(names = "--amount", required = true, description = "Expense amount")
    int amount;

    @Override
    public void run() {
        Expense expense = new Expense(1, LocalDate.now(), description, amount);
        ExpenseService.addExpense(expense);
        System.out.println("✅ Saved: " + expense);
    }
}
