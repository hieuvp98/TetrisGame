package entities_abstract;

import views.MainFrame;

import javax.swing.*;
import java.util.ArrayList;

public abstract class PlayArenaBase extends JPanel {

    protected ArrayList<GameColumnBase> columns;

    protected ArrayList<GameRowBase> rows;

    protected BlockBase currentBlock;

    protected BlockBase nextBlock;

    protected int point;

    protected MainFrame mainFrame;

    public abstract void initCurrentBlock();

    public abstract void initNextBlock();

    public abstract void updateUi();

    public abstract void addKeyListener();

    public abstract void keyLeft();

    public abstract void keyRight();

    public abstract void keyUp();

    public abstract void keyDown();

    public ArrayList<GameColumnBase> getColumns() {
        return columns;
    }

    public void setColumns(ArrayList<GameColumnBase> columns) {
        this.columns = columns;
    }

    public ArrayList<GameRowBase> getRows() {
        return rows;
    }

    public void setRows(ArrayList<GameRowBase> rows) {
        this.rows = rows;
    }

    public BlockBase getCurrentBlock() {
        return currentBlock;
    }

    public void setCurrentBlock(BlockBase currentBlock) {
        this.currentBlock = currentBlock;
    }

    public BlockBase getNextBlock() {
        return nextBlock;
    }

    public void setNextBlock(BlockBase nextBlock) {
        this.nextBlock = nextBlock;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }
}
