package github.com.pixayo.timer;

import javafx.application.Application;
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

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Label timerLabel = new Label("00:00");
        timerLabel.setFont(Font.font("Monospaced", FontWeight.BOLD, 48));

        Timer timer = new Timer(timerLabel);

        Label previousTimerLabel = new Label(timer.getPreviousTimeText());
        previousTimerLabel.setFont(Font.font("monospaced", FontWeight.LIGHT, 12));
        previousTimerLabel.setStyle("-fx-text-fill: #A1A1A1");

        Button btnStart = new Button("Start");
        btnStart.setPrefWidth(80);
        btnStart.setOnAction(e -> {
            if (!timer.isRunning()) {
                timer.start();
            }
        });

        Button btnStop = new Button("Stop");
        btnStop.setPrefWidth(80);
        btnStop.setOnAction(e -> {
            timer.stop();
            previousTimerLabel.setText(timer.getPreviousTimeText());
        });

        HBox buttonContainer = new HBox(15);
        buttonContainer.setAlignment(Pos.CENTER);
        buttonContainer.getChildren().addAll(btnStart, btnStop);

        VBox mainLayout = new VBox(10); // 20px de espaçamento vertical
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.setPadding(new Insets(30)); // Margem interna
        mainLayout.getChildren().addAll(timerLabel, previousTimerLabel, buttonContainer);

        StackPane root = new StackPane(mainLayout);

        Scene scene = new Scene(root, 300, 200);
        scene.getStylesheets().add(
                getClass().getResource("style.css").toExternalForm());

        stage.setTitle("Timer");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.setMinWidth(scene.getWidth());
        stage.setMinHeight(scene.getHeight());
        stage.show();
    }
}
