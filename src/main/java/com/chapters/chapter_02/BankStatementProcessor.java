package com.chapters.chapter_02;

import java.time.Month;
import java.util.List;
import java.util.Objects;

public class BankStatementProcessor {
    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(final List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public double calculateTotalAmount () {

        double total = 0d;
        for (BankTransaction transaction : bankTransactions) {
            total += transaction.getAmount();
        }

        return total;
    }

    public double calculateTotalInMonth (Month month) {

        double totalInMonth = 0d;
        for (BankTransaction transaction : bankTransactions) {
            if (transaction.getDate().getMonth() == month) {
                totalInMonth += transaction.getAmount();
            }
        }

        return totalInMonth;
    }

    public double calculateTotalForCategory (String category) {

        double totalInCategory = 0d;
        for (BankTransaction transaction : bankTransactions) {
            if (transaction.getDescription().equals(category)) {
                totalInCategory += transaction.getAmount();
            }
        }

        return totalInCategory;
    }
}
