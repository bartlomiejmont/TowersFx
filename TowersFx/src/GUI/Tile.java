package GUI;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle {

    private int tableX;
    private int tableY;
    private boolean clicked = false;
    private boolean red = false;
    private boolean light;

    public boolean isRed() {
        return red;
    }

    public void setRed(boolean red) {
        this.red = red;
    }

    public void makeRed(){
        if(this.red && this.light){
            this.setFill(Color.valueOf("#FF6D6D"));
        }
        else if (this.red && !this.light){
            this.setFill(Color.valueOf("#C20000"));
        }
    }

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
        this.light = light;

        this.setWidth(Configs.getInstance().TILE_SIZE);
        this.setHeight(Configs.getInstance().TILE_SIZE);

        relocate(x * Configs.getInstance().TILE_SIZE, y* Configs.getInstance().TILE_SIZE);

        setFill(light ? Color.valueOf("#feb") : Color.valueOf("#582"));

        this.setOnMouseClicked(mouseEvent -> {
            if(!clicked){
                if(light){
                    this.setFill(Color.BLUE);
                }
                else {
                    this.setFill(Color.DARKBLUE);
                }
                clicked = true;
            }
            else {
                if(light){
                    this.setFill(Color.valueOf("#feb"));
                }
                else {
                    this.setFill(Color.valueOf("#582"));
                }
                clicked = false;
            }
            makeRed();
        });
    }

}
