package GUI;

import LOGIC.MainLogic;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import java.util.Optional;

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

    public void gameOverScene(){
        // create a alert
        Alert a = new Alert(Alert.AlertType.INFORMATION);

        a.setTitle("GameOver");
        a.setHeaderText(null);
        a.setContentText("You win!");

        // show the dialog
        a.showAndWait();

    }

    public void menuAlert(){
        Alert a = new Alert(Alert.AlertType.NONE);

        a.setTitle("Menu");
        a.setHeaderText(null);
        a.setContentText(null);
        ButtonType buttonTypeOne = new ButtonType("Save Game");
        ButtonType buttonTypeTwo = new ButtonType("Load Game");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        a.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);
        Optional<ButtonType> result = a.showAndWait();
        if (result.get() == buttonTypeOne){
            System.out.println("Saving...");
        } else if (result.get() == buttonTypeTwo) {
            System.out.println("Loading...");
        }
        else {
            // ... user chose CANCEL or closed the dialog
        }
    }

}
