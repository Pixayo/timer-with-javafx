module github.com.pixayo.timer {
    requires javafx.controls;
    requires java.desktop;


    opens github.com.pixayo.timer to javafx.fxml;
    exports github.com.pixayo.timer;
}