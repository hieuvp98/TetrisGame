package entities_abstract;

import javax.swing.*;
import java.awt.*;

public abstract class SquareBase {

    protected double width;

    protected double height;

    protected double positionX;

    protected double positionY;

    protected int directionX;

    protected int stepX;

    protected int stepY;

    protected boolean movable;

    protected boolean removable;

    protected JLabel image;

    protected PlayArenaBase playArena;

    protected GameRowBase row;

    protected GameColumnBase column;

    public abstract void addToPanel(GameRowBase row,GameColumnBase column,int index);

    public abstract void remove();

    public abstract void move();

    public abstract void updateUI();

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getPositionX() {
        return positionX;
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
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


    public boolean isMovable() {
        return movable;
    }

    public boolean isRemovable() {
        return removable;
    }

    public void setRemovable(boolean removable) {
        this.removable = removable;
    }

    public JLabel getImage() {
        return image;
    }

    public void setImage(JLabel image) {
        this.image = image;
    }

    public GameRowBase getRow() {
        return row;
    }

    public void setRow(GameRowBase row) {
        this.row = row;
    }

    public GameColumnBase getColumn() {
        return column;
    }

    public void setColumn(GameColumnBase column) {
        this.column = column;
    }

    public PlayArenaBase getPlayArena() {
        return playArena;
    }

    public void setPlayArena(PlayArenaBase playArena) {
        this.playArena = playArena;
    }
}
