package github.com.pixayo.timer.controller;

import github.com.pixayo.timer.Main;
import github.com.pixayo.timer.model.SceneName;
import javafx.stage.Stage;

public class MainViewController {

    private final Stage stage;

    public MainViewController(Stage stage) {
        this.stage = stage;
    }

    public void handleOnPressSettingsButton() {
        stage.setScene(Main.getScenes().get(SceneName.SETTINGS));
    }
}
