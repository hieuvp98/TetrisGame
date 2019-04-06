package entities;

import entities_abstract.GameRowBase;
import entities_abstract.SquareBase;
import views.Controller;

public class GameRow extends GameRowBase {
    public GameRow(Controller playArenaBase, int index) {
        super(playArenaBase, index);
    }

    @Override
    public boolean checkFull() {
        return this.squareBases.size() == 10;
    }

    @Override
    public void remove() {
        this.squareBases.clear();
        for (int i = 0; i < 10; i++) {
            this.playArenaBase.gridPane.add(null, i, indexRow);
        }
    }

    @Override
    public void addSquare(SquareBase square, int index) {
        this.squareBases.add(index, square);
        this.playArenaBase.gridPane.add(square.getImageView(), index, this.indexRow);
    }

    @Override
    public void removeSquare(int index) {
        this.squareBases.remove(index);
        this.playArenaBase.gridPane.add(null, index, indexRow);
    }
}
