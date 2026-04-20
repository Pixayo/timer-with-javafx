package github.com.pixayo.timer.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class ButtonContainer extends HBox {

    protected final ArrayList<Button> buttons = new ArrayList<>();

    protected ButtonContainer(int spacing) {
        super(spacing);
        this.setAlignment(Pos.CENTER);
    }

    protected void addButton(String label, EventHandler<ActionEvent> e) {
        Button button = new Button(label);
        button.setOnAction(e);
        button.setPrefHeight(40);

        this.getChildren().add(button);
        buttons.add(button);
    }
}
