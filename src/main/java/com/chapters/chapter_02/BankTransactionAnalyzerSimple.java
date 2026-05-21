package com.chapters.chapter_02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankTransactionAnalyzerSimple {

    private static final String RESOURCES = "src/main/resources/";
    private static final String BANK_DATA = "bank-data-simple.csv";

    public static void main(final String[] args) throws IOException {

        final Path path = Paths.get(RESOURCES + BANK_DATA);
        final List<String> lines = Files.readAllLines(path);

        final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();
        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFromCSV(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        final double total = bankStatementProcessor.calculateTotalAmount();
        System.out.println("The total for all transactions is " + total);

        final Month month1 = Month.JANUARY;
        final double totalInMonth1 = bankStatementProcessor.calculateTotalInMonth(month1);
        System.out.println("The total for transactions in " + month1 + ": " + totalInMonth1);

        final Month month2 = Month.FEBRUARY;
        final double totalInMonth2 = bankStatementProcessor.calculateTotalInMonth(month2);
        System.out.println("The total for transactions in " + month2 + ": " + totalInMonth2);

        final String category = "Salary";
        final double totalInCategory = bankStatementProcessor.calculateTotalForCategory(category);
        System.out.println("The total for transactions in " + category + ": " + totalInCategory);
    }
}
