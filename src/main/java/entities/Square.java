package entities;

import entities_abstract.GameColumnBase;
import entities_abstract.GameRowBase;
import entities_abstract.PlayArenaBase;
import entities_abstract.SquareBase;

public class Square extends SquareBase {


    public Square(GameColumnBase col, GameRowBase row, int index) {
        super(col, row, index);
    }

    @Override
    public void addToPanel(GameRowBase row, GameColumnBase column,int index) {
        this.row = row;
        this.column = column;
        column.addSquare(this);
        row.addSquare(this,index);
    }

    @Override
    public void remove() {
        this.removable = true;
    }

    @Override
    public void move() {
        this.positionX += directionX*stepX;
        this.positionY += stepY;

    }

    @Override
    public void updateUI() {

    }

    @Override
    public boolean checkMovable() {
        int colIndex = this.column.getSquareBases().indexOf(this);
        return this.column.getSquareBases().get(colIndex+1) == null;
    }
}
