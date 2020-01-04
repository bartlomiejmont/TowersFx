package GUI;

import LOGIC.MainLogic;
import LOGIC.MapGenerator;
import LOGIC.SavingLoading;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Menu {

    private Scene scene;
    private StackPane stackPane = new StackPane();
    private VBox vBox = new VBox();
    private SceneGenerator sceneGenerator = new SceneGenerator();
    private MapGenerator mapGenerator = new MapGenerator();
    private LEVEL level;
    private SavingLoading savingLoading = new SavingLoading();

    public Scene menuScene(final Stage stage) {

        level=LEVEL.Menu;

        final Button easyButton = new Button("Easy");
        easyButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                stage.setWidth(480);
                stage.setHeight(420);
                level=LEVEL.Easy;
                startLevel(stage);
            }
        });
        vBox.getChildren().add(easyButton);

        ChoiceBox choiceWidth = new ChoiceBox();
        ChoiceBox choiceHeight = new ChoiceBox();

        vBox.getChildren().addAll(choiceWidth,choiceHeight);

        final Button createButton = new Button("Create");
        createButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                stage.setWidth(480);
                stage.setHeight(420);
                level=LEVEL.Create;
                startLevel(stage);
            }
        });
        vBox.getChildren().add(createButton);


        final Button loadButton = new Button("Load");
        loadButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                stage.setWidth(480);
                stage.setHeight(420);
                level=LEVEL.Load;
                startLevel(stage);
            }
        });
        vBox.getChildren().add(loadButton);

        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(50);
        stackPane.getChildren().add(vBox);

        scene = new Scene(stackPane,600,400);

        return scene;

    }

    private void startLevel(Stage stage){
        switch (level){
            case Easy:{
                MainLogic.map=mapGenerator.easyMap();
                MainLogic.tileMap=mapGenerator.generateTileMap(Configs.getInstance().EASY_WIDTH,Configs.getInstance().EASY_HEIGHT);
                stage.setScene(sceneGenerator.makeScene(Configs.getInstance().EASY_WIDTH,Configs.getInstance().EASY_HEIGHT));
                break;
            }
            case Create:{
                break;
            }
            case Load:{
                savingLoading.loadGame();
            }

        }

        stage.getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode() == KeyCode.ESCAPE){

                    // show the dialog
                    sceneGenerator.menuAlert();
                }
            }
        });

    }

}
