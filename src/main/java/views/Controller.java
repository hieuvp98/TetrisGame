package views;

import entities.GameColumn;
import entities.GameRow;
import entities.TBlock;
import entities_abstract.BlockBase;
import entities_abstract.GameColumnBase;
import entities_abstract.GameRowBase;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller  implements Initializable {

    @FXML
    public GridPane gridPane;
    @FXML
    public ImageView imgNext;

    private ArrayList<GameRowBase> rows;

    private ArrayList<GameColumnBase> columns;

    private BlockBase currentBlock;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       initGrid();
       initRowsCols();
       imgNext.setImage(new Image(getClass().getClassLoader().getResource("images/T-block.png").toExternalForm()));
//       currentBlock = new TBlock(this,5,1);
//       currentBlock.addToPanel();
    }

    private void initGrid(){
        for (int i = 0; i < 10; i++) {
            gridPane.addRow(i);
        }
        for (int i = 1; i < 10; i++){
            gridPane.addColumn(i);
        }
        gridPane.setGridLinesVisible(true);
        for (int i = 0; i < 15; i++) {
            for (int j = 0;j < 10; j++){
                Label node = new Label();
                node.getStyleClass().add("node");
                gridPane.add(node,j,i);
            }
        }
    }

    private void initRowsCols(){
        columns = new ArrayList<>();
        rows = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            columns.add(new GameColumn(this,i));
        }
        for (int i = 0; i < 15; i++) {
            rows.add(new GameRow(this,i));
        }
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
