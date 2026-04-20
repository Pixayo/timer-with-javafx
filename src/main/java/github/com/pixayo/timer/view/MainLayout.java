package github.com.pixayo.timer.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MainLayout extends VBox {

    private final Label timerText = new Label("00:00");;
    private final Label previousTimerText = new Label("no previous timer");
    private final ButtonContainer actions;

    public MainLayout(int spacing) {
        super(spacing);
        actions = new ButtonContainer(spacing);

        this.timerText.setFont(Font.font("Monospaced", FontWeight.BOLD, 48));

        this.previousTimerText.setFont(Font.font("monospaced", FontWeight.LIGHT, 12));
        this.previousTimerText.setStyle("-fx-text-fill: #A1A1A1");

        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(30));
        this.getChildren().addAll(timerText, previousTimerText, actions);
    }

    public void setPreviousTimerText(String text) {
        previousTimerText.setText(text);
    }

    public Label getTimerText() {
        return timerText;
    }

    public void addButton(String label, EventHandler<ActionEvent> e) {
        actions.addButton(label, e);
    }
}
