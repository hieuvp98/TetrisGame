package entities;

import entities_abstract.GameColumnBase;
import entities_abstract.GameRowBase;
import entities_abstract.SquareBase;
import views.Controller;

public class Square extends SquareBase {


    public Square(Controller playArena, int indexRow, int indexCol) {
        super(playArena, indexRow, indexCol);
    }

    @Override
    public void addToPanel() {
        playArena.getRows().get(indexRow).addSquare(this,indexRow);
        playArena.getColumns().get(indexCol).addSquare(this,indexCol);
    }

    @Override
    public void remove() {
        this.removable = true;
    }

    @Override
    public void move() {
        this.indexCol +=directionX;
        this.indexRow++;
    }

    @Override
    public void updateUI() {
        GameRowBase row = playArena.getRows().get(indexRow);
        row.removeSquare(row.getSquareBases().indexOf(this));
        GameColumnBase col = playArena.getColumns().get(indexCol);
        col.removeSquare(col.getSquareBases().indexOf(this));
        playArena.getRows().get(indexRow).addSquare(this,indexRow);
        playArena.getColumns().get(indexCol).addSquare(this,indexCol);
    }

    @Override
    public boolean checkMoveDown() {
        return playArena.getColumns().get(this.indexCol).getSquareBases().get(this.indexRow+1) == null;
    }

    @Override
    public boolean checkMoveLeft() {
        return playArena.getRows().get(this.indexRow).getSquareBases().get(this.indexCol-1) == null;
    }

    @Override
    public boolean checkMoveRight() {
        return playArena.getRows().get(this.indexRow).getSquareBases().get(this.indexCol+1) == null;
    }
}
