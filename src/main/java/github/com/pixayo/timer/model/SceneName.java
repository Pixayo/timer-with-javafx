package github.com.pixayo.timer.model;

public enum SceneName {
    MAIN("MainView.fxml"),
    SETTINGS("SettingsView.fxml");

    private final String filename;

    SceneName(String filename) {
        this.filename = filename;
    }

    public String getFxmlFile() {
        return filename;
    }
}
