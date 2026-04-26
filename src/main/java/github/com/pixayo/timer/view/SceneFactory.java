package github.com.pixayo.timer.view;

import github.com.pixayo.timer.model.SceneName;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import java.io.IOException;

public class SceneFactory {

    public static Scene createScene(SceneName sceneName) {
        String fxml = sceneName.getFxmlFile();

        try {
            FXMLLoader loader = new FXMLLoader(SceneFactory.class.getResource(fxml));
            Region root = loader.load();

            Scene scene = new Scene(root);
            ThemeManager.applyThemeGlobally();

            return scene;

        } catch (IOException e) {
            throw new RuntimeException("SCENE FACTORY: " + fxml, e);
        }
    }
}