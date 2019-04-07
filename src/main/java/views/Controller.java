package views;

import entities.GameColumn;
import entities.GameRow;
import entities.Square;
import entities.TBlock;
import entities_abstract.BlockBase;
import entities_abstract.GameColumnBase;
import entities_abstract.GameRowBase;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private int loop = 250;
    private int count = 0;
    @FXML
    public GridPane gridPane;
    @FXML
    public ImageView imgNext;
    @FXML
    public Text txtScore;
    @FXML
    public Pane mainPane;

    private ArrayList<GameRowBase> rows;

    private ArrayList<GameColumnBase> columns;

    private BlockBase currentBlock;

    private boolean isAlive;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        isAlive = true;
        initGrid();
        initRowsCols();
        initBlock();
        imgNext.setImage(new Image(getClass().getClassLoader().getResource("images/T-block.png").toExternalForm()));
        eventHandler();
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                try {
                    gameLoop();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        timer.start();
    }

    private void initGrid() {
        for (int i = 0; i < 15; i++) {
            gridPane.addRow(i);
        }
        for (int i = 1; i < 10; i++) {
            gridPane.addColumn(i);
        }
        gridPane.setGridLinesVisible(false);
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 10; j++) {
                Label node = new Label();
                node.getStyleClass().add("node");
                gridPane.add(node, j, i);
            }
        }

    }

    private void initRowsCols() {
        columns = new ArrayList<>();
        rows = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            columns.add(new GameColumn(this, i));
        }
        for (int i = 0; i < 15; i++) {
            rows.add(new GameRow(this, i));
        }
    }

    private void initBlock() {
        currentBlock = new TBlock(this, 5, 1);
        currentBlock.addToPanel();
    }

    private void gameLoop() throws InterruptedException {
        if (!currentBlock.checkMovable()) {
            initBlock();
        }
        else {
            currentBlock.move();
        }
        Thread.sleep(loop);
    }

    private void eventHandler() {
        mainPane.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.RIGHT && currentBlock.checkTurnRight())
                currentBlock.setDirectionX(1);
            else if (event.getCode() == KeyCode.LEFT && currentBlock.checkTurnLeft())
                currentBlock.setDirectionX(-1);
            else if (event.getCode() == KeyCode.UP )
                currentBlock.transform();
            else currentBlock.setDirectionX(0);
        });
        mainPane.setOnKeyReleased(event -> {
            currentBlock.setDirectionX(0);
        });
    }

    public ArrayList<GameRowBase> getRows() {
        return rows;
    }

    public void setRows(ArrayList<GameRowBase> rows) {
        this.rows = rows;
    }

    public ArrayList<GameColumnBase> getColumns() {
        return columns;
    }

    public void setColumns(ArrayList<GameColumnBase> columns) {
        this.columns = columns;
    }

    public BlockBase getCurrentBlock() {
        return currentBlock;
    }

    public void setCurrentBlock(BlockBase currentBlock) {
        this.currentBlock = currentBlock;
    }
}
