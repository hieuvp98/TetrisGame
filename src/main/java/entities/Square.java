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
        playArena.getRows().get(indexRow).addSquare(this, indexCol);
        playArena.getColumns().get(indexCol).addSquare(this, indexRow);
    }

    @Override
    public void remove() {
        this.removable = true;
    }

    @Override
    public void move() {
        if (this.indexRow == 14) return;
        this.preIndexCol = this.indexCol;
        this.preIndexRow = this.indexRow;
        if ((directionX == 1 && indexCol < 14) || (directionX == -1 && indexCol > 0))
        this.indexCol += directionX;
        this.indexRow++;
    }

    @Override
    public void updateUI() {
        GameRowBase row = playArena.getRows().get(preIndexRow);
        row.removeSquare(this);
        GameColumnBase col = playArena.getColumns().get(preIndexCol);
        col.removeSquare(this);
        playArena.getRows().get(indexRow).addSquare(this, indexCol);
        playArena.getColumns().get(indexCol).addSquare(this, indexRow);
    }

    @Override
    public boolean checkMoveDown() {
        if (indexRow == 14) return false;
        return playArena.getColumns().get(this.indexCol).getSquareBases()[this.indexRow + 1] == null;
    }

    @Override
    public boolean checkMoveLeft() {
        if (indexCol == 1) return false;
        return playArena.getRows().get(this.indexRow).getSquareBases()[this.indexCol - 1] == null;
    }

    @Override
    public boolean checkMoveRight() {
        if (indexCol == 8) return false;
        return playArena.getRows().get(this.indexRow).getSquareBases()[this.indexCol + 1] == null;
    }

    @Override
    public void reLocate(int row, int col) {
        this.preIndexCol = this.indexCol;
        this.preIndexRow = this.indexRow;
        this.indexCol  = col;
        this.indexRow = row;
    }
}
