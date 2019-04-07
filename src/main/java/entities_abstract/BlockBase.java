package entities_abstract;

import views.Controller;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class BlockBase {

    protected SquareBase[] matrix;

    protected byte statusForm;

    protected boolean movable;

    protected boolean transformable;

    protected int directionX;

    protected Controller playArena;

    protected int mainCol;

    protected int mainRow;

    public BlockBase(Controller playArena, int mainCol, int mainRow) {
        this.matrix = new SquareBase[4];
        this.playArena = playArena;
        this.mainCol = mainCol;
        this.mainRow = mainRow;
        this.statusForm = 1;
        this.transformable = true;
        this.movable = true;
        this.directionX = 0;
        init();
    }

    public void addToPanel() {
        for (SquareBase squareBase : matrix) {
            squareBase.addToPanel();
        }
    }

    public void move() {
        if (!movable) return;
        mainCol += directionX;
        mainRow++;
        for (SquareBase squareBase : matrix) {
            squareBase.setDirectionX(this.directionX);
            squareBase.move();
        }
        updateUI();
    }

    public void updateUI() {
        for (SquareBase squareBase : matrix) {
            squareBase.updateUI();
        }
    }

    public void transform() {
        if (!transformable) return;
        this.statusForm++;
        if (statusForm > 4) statusForm = 1;
        switch (statusForm) {
            case 1: {
                form1();
                break;
            }
            case 2: {
                form2();
                break;
            }
            case 3: {
                form3();
                break;
            }
            case 4: {
                form4();
                break;
            }
            default:
                break;
        }
        updateUI();
    }

    public abstract void init();

    public boolean checkMovable() {
        List<SquareBase> test = Arrays.asList(matrix);
        for (SquareBase square : matrix) {
            if (square.indexRow == 14) {
                this.movable = false;
                return false;
            } else if (!test.contains(playArena.getColumns().get(square.getIndexCol()).squareBases[square.indexRow + 1]))
                if (!square.checkMoveDown()) {
                    this.movable = false;
                    return false;
                }
        }
        return true;
    }

    public abstract boolean checkTransformable();

    public boolean checkTurnLeft() {
        int minCol = matrix[0].getIndexCol();
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i].getIndexCol() < minCol)
                minCol = matrix[i].getIndexCol();
        }
        for (SquareBase squareBase : matrix) {
            if (squareBase.getIndexRow() == minCol)
                if (!squareBase.checkMoveLeft())
                    return false;
        }
        return true;
    }

    public boolean checkTurnRight() {
        int maxCol = matrix[0].getIndexCol();
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i].getIndexCol() > maxCol)
                maxCol = matrix[i].getIndexCol();
        }
        for (SquareBase squareBase : matrix) {
            if (squareBase.getIndexRow() == maxCol)
                if (!squareBase.checkMoveRight())
                    return false;
        }
        return true;
    }

    public abstract void form1();

    public abstract void form2();

    public abstract void form3();

    public abstract void form4();

    public byte getStatusForm() {
        return statusForm;
    }

    public void setStatusForm(byte statusForm) {
        this.statusForm = statusForm;
    }

    public boolean isMovable() {
        return movable;
    }

    public void setMovable(boolean movable) {
        this.movable = movable;
    }

    public boolean isTransformable() {
        return transformable;
    }

    public void setTransformable(boolean transformable) {
        this.transformable = transformable;
    }

    public int getDirectionX() {
        return directionX;
    }

    public void setDirectionX(int directionX) {
        this.directionX = directionX;
    }

    public Controller getPlayArena() {
        return playArena;
    }

    public void setPlayArena(Controller playArena) {
        this.playArena = playArena;
    }

    public SquareBase[] getMatrix() {
        return matrix;
    }

    public void setMatrix(SquareBase[] matrix) {
        this.matrix = matrix;
    }

    public int getMainCol() {
        return mainCol;
    }

    public void setMainCol(int mainCol) {
        this.mainCol = mainCol;
    }

    public int getMainRow() {
        return mainRow;
    }

    public void setMainRow(int mainRow) {
        this.mainRow = mainRow;
    }
}
