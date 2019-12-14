package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static int WindowWidth = 640;
    public static int WindowHeight = 360;


    @Override
    public void start(final Stage stage) {

        Menu menu = new Menu();

        Scene scene = menu.menuScene(stage);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }


}