package com.aor.refactoring.example5;

public class Turtle {
    Position pos;

    public Turtle(int row, int column, char direction) {
        pos = new Position(row, column, direction);
    }

    public int getRow() {
        return pos.getRow();
    }

    public int getColumn() {
        return pos.getColumn();
    }

    public char getDirection() {
        return pos.getDirection();
    }

    public void execute(char command) {
        pos.run(command);
    }

}
