package entities_abstract;

import java.util.ArrayList;

public abstract class GameRowBase {

    protected ArrayList<SquareBase> squareBases;

    public abstract boolean checkFull();

    public abstract boolean remove();

    public abstract void addSquare(SquareBase square,int index);

    public abstract void removeSquare(SquareBase square);

    public ArrayList<SquareBase> getSquareBases() {
        return squareBases;
    }

    public void setSquareBases(ArrayList<SquareBase> squareBases) {
        this.squareBases = squareBases;
    }
}
