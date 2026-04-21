package github.com.pixayo.timer.controller;

import github.com.pixayo.timer.Main;
import github.com.pixayo.timer.model.SceneName;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MainViewController {

    private Stage stage;

    public MainViewController(Stage stage) {
        this.stage = stage;
    }

    public void handleOnPressSettingsButton(MouseEvent e) {
        stage.setScene(Main.getScenes().get(SceneName.SETTINGS));
    }
}
