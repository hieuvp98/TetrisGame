package entities_abstract;

import entities.Square;

import java.util.ArrayList;

public abstract class GameColumnBase {

    protected ArrayList<SquareBase> squareBases;

    public abstract boolean checkFull();

    public abstract void addSquare(SquareBase square);

    public abstract void removeSquare(SquareBase square);

    public ArrayList<SquareBase> getSquareBases() {
        return squareBases;
    }

    public void setSquareBases(ArrayList<SquareBase> squareBases) {
        this.squareBases = squareBases;
    }
}
