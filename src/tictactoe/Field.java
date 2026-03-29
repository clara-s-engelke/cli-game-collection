package tictactoe;

public class Field {
    private final int column;
    private final int row;

    public Field(int row, int col){
        column = col;
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }
}
