package com.chapters.chapter_02;

import java.util.List;

public interface IBankStatementParser {
    BankTransaction parseFrom(String line);
    List<BankTransaction> parseLinesFrom(List<String> lines);
}
