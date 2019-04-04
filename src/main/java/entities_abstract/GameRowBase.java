package entities_abstract;

import java.util.ArrayList;

public abstract class GameRowBase {

    protected ArrayList<SquareBase> squareBases;

    public abstract boolean checkFull();

    public abstract boolean remove();
}
