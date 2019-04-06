package entities;

import entities_abstract.GameColumnBase;
import entities_abstract.SquareBase;
import views.Controller;

import java.util.Arrays;

public class GameColumn extends GameColumnBase {

    public GameColumn(Controller playArenaBase, int indexCol) {
        super(playArenaBase, indexCol);
    }

    @Override
    public boolean checkFull() {
        int dem = 0;
        for (SquareBase squareBase : this.squareBases) {
            if (squareBase != null) dem++;
        }
        return dem == 15;
    }

    @Override
    public void addSquare(SquareBase square, int index) {
        this.squareBases[index] = square;
      //  this.playArenaBase.gridPane.add(square.getImageView(),indexCol,index);
    }

    @Override
    public void removeSquare(SquareBase square) {
        this.squareBases[Arrays.asList(this.squareBases).indexOf(square)] = null;
      //  this.playArenaBase.gridPane.getChildren().remove(square.getImageView());
    }
}