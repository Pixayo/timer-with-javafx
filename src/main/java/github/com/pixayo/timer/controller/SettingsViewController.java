package github.com.pixayo.timer.controller;

import github.com.pixayo.timer.App;
import github.com.pixayo.timer.model.SceneName;
import github.com.pixayo.timer.model.Settings;
import github.com.pixayo.timer.view.ThemeManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class SettingsViewController {

    @FXML private Button backButton;
    @FXML private CheckBox darkModeCheckbox;
    @FXML private CheckBox disableLabelCheckbox;

    @FXML
    public void initialize() {
        darkModeCheckbox.setSelected(Settings.isDarkMode());
        disableLabelCheckbox.setSelected(Settings.isLabelDisabled());
        System.out.println(Settings.isDarkMode());
    }

    @FXML
    private void handleBack(ActionEvent actionEvent) {
        App.changeScene(SceneName.MAIN);
    }

    @FXML
    private void handleDarkMode(ActionEvent actionEvent) {
        boolean isDark = Settings.isDarkMode();
        Settings.setDarkMode(!isDark);
        ThemeManager.applyThemeGlobaly();
        System.out.println(isDark);
    }

    @FXML
    private void handleDisableLabel(ActionEvent actionEvent) {
        Settings.setLabelDisabled(!Settings.isLabelDisabled());
    }
}
