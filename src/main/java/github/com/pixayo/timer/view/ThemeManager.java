package github.com.pixayo.timer.view;

import github.com.pixayo.timer.App;
import github.com.pixayo.timer.model.Settings;
import javafx.scene.Scene;

public class ThemeManager {

    private static final String stylefile = "style.css";

    public static void applyThemeGlobaly() {
        String themefile = Settings.isDarkMode() ? "dark-theme.css" : "light-theme.css";

        try {
            String themePath = ThemeManager.class.getResource(themefile).toExternalForm();
            String stylePath = ThemeManager.class.getResource(stylefile).toExternalForm();

            for (Scene scene : App.getScenes().values()) {
                scene.getStylesheets().clear();
                scene.getStylesheets().addAll(themePath, stylePath);
            }

        } catch (NullPointerException e) {
            System.err.printf("THEME MANAGER: failed to apply theme CSS -> (%s)", themefile);
        }
    }
}
