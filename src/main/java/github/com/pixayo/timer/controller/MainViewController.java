package github.com.pixayo.timer.controller;

import github.com.pixayo.timer.App;
import github.com.pixayo.timer.model.SceneName;
import github.com.pixayo.timer.model.Timer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class MainViewController {

    public StackPane root;
    private Timer timer;

    @FXML private Label timerLabel;
    @FXML private Label previousTimerLabel;
    // @FXML public Button startButton;
    @FXML private Button stopResetButton;
    @FXML private Button settingsButton;


    @FXML
    public void initialize() {
        this.timer = new Timer(timerLabel);
        stopResetButton.setText("Reset");
    }

    @FXML
    private void handleStart() {
        if (!timer.isRunning()) {
            previousTimerLabel.setText(timer.getPreviousTimerText());
            timer.start();
            stopResetButton.setText("Stop");
        }
    }

    @FXML
    private void handleStopReset() {
        if (timer.isRunning()) {
            timer.stop();
            stopResetButton.setText("Reset");
        } else {
            timer.reset();
        }
    }

    @FXML
    private void goToSettings(ActionEvent actionEvent) {
        App.changeScene(SceneName.SETTINGS);
    }
}