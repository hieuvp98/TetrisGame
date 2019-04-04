package entities;

import entities_abstract.GameColumnBase;
import entities_abstract.GameRowBase;
import entities_abstract.PlayArenaBase;
import entities_abstract.SquareBase;

public class Square extends SquareBase {


    @Override
    public void addToPanel(GameRowBase row, GameColumnBase column) {
        this.row = row;
        this.column = column;

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
