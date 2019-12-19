package GUI;

import LOGIC.MainLogic;
import LOGIC.MapGenerator;
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
    private SceneGenerator sceneGenerator = new SceneGenerator();
    private MapGenerator mapGenerator = new MapGenerator();
    private MainLogic mainLogic = new MainLogic();
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
                mainLogic.setMap(mapGenerator.easyMap());
                stage.setScene(sceneGenerator.makeScene(Configs.getInstance().EASY_WIDTH,Configs.getInstance().EASY_HEIGHT,mainLogic.getMap()));
                break;
            }
            case Medium:{
                mapGenerator.generateMap(Configs.getInstance().MEDIUM_WIDTH,Configs.getInstance().MEDIUM_HEIGHT);
                stage.setScene(sceneGenerator.makeScene(Configs.getInstance().MEDIUM_WIDTH,Configs.getInstance().MEDIUM_HEIGHT));
                break;
            }
            case Hard:{
                mapGenerator.generateMap(Configs.getInstance().HARD_WIDTH,Configs.getInstance().HARD_HEIGHT);
                stage.setScene(sceneGenerator.makeScene(Configs.getInstance().HARD_WIDTH,Configs.getInstance().HARD_HEIGHT));
                break;
            }

        }
    }

}
