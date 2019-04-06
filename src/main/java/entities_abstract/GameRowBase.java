package entities_abstract;

import views.Controller;

import java.util.ArrayList;

public abstract class GameRowBase {

    protected ArrayList<SquareBase> squareBases;

    protected Controller playArenaBase;

    protected int indexRow;

    public GameRowBase(Controller playArenaBase, int index) {
        this.playArenaBase = playArenaBase;
        this.squareBases = new ArrayList<>();
        this.squareBases.ensureCapacity(10);
        this.indexRow = index;
    }

    public abstract boolean checkFull();

    public abstract void remove();

    public abstract void addSquare(SquareBase square,int index);

    public abstract void removeSquare(int index);

    public ArrayList<SquareBase> getSquareBases() {
        return squareBases;
    }

    public void setSquareBases(ArrayList<SquareBase> squareBases) {
        this.squareBases = squareBases;
    }

    public int getIndex() {
        return indexRow;
    }

    public void setIndex(int index) {
        this.indexRow = index;
    }
}
