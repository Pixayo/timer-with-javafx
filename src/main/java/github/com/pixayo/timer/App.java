package github.com.pixayo.timer;

import github.com.pixayo.timer.model.SceneName;
import github.com.pixayo.timer.view.SceneFactory;
import github.com.pixayo.timer.view.ThemeManager;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class App extends Application {

    private static final Map<SceneName, Scene> scenes = new HashMap<>();
    private static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        App.stage = stage;

        scenes.put(SceneName.MAIN, SceneFactory.createScene(SceneName.MAIN));
        scenes.put(SceneName.SETTINGS, SceneFactory.createScene(SceneName.SETTINGS));

        ThemeManager.applyThemeGlobally();

        stage.setTitle("Timer");
        stage.setScene(scenes.get(SceneName.MAIN));
        stage.setMinWidth(250);
        stage.setMinHeight(250);
        stage.sizeToScene();
        stage.show();
    }

    public static void changeScene(SceneName sceneName) {
        stage.setScene(scenes.get(sceneName));
    }

    public static Map<SceneName, Scene> getScenes() {
        return scenes;
    }
}
