package GUI;

import javafx.scene.Group;
import javafx.scene.Scene;

public abstract class SceneGenerator {

    public Scene makeScene(int width, int height){

        Group tileGroup = new Group();

        for(int y=0 ; y < height; y++){
            for(int x=0; x < width; x++){
                Tile tile = new Tile((x+y) % 2 == 0,x,y);
                tileGroup.getChildren().add(tile);
            }
        }
        return new Scene(tileGroup);

    }
}
