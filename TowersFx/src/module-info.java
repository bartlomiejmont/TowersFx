module TowersFx {
    requires javafx.fxml;
    requires javafx.controls;
    requires junit;

    opens GUI;
    opens TESTS;
}