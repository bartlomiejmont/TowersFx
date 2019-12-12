package GUI;

import javafx.scene.Group;
import javafx.scene.Scene;

public class Medium {
    private Group tileGroup = new Group();

    public Scene mediumScene(){

        for(int y=0 ; y < Configs.getInstance().MEDIUM_HEIGHT; y++){
            for(int x=0; x < Configs.getInstance().MEDIUM_WIDTH; x++){
                Tile tile = new Tile((x+y) % 2 == 0,x,y);
                tileGroup.getChildren().add(tile);
            }
        }

        return new Scene(tileGroup);

    }
}
