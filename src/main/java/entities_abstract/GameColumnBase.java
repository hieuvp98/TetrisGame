package entities_abstract;

import entities.Square;
import views.Controller;

import java.util.ArrayList;

public abstract class GameColumnBase {

    protected ArrayList<SquareBase> squareBases;

    protected Controller playArenaBase;

    protected int indexCol;

    public GameColumnBase(Controller playArenaBase,int indexCol) {
        this.playArenaBase = playArenaBase;
        squareBases = new ArrayList<>();
        squareBases.ensureCapacity(15);
        this.indexCol = indexCol;
    }

    public abstract boolean checkFull();

    public abstract void addSquare(SquareBase square, int index);

    public abstract void removeSquare(int index);

    public ArrayList<SquareBase> getSquareBases() {
        return squareBases;
    }

    public void setSquareBases(ArrayList<SquareBase> squareBases) {
        this.squareBases = squareBases;
    }

    public int getIndexCol() {
        return indexCol;
    }

    public void setIndexCol(int indexCol) {
        this.indexCol = indexCol;
    }
}
