package GUI;

import LOGIC.MainLogic;
import javafx.scene.Group;
import javafx.scene.Scene;

public class SceneGenerator {

    public Scene makeScene(int width, int height, int[][]map){

        Group tileGroup = new Group();

        tileGroup=MainLogic.getTileMap(width,height);

        return new Scene(tileGroup);

    }

    public Scene makeScene(int width, int height){

        Group tileGroup = new Group();

        tileGroup=MainLogic.getTileMap(width,height);

        return new Scene(tileGroup);

    }
}
