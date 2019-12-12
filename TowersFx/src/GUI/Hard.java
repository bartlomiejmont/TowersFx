package GUI;

import javafx.scene.Group;
import javafx.scene.Scene;

public class Hard {
    private Group tileGroup = new Group();

    public Scene hardScene(){

        for(int y=0 ; y < Configs.getInstance().HARD_HEIGHT; y++){
            for(int x=0; x < Configs.getInstance().HARD_WIDTH; x++){
                Tile tile = new Tile((x+y) % 2 == 0,x,y);
                tileGroup.getChildren().add(tile);
            }
        }

        return new Scene(tileGroup);

    }
}
