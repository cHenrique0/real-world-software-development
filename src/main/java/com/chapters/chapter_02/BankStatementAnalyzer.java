package com.chapters.chapter_02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {
    private final String RESOURCES = "src/main/resources/";

    public void analyze(final String fileName, final IBankStatementParser bankStatementParser) throws IOException {

        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
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
