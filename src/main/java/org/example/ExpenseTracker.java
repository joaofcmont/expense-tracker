package org.example;
import org.example.commands.AddExpense;
import picocli.CommandLine;
import picocli.CommandLine.Command;


@Command(name = "expense-tracker", description = "Expense tracker",
        subcommands = {
                AddExpense.class
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