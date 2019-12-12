package GUI;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle {
    int x;
    int y;

    public Tile (boolean light, int x, int y){

        this.x = x;
        this.y = y;

        this.setWidth(Configs.getInstance().TILE_SIZE);
        this.setHeight(Configs.getInstance().TILE_SIZE);

        relocate(x * Configs.getInstance().TILE_SIZE, y* Configs.getInstance().TILE_SIZE);

        setFill(light ? Color.valueOf("#feb") : Color.valueOf("#582"));
    }

}
