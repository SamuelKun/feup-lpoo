package com.aor.refactoring.example5;

public class Position {
    private int column;
    private int row;
    private char direction;

    public Position(int row, int column, char direction) {
        this.row = row;
        this.column = column;
        this.direction = direction;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public char getDirection() {
        return direction;
    }

    public void run(char command) {
        if (command == 'L') direction = rotateLeft(command);
        else if (command == 'R') direction = rotateRight(command);
        else {
            if (direction == 'N') row--;
            if (direction == 'S') row++;
            if (direction == 'W') column--;
            if (direction == 'E') column++;
        }
    }

    public char rotateLeft(char command) {
        if (direction == 'N') return 'W';
        if (direction == 'W') return 'S';
        if (direction == 'S') return 'E';
        if (direction == 'E') return 'N';

        return direction;
    }

    public char rotateRight(char command) {
        if (direction == 'N') return 'E';
        if (direction == 'E') return 'S';
        if (direction == 'S') return 'W';
        if (direction == 'W') return 'N';

        return direction;
    }
}
