package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.awt.*;

public class MainController {

    private double getRandomNumber(double from, double to) {
        int randomInt = (int) (from + (int) (Math.random() * ((to - from) + 1)));
        return (double) randomInt;
    }

    public void moveButton() {
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;

        double xMax = width - myButton.getWidth();
        double yMax = height - myButton.getHeight();
        myButton.setLayoutX(getRandomNumber(0, xMax));
        myButton.setLayoutY(getRandomNumber(0, yMax));
    }

    public void myButtonAction(ActionEvent e) {
        moveButton();
    }

    @FXML
    private Button myButton;

    @FXML
    public void initialize() {
        myButton.setText("click me");
        myButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                myButtonAction(e);
            }
        });

        moveButton();
    }

}
