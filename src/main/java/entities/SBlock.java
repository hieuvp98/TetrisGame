/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import entities_abstract.BlockBase;
import entities_abstract.SquareBase;
import javafx.scene.image.Image;
import views.Controller;

/**
 * @author hoai
 */
public class SBlock extends BlockBase {

    private static final String URL = "images/xsquare5.png";

    public SBlock(Controller playArena, int mainCol, int mainRow) {
        super(playArena, mainCol, mainRow);
    }

    @Override
    public void init() {
        matrix[0] = new Square(playArena, mainRow - 1, mainCol);
        matrix[1] = new Square(playArena, mainRow - 1, mainCol + 1);
        matrix[2] = new Square(playArena, mainRow, mainCol - 1);
        matrix[3] = new Square(playArena, mainRow, mainCol);
        for (SquareBase squareBase : matrix) {
            squareBase.getImageView().setImage(new Image(getClass().getClassLoader().getResource(URL).toExternalForm()));
        }
    }

    @Override
    public boolean checkTransformable() {
        switch (statusForm) {
            case 1:
            case 3: {
                SquareBase[] squareBases = playArena.getRows().get(mainRow - 1).getSquareBases();
                SquareBase[] squareBases1 = playArena.getRows().get(mainRow).getSquareBases();
                if (squareBases[mainCol - 1] != null || squareBases[mainCol] != null || squareBases[mainCol + 1] != null
                        || squareBases1[mainCol + 1] != null)
                    return false;
                break;
            }
            case 2:
            case 4: {
                SquareBase[] squareBases = playArena.getColumns().get(mainCol - 1).getSquareBases();
                SquareBase[] squaBaseses1 = playArena.getColumns().get(mainCol).getSquareBases();
                if (squareBases[mainRow - 1] != null || squareBases[mainRow] != null || squareBases[mainRow + 1] != null
                        || squaBaseses1[mainCol] != null)
                    return false;
                break;
            }
        }
        return true;
    }

    @Override
    public void form1() {
        matrix[0].reLocate(mainRow - 1, mainCol);
        matrix[1].reLocate(mainRow - 1, mainCol + 1);
        matrix[2].reLocate(mainRow, mainCol - 1);
        matrix[3].reLocate(mainRow, mainCol);
    }

    @Override
    public void form2() {
        matrix[0].reLocate(mainRow, mainCol + 1);
        matrix[1].reLocate(mainRow + 1, mainCol + 1);
        matrix[2].reLocate(mainRow - 1, mainCol);
    }

    @Override
    public void form3() {
        form1();
    }

    @Override
    public void form4() {
        form2();
    }

}
