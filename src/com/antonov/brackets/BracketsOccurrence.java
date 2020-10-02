package com.antonov.brackets;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BracketsOccurrence {
    //region Fields
    private BracketsPair bracketsPair;
    private Long index;
    private Boolean isLeft;
    //endregion

    //region Constructors
    public BracketsOccurrence() {
        setBracketsPair(null);
        setIndex(null);
        setIsLeft(null);
    }

    public BracketsOccurrence(BracketsPair bracketsPair, long index, boolean isLeft) {
        setBracketsPair(bracketsPair);
        setIndex(index);
        setIsLeft(isLeft);
    }
    //endregion

    //region Setters
    private void setBracketsPair(BracketsPair bracketsPair) {
        this.bracketsPair = bracketsPair;
    }

    private void setIndex(Long index) {
        this.index = index;
    }

    private void setIsLeft(Boolean isLeft) {
        this.isLeft = isLeft;
    }
    //endregion

    //region Getters
    public BracketsPair getBracketsPair() {
        return bracketsPair;
    }

    public Long getIndex() {
        return index;
    }

    public Boolean getIsLeft() {
        return isLeft;
    }
    //endregion

    //region Main Methods [isEmpty(),]
    public boolean isEmpty() {
        return (getBracketsPair() == null && getIndex() == null && getIsLeft() == null);
    }

    public void printErrorValidation(File file) throws IOException {
        FileReader reader = new FileReader(file);
        StringBuilder sb = new StringBuilder();

        long start = Math.max(getIndex() - 10, 0);
        long end = Math.min(getIndex() + 10, file.length());

        sb.append("\"");

        if (start > 0) {
            sb.append("...");
        }

        for (long i = 0; i < end; i++) {
            char ch = (char) reader.read();
            if (i >= start) {
                if (i == getIndex()) {
                    sb.append("\u001B[31m").append(ch).append("\u001B[0m");
                } else {
                    sb.append(ch);
                }
            }
        }

        if (end < file.length()) {
            sb.append("...");
        }

        sb.append("\"");

        System.out.println(sb.toString());
        System.out.printf("Error occurrence on %d index in source file.\n", getIndex());
        System.out.println(getIsLeft()? "No right (close) bracket error!": "No left (open) bracket error!");
    }
    //endregion

    //region Overridden Methods
    @Override
    public String toString() {
        return "Brackets Pair: " + getBracketsPair() + "\n" +
                "Index: " + getIndex() + "\n" +
                "Is Left: " + getIsLeft() + "\n";

    }
    //endregion
}
