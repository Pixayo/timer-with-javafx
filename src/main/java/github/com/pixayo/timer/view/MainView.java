package github.com.pixayo.timer.view;

import github.com.pixayo.timer.view.ui.NotificationBar;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import github.com.pixayo.timer.controller.Timer;

public class MainView implements ViewMaker {

    // Used to inject the Main stage to a "controller"
    private final Stage stage;

    private final Label timerLabel = new Label("00:00");
    private final Timer timer = new Timer(timerLabel);

    public MainView(Stage stage) {
        this.stage = stage;
    }

    @Override
    public Scene getScene() {

        // Create controller if exists
        // MainController controller = new MainController(...);

        StackPane root = new StackPane();
        Scene scene = new Scene(root, 300, 250);

        VBox body = new VBox(15);
        HBox buttonContainer = new HBox(15);

        Label previousTimerLabel = new Label(timer.getPreviousTimerText());
        NotificationBar notificationBar = NotificationBar.getInstance();

        Button start = new Button("Start");
        start.setOnAction(e -> {
            if (!timer.isRunning()) {
                previousTimerLabel.setText(timer.getPreviousTimerText());
                timer.start();
            }
        });

        Button stop = new Button("Stop");
        stop.setOnAction(e -> timer.stop());

        // Structure
        timerLabel.setFont(Font.font("Monospaced", FontWeight.BOLD, 48));

        previousTimerLabel.setFont(Font.font("monospaced", FontWeight.LIGHT, 12));
        previousTimerLabel.setStyle("-fx-text-fill: #A1A1A1");

        body.setAlignment(Pos.CENTER);
        body.setPadding(new Insets(30));

        buttonContainer.setAlignment(Pos.CENTER);

        StackPane.setAlignment(notificationBar, Pos.TOP_CENTER);

        applyStyle(scene);

        // Tree
        buttonContainer.getChildren().addAll(
                start,
                stop
        );
        body.getChildren().addAll(
                timerLabel,
                previousTimerLabel,
                buttonContainer
        );
        root.getChildren().addAll(
                body,
                notificationBar
        );

        return scene;
    }

    private void applyStyle(Scene scene) {
        try {
            scene.getStylesheets().add(
                    getClass().getResource("style.css").toExternalForm());

        } catch (Exception e) {
            NotificationBar.getInstance().show("Error: could not apply CSS style");
            System.err.println("At MainView: " + e.getMessage());
        }
    }
}
