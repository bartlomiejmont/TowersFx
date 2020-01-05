package LOGIC;

import GUI.Tile;
import javafx.scene.Group;
import javafx.scene.text.Text;
import javafx.stage.Window;

import java.util.Stack;


public final class MainLogic {

    private MainLogic(){}

    public static Tile lastTile;
    public static Stack<Tile> moves = new MovesStack();

    public static Tile[][] tileMap;
    public static int[][] map;

    public static int width;
    public static int height;
    public static int fuel = 5;
    public static int tileNumber;

    public static boolean creatingMode = false;

    public static Window primaryWindow ;

    public static Group getTileMap(int w, int h){

        width = w;
        height = h;

        Group group = new Group();

        for(int y=0 ; y < h; y++){
            for(int x=0; x < w; x++){
                Tile tile = new Tile((x+y) % 2 == 0,x,y);
                Text text = new Text(x*tile.getWidth(),y*tile.getWidth()+10,"[ "+x+","+y+" ]");
                if(map[x][y] % 5 == 0){
                    tile.setRed(true);
                    tile.makeRed();
                }
                //StackPane stack = new StackPane();
                //stack.getChildren().addAll(tile, text);

                group.getChildren().addAll(tile,text);
                tileMap[x][y] = tile;
            }
        }
        return group;
    }


}
