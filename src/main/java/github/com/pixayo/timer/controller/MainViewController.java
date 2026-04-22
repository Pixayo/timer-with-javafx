package github.com.pixayo.timer.controller;

import github.com.pixayo.timer.model.Timer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class MainViewController {

    public StackPane root;

    @FXML private Label timerLabel;
    @FXML private Label previousTimerLabel;
    // @FXML public Button startButton;
    @FXML private Button stopResetButton;

    private Timer timer;

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
}