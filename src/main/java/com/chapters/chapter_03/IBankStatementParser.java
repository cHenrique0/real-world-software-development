package com.chapters.chapter_03;

import java.util.List;

public interface IBankStatementParser {
    BankTransaction parseFrom(String line);
    List<BankTransaction> parseLinesFrom(List<String> lines);
}
