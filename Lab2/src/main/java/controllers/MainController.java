package controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class MainController {

    private double xEnd;
    private double yEnd;
    private double speed;

    private double getRandomNumber(double from, double to) {
        int randomInt = (int) (from + (int) (Math.random() * ((to - from) + 1)));
        return (double) randomInt;
    }

    private void moveButton() {
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;

        double xMax = width - myButton.getWidth();
        double yMax = height - myButton.getHeight();

        xEnd = getRandomNumber(0, xMax);
        yEnd = getRandomNumber(0, yMax);
        performMove();
    }

    private void performMove() {
        speed = 4.0;
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                double distanceX = xEnd - myButton.getLayoutX();
                double distanceY = yEnd - myButton.getLayoutY();
                double vector = Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2));

                if (vector > speed) {
                    myButton.setLayoutX(myButton.getLayoutX() + speed * distanceX / vector);
                    myButton.setLayoutY(myButton.getLayoutY() + speed * distanceY / vector);
                } else {
                    myButton.setLayoutX(xEnd);
                    myButton.setLayoutY(yEnd);
                }
            }
        };
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(task, 0, 20);

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
