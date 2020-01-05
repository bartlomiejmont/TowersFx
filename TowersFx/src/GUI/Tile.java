package GUI;

import LOGIC.CreateModeTileLogic;
import LOGIC.MainLogic;
import LOGIC.TileLogic;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle {

    private int tableX;
    private int tableY;
    private boolean red = false;
    private boolean light;
    private TileLogic tileLogic = new TileLogic();
    private CreateModeTileLogic createModeTileLogic = new CreateModeTileLogic();

    @Override
    public String toString() {
        return "{\"tableX\":" + tableX +
                ", \"tableY\":" + tableY +
                '}';
    }

    public boolean isRed() {
        return red;
    }

    public void setRed(boolean red) {
        this.red = red;
    }

    public void makeRed(){
        if(this.red && this.light){
            this.setFill(Color.valueOf("FF0000"));
        }
        else if (this.red && !this.light){
            this.setFill(Color.valueOf("FF6666"));
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

    public Tile(){ }
    public Tile(int y, int x){
        this.tableX = x;
        this.tableY = y;
        this.setX(x);
        this.setY(y);
    }

    public Tile (boolean light, int x, int y) {

        this.tableX = x;
        this.setX(x);
        this.setY(y);
        this.tableY = y;
        this.light = light;

        this.setWidth(Configs.getInstance().TILE_SIZE);
        this.setHeight(Configs.getInstance().TILE_SIZE);

        relocate(x * Configs.getInstance().TILE_SIZE, y * Configs.getInstance().TILE_SIZE);

        setFill(light ? Color.valueOf("#feb") : Color.valueOf("#582"));

        this.setOnMouseClicked(mouseEvent -> {
            tileClick();
        });
    }
        public void tileClick(){

            if(createModeTileLogic.isMovePossible(this) && MainLogic.creatingMode){
                createModeTileLogic.move(this);

                if(light){
                    this.setFill(Color.valueOf("#00cc99"));
                }
                else {
                    this.setFill(Color.valueOf("#cc9900"));
                }

            }

            else if(tileLogic.isMovePossible(this)) {

                tileLogic.move(this);

                if (light && !red) {
                    this.setFill(Color.BLUE);
                } else if (!light && !red) {
                    this.setFill(Color.DARKBLUE);
                } else if (light && red) {
                    this.setFill(Color.valueOf("#FFB266"));
                } else {
                    this.setFill(Color.valueOf("#FF8000"));
                }

            }
            else if (tileLogic.isRevertPossible(this)){

                tileLogic.move(this);

                if (light && !red) {
                    this.setFill(Color.valueOf("#feb"));
                } else if (!light && !red) {
                    this.setFill(Color.valueOf("#582"));
                } else if (light && red) {
                    this.setFill(Color.valueOf("#FF0000"));
                } else {
                    this.setFill(Color.valueOf("#FF6666"));
                }
            }
        }

    }
