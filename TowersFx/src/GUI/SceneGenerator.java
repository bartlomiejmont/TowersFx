package GUI;

import LOGIC.MainLogic;
import LOGIC.SavingLoading;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.FileChooser;

import java.util.Optional;

public class SceneGenerator {

    SavingLoading savingLoading = new SavingLoading();

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

        FileChooser fileChooser = new FileChooser();
//        fileChooser.setInitialDirectory(new File("c:\\"));
//        fileChooser.setInitialFileName("save.txt");
//        fileChooser.getExtensionFilters().addAll(
//                new FileChooser.ExtensionFilter("Text Files", "*.txt")
//        );

        a.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);
        Optional<ButtonType> result = a.showAndWait();
        if (result.get() == buttonTypeOne){
//            System.out.println((Stage)MainLogic.primaryWindow);
            savingLoading.saveGame();
        } else if (result.get() == buttonTypeTwo) {
           savingLoading.loadGame();
        }
    }

}
