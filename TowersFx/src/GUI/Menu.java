package GUI;

import LOGIC.MainLogic;
import LOGIC.MapGenerator;
import LOGIC.SavingLoading;
import javafx.collections.FXCollections;
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
    private int choiceWidthValue = 2;
    private int choiceHeightValue = 2;
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

        String[] choices = {"2","3","4","5","6","7","8","9"};

        ChoiceBox<String> choiceWidth = new ChoiceBox<>(FXCollections.observableArrayList(choices));
        choiceWidth.setValue(choices[0]);
        ChoiceBox<String> choiceHeight = new ChoiceBox<>(FXCollections.observableArrayList(choices));
        choiceHeight.setValue(choices[0]);

        choiceWidth.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                choiceWidthValue = Integer.parseInt(choiceWidth.getValue());
                MainLogic.width = choiceWidthValue;
            }
        });

        choiceHeight.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                choiceHeightValue = Integer.parseInt(choiceHeight.getValue());
                MainLogic.height = choiceHeightValue;
            }
        });

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
                MainLogic.creatingMode = true;
                MainLogic.map = mapGenerator.generateMap(choiceWidthValue,choiceHeightValue);
                MainLogic.tileMap=mapGenerator.generateTileMap(choiceWidthValue,choiceHeightValue);
                stage.setScene(sceneGenerator.makeScene(choiceWidthValue,choiceHeightValue));
                break;
            }
            case Load:{
                savingLoading.loadGame();
                break;
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
