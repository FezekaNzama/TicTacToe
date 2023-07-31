package com.fezekanzama.Model;

public class Player {
    private String name;
    private Symbol symbol; 
    private int movesMade = 0;
    
    public Player(String name, Symbol symbol){
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return this.symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public int getMovesMade() {
        return this.movesMade;
    }

    public void setMovesMade() {
        movesMade ++;
    }
}
