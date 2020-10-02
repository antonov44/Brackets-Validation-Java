package com.antonov.brackets;

import com.google.gson.annotations.SerializedName;

public class BracketsPair {
    //region Fields
    @SerializedName("left")
    private Character lBracket;
    @SerializedName("right")
    private Character rBracket;
    //endregion

    //region Constructors
    public BracketsPair() {
        setLBracket(null);
        setRBracket(null);
    }

    public BracketsPair(char lBracket, char rBracket) {
        setLBracket(lBracket);
        setRBracket(rBracket);
    }
    //endregion

    //region Setters
    private void setLBracket(Character lBracket) {
        this.lBracket = lBracket;
    }

    private void setRBracket(Character rBracket) {
        this.rBracket = rBracket;
    }
    //endregion

    //region Getters
    public Character getLBracket() {
        return lBracket;
    }

    public Character getRBracket() {
        return rBracket;
    }
    //endregion

    //region Main Methods [isEmpty(), getSelfOrEmptyFromChar(char ch),]
    public boolean isEmpty() {
        return (getLBracket() == null && getRBracket() == null);
    }

    public BracketsPair getSelfOrEmptyFromChar(char ch) {
        if (getLBracket() == ch || getRBracket() == ch) {
            return this;
        }
        return new BracketsPair();
    }
    //endregion

    //region Overridden Methods [toString(),]
    @Override
    public String toString() {
        return String.format("%c %c", getLBracket(), getRBracket());
    }
    //endregion
}
