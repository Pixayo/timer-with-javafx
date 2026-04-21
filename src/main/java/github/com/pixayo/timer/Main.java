package github.com.pixayo.timer;

import github.com.pixayo.timer.model.SceneName;
import github.com.pixayo.timer.view.MainView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main extends Application {

    private static final Map<SceneName, Scene> scenes = new HashMap<>();

    @Override
    public void start(Stage stage) throws IOException {

        scenes.put(SceneName.MAIN, new MainView(stage).getScene());
        // scenes.put(SceneName.SETTINGS, new SettingsView(stage).getScene());

        stage.setTitle("Timer");
        stage.setScene(scenes.get(SceneName.MAIN));
        stage.setMinWidth(scenes.get(SceneName.MAIN).getWidth());
        stage.setMinHeight(scenes.get(SceneName.MAIN).getHeight());
        stage.sizeToScene();
        stage.show();
    }

    public static Map<SceneName, Scene> getScenes() {
        return scenes;
    }
}
