package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Menu {

    private Scene scene;
    private StackPane stackPane = new StackPane();
    private VBox vBox = new VBox();
    private Easy easy = new Easy();
    private Medium medium = new Medium();
    private Hard hard = new Hard();
    private LEVEL level;

    public Scene menuScene(final Stage stage) {

        level=LEVEL.Menu;

        final Button easyButton = new Button("Easy");
        easyButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                stage.setWidth(400);
                stage.setHeight(340);
                level=LEVEL.Easy;
                startLevel(stage);
            }
        });
        vBox.getChildren().add(easyButton);

        final Button mediumButton = new Button("Medium");
        mediumButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                stage.setWidth(480);
                stage.setHeight(420);
                level=LEVEL.Medium;
                startLevel(stage);
            }
        });
        vBox.getChildren().add(mediumButton);

        final Button hardButton = new Button("Hard");
        hardButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                stage.setWidth(560);
                stage.setHeight(500);
                level=LEVEL.Hard;
                startLevel(stage);
            }
        });

        vBox.getChildren().add(hardButton);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(50);
        stackPane.getChildren().add(vBox);

        scene = new Scene(stackPane,600,400);

        return scene;

    }

    private void startLevel(Stage stage){
        switch (level){
            case Easy:{
                stage.setScene(easy.makeScene(Configs.getInstance().EASY_WIDTH,Configs.getInstance().EASY_HEIGHT));
                break;
            }
            case Medium:{
                stage.setScene(medium.makeScene(Configs.getInstance().MEDIUM_WIDTH,Configs.getInstance().MEDIUM_HEIGHT));
                break;
            }
            case Hard:{
                stage.setScene(hard.makeScene(Configs.getInstance().HARD_WIDTH,Configs.getInstance().HARD_HEIGHT));
                break;
            }

        }
    }

}
