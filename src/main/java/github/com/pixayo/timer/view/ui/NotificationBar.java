package github.com.pixayo.timer.view.ui;

import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class NotificationBar extends VBox {

    private static NotificationBar instance;
    private final Label messageLabel;
    private TranslateTransition slideIn;
    private TranslateTransition slideOut;

    private NotificationBar() {
        this.messageLabel = new Label();
        this.getChildren().add(messageLabel);

        this.setVisible(false);

        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-color: #e67e22; -fx-padding: 10;");

        this.setMaxHeight(Region.USE_PREF_SIZE);
        this.setMaxWidth(Region.USE_PREF_SIZE);
        this.setFillWidth(false);

        setupAnimations();
    }

    public static NotificationBar getInstance() {
        if (instance == null) {
            instance = new NotificationBar();
        }
        return instance;
    }

    private void setupAnimations() {
        slideIn = new TranslateTransition(Duration.seconds(0.2), this);
        slideIn.setToY(0);

        slideOut = new TranslateTransition(Duration.seconds(0.2), this);
        slideOut.setDelay(Duration.seconds(3));

        slideIn.setOnFinished(e -> slideOut.play());
    }

    public void show(String message) {
        this.messageLabel.setText(message);
        this.setVisible(true);

        this.applyCss();
        this.layout();
        double height = this.getHeight();

        this.setTranslateY(-height);
        slideOut.setToY(-height);

        slideIn.playFromStart();
    }
}
