package com.chapters.chapter_03;

@FunctionalInterface
public interface IBankTransactionFilter {
    boolean test(final BankTransaction bankTransaction);
}
