package github.com.pixayo.timer.view;

import github.com.pixayo.timer.model.SceneName;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import java.io.IOException;
import java.net.URL;

public class SceneFactory {

    public static Scene createScene(SceneName sceneName) {
        String fxml = sceneName.getFxmlFile();

        try {
            FXMLLoader loader = new FXMLLoader(SceneFactory.class.getResource(fxml));
            Region root = loader.load();

            Scene scene = new Scene(root);

            applyGlobalStyle(scene);

            return scene;

        } catch (IOException e) {
            throw new RuntimeException("SCENE FACTORY: " + fxml, e);
        }
    }

    private static void applyGlobalStyle(Scene scene) {
        String filename = "style.css";

        try {
            URL cssPath = SceneFactory.class.getResource(filename);
            scene.getStylesheets().add(cssPath.toExternalForm());

        } catch (NullPointerException e) {
            System.err.printf("SCENE FACTORY: failed to apply CSS -> (%s)", filename);
        }
    }
}