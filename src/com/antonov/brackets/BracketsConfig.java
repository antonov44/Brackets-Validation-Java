package com.antonov.brackets;

import com.google.gson.annotations.SerializedName;

public class BracketsConfig {
    //region Fields
    @SerializedName("brackets")
    private BracketsPair[] bracketsPairs;
    //endregion

    //region Constructors
    public BracketsConfig() {
        setBracketsPairs(null);
    }

    public BracketsConfig(BracketsPair[] bracketsPairs) {
        setBracketsPairs(bracketsPairs);
    }
    //endregion

    //region Setters
    private void setBracketsPairs(BracketsPair[] bracketsPairs) {
        this.bracketsPairs = bracketsPairs;
    }
    //endregion

    //region Getters
    public BracketsPair[] getBracketsPairs() {
        return bracketsPairs;
    }
    //endregion

    //region Main Methods [isEmpty(), getBracketsPairOrEmptyFromChar(char ch),]
    public boolean isEmpty() {
        return getBracketsPairs() == null;
    }

    public BracketsPair getBracketsPairOrEmptyFromChar(char ch) {
        for (BracketsPair bracketsPair : getBracketsPairs()) {
            if (!bracketsPair.getSelfOrEmptyFromChar(ch).isEmpty()) {
                return bracketsPair;
            }
        }
        return new BracketsPair();
    }
    //endregion

    //region Overridden Methods [toString(),]
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (BracketsPair bracketsPair : getBracketsPairs()) {
            sb.append(bracketsPair);
        }
        return sb.toString();
    }
    //endregion
}
