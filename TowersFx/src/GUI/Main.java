package GUI;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.util.EventListener;

public class Main extends Application {

    SceneGenerator sceneGenerator = new SceneGenerator();


    @Override
    public void start(final Stage stage) {

        Menu menu = new Menu();

        Scene scene = menu.menuScene(stage);

        stage.setScene(scene);
        stage.show();

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode() == KeyCode.ESCAPE){

                    // show the dialog
                    sceneGenerator.menuAlert();
                }
            }
        });
    }



    public static void main(String[] args) {
        launch();
    }


}