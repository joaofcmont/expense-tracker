package org.example;
import org.example.commands.AddExpense;
import org.example.commands.DeleteExpense;
import org.example.commands.ListExpenses;
import org.example.commands.Summary;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;


@Command(name = "expense-tracker", description = "Expense tracker",
        subcommands = {
                AddExpense.class,
                ListExpenses.class,
                DeleteExpense.class,
                Summary.class
        })
public class ExpenseTracker implements Runnable{

    @Override
    public void run() {
        // Default: show help when no subcommand
        CommandLine.usage(this, System.out);
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new ExpenseTracker()).execute(args);
        System.exit(exitCode);
    }

}