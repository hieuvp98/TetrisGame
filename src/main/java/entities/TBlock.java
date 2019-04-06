package entities;

import entities_abstract.BlockBase;
import entities_abstract.SquareBase;
import views.Controller;

import java.util.ArrayList;

public class TBlock extends BlockBase {


    public TBlock(Controller playArena, int mainCol, int mainRow) {
        super(playArena, mainCol, mainRow);
    }

    @Override
    public void init() {
        matrix[0] = new Square(playArena, mainRow - 1, mainCol);
        matrix[1] = new Square(playArena, mainRow, mainCol - 1);
        matrix[2] = new Square(playArena, mainRow, mainCol);
        matrix[3] = new Square(playArena, mainRow, mainCol + 1);
    }

    @Override
    public boolean checkTransformable() {
        switch (statusForm) {
            case 1: {
                SquareBase[] squareBases = playArena.getRows().get(mainRow + 1).getSquareBases();
                if (squareBases[mainCol - 1] != null || squareBases[mainCol] != null)
                    return false;
            }
            case 2: {
                SquareBase[] squareBases = playArena.getColumns().get(mainCol).getSquareBases();
                if (squareBases[mainRow - 1] != null || squareBases[mainRow] != null)
                    return false;
            }
            case 3:
            case 4: {
                break;
            }

        }
        return true;
    }

    @Override
    public void form1() {
        matrix[0].reLocate(mainRow - 1, mainCol);
        matrix[1].reLocate(mainRow, mainCol - 1);
        matrix[2].reLocate(mainRow, mainCol);
        matrix[3].reLocate(mainRow, mainCol + 1);
    }

    @Override
    public void form2() {
        matrix[1].reLocate(mainRow + 1, mainCol);
    }

    @Override
    public void form3() {
        matrix[0].reLocate(mainRow, mainCol - 1);
    }

    @Override
    public void form4() {
        matrix[3].reLocate(mainRow - 1, mainCol);
    }
}
