package entities_abstract;

import java.util.ArrayList;

public abstract class GameColumnBase {

    protected ArrayList<SquareBase> squareBases;

    public abstract boolean checkFull();
}
