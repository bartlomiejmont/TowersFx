package GUI;

import javafx.scene.Group;
import javafx.scene.Scene;

public class Easy {

    private Group tileGroup = new Group();

     public Scene easyScene(){

         for(int y=0 ; y < Configs.getInstance().EASY_HEIGHT; y++){
             for(int x=0; x < Configs.getInstance().EASY_WIDTH; x++){
                 Tile tile = new Tile((x+y) % 2 == 0,x,y);
                 tileGroup.getChildren().add(tile);
             }
         }

         return new Scene(tileGroup);

     }

}
