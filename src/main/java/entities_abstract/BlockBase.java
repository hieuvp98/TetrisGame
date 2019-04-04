package entities_abstract;

import java.awt.*;

public abstract class BlockBase {

    protected SquareBase[][] matrix;

    protected byte statusForm;

    protected boolean movable;

    protected boolean transformable;

    protected int directionX;

    protected int stepX;

    protected int stepY;

    protected PlayArenaBase playArena;

    public abstract void addToPanel(Panel playArena);

    public abstract void move();

    public abstract void updateUI();

    public abstract void transform();

    public abstract boolean checkMovable();

    public abstract boolean checkTransformable();

    public SquareBase[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(SquareBase[][] matrix) {
        this.matrix = matrix;
    }

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

    public int getStepX() {
        return stepX;
    }

    public void setStepX(int stepX) {
        this.stepX = stepX;
    }

    public int getStepY() {
        return stepY;
    }

    public void setStepY(int stepY) {
        this.stepY = stepY;
    }

    public PlayArenaBase getPlayArena() {
        return playArena;
    }

    public void setPlayArena(PlayArenaBase playArena) {
        this.playArena = playArena;
    }
}
