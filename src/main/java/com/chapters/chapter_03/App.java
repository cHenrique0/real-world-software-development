package com.chapters.chapter_03;

import java.io.IOException;

public class App {
    public static void main(final String... args) throws IOException {

        final String BANK_DATA = "bank-data-simple.csv";

        final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
        final IBankStatementParser bankStatementParser = new BankStatementCSVParser();

        bankStatementAnalyzer.analyze(BANK_DATA, bankStatementParser);
        
    }
}
