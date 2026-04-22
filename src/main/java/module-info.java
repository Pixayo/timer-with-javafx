module github.com.pixayo.timer {
    requires javafx.controls;
    requires javafx.fxml;


    opens github.com.pixayo.timer to javafx.fxml;
    opens github.com.pixayo.timer.controller to javafx.fxml;

    exports github.com.pixayo.timer;
}