package GUI;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle {

    private int tableX;
    private int tableY;

    public int getTableX() {
        return tableX;
    }

    public void setTableX(int tableX) {
        this.tableX = tableX;
    }

    public int getTableY() {
        return tableY;
    }

    public void setTableY(int tableY) {
        this.tableY = tableY;
    }

    public Tile (boolean light, int x, int y){

        this.tableX = x;
        this.tableY = y;

        this.setWidth(Configs.getInstance().TILE_SIZE);
        this.setHeight(Configs.getInstance().TILE_SIZE);

        relocate(x * Configs.getInstance().TILE_SIZE, y* Configs.getInstance().TILE_SIZE);

        setFill(light ? Color.valueOf("#feb") : Color.valueOf("#582"));

        this.setOnMouseClicked(mouseEvent -> {
            if(light){
                this.setFill(Color.BLUE);
            }
            else {
                this.setFill(Color.DARKBLUE);
            }
        });
    }

}
