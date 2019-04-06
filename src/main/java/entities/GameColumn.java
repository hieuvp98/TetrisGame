package entities;

import entities_abstract.GameColumnBase;
import entities_abstract.SquareBase;
import views.Controller;

public class GameColumn extends GameColumnBase {

    public GameColumn(Controller playArenaBase, int indexCol) {
        super(playArenaBase, indexCol);
    }

    @Override
    public boolean checkFull() {
        return this.squareBases.size() == this.playArenaBase.getRows().size();
    }

    @Override
    public void addSquare(SquareBase square, int index) {
        this.squareBases.add(index,square);
        this.playArenaBase.gridPane.add(square.getImageView(),indexCol,index);
    }

    @Override
    public void removeSquare(int index) {
        this.squareBases.remove(index);
        this.playArenaBase.gridPane.add(null,indexCol,index);
    }
}
