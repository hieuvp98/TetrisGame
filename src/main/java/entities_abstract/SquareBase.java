package entities_abstract;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import views.Controller;

import javax.swing.*;
import java.awt.*;

public abstract class SquareBase {

    public static final int WIDTH = 40;

    public static final int HEIGHT = 40;

    public static final String URL = "images/square.png";

    protected int directionX;

    protected boolean removable;

    protected ImageView imageView;

    protected Controller playArena;

    protected int preIndexRow;

    protected int preIndexCol;

    protected int indexRow;

    protected int indexCol;

    public SquareBase(Controller playArena, int indexRow, int indexCol) {
        Image image = new Image(getClass().getClassLoader().getResource(URL).toExternalForm());
        this.imageView = new ImageView(image);
        this.imageView.setFitWidth(WIDTH);
        this.imageView.setFitHeight(HEIGHT);
        this.removable = false;
        directionX = 0;
        this.playArena = playArena;
        this.indexCol = indexCol;
        this.indexRow = indexRow;
    }

    public abstract void addToPanel();

    public abstract void remove();

    public abstract void move();

    public abstract void updateUI();

    public abstract boolean checkMoveDown();

    public abstract boolean checkMoveLeft();

    public abstract boolean checkMoveRight();

    public abstract void reLocate(int row, int col);

    public int getDirectionX() {
        return directionX;
    }

    public void setDirectionX(int directionX) {
        this.directionX = directionX;
    }

    public boolean isRemovable() {
        return removable;
    }

    public void setRemovable(boolean removable) {
        this.removable = removable;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public int getIndexRow() {
        return indexRow;
    }

    public void setIndexRow(int indexRow) {
        this.indexRow = indexRow;
    }

    public int getIndexCol() {
        return indexCol;
    }

    public void setIndexCol(int indexCol) {
        this.indexCol = indexCol;
    }

    public int getPreIndexRow() {
        return preIndexRow;
    }

    public void setPreIndexRow(int preIndexRow) {
        this.preIndexRow = preIndexRow;
    }

    public int getPreIndexCol() {
        return preIndexCol;
    }

    public void setPreIndexCol(int preIndexCol) {
        this.preIndexCol = preIndexCol;
    }
}
