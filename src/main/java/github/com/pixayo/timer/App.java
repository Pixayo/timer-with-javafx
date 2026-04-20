package github.com.pixayo.timer;

import github.com.pixayo.timer.view.MainLayout;
import github.com.pixayo.timer.view.NotificationBar;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        StackPane root = new StackPane();
        Scene scene = new Scene(root, 300, 250);

        MainLayout mainLayout = new MainLayout(15);
        NotificationBar notificationBar = NotificationBar.getInstance();
        Timer timer = new Timer(mainLayout.getTimerText());

        mainLayout.addButton("Start", e -> {
            if (!timer.isRunning()) {
                mainLayout.setPreviousTimerText(timer.getPreviousTimerText());
                timer.start();
            }
        });

        mainLayout.addButton("Stop", e -> {
            timer.stop();
        });

        StackPane.setAlignment(notificationBar, Pos.TOP_CENTER);
        root.getChildren().addAll(mainLayout, notificationBar);

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
