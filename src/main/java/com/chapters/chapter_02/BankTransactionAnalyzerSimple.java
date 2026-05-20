package com.chapters.chapter_02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankTransactionAnalyzerSimple {

    private static final String RESOURCES = "src/main/resources/";
    private static final String BANK_DATA = "bank-data-simple.csv";

    public static void main(final String[] args) throws IOException {

        final Path path = Paths.get(RESOURCES + BANK_DATA);
        final List<String> lines = Files.readAllLines(path);

        final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();
        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFromCSV(lines);

        final double total = calculateTotalAmount(bankTransactions);
        System.out.println("The total for all transactions is " + total);

        final Month month = Month.JANUARY;
        final List<BankTransaction> transactionsInSelectMonth = selectInMonth(bankTransactions, month);
        System.out.println("Transactions in " + month + ": " + transactionsInSelectMonth);
    }

    public static double calculateTotalAmount (final List<BankTransaction> bankTransactions) {

        double total = 0d;
        for (BankTransaction transaction : bankTransactions) {
            total += transaction.getAmount();
        }

        return total;
    }

    public static List<BankTransaction> selectInMonth (final List<BankTransaction> bankTransactions, Month month) {

        final List<BankTransaction> transactionsInMonth = new ArrayList<>();
        for (BankTransaction transaction : bankTransactions) {
            if (transaction.getDate().getMonth() == month) {
                transactionsInMonth.add(transaction);
            }
        }

        return transactionsInMonth;
    }
}
