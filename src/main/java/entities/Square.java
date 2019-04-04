package entities;

import entities_abstract.GameColumnBase;
import entities_abstract.GameRowBase;
import entities_abstract.PlayArenaBase;
import entities_abstract.SquareBase;

public class Square extends SquareBase {


    @Override
    public void addToPanel(GameRowBase row, GameColumnBase column,int index) {
        this.row = row;
        this.column = column;
        column.addSquare(this);
        row.addSquare(this,index);
    }

    @Override
    public void remove() {

    }

    @Override
    public void move() {

    }

    @Override
    public void updateUI() {

    }
}
