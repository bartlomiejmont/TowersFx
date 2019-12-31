module TowersFx {
    requires javafx.fxml;
    requires javafx.controls;
    requires junit;
    requires json.simple;

    opens GUI;
    opens TESTS;
}