module github.com.pixayo.timer {
    requires javafx.controls;


    opens github.com.pixayo.timer to javafx.fxml;
    exports github.com.pixayo.timer;
}