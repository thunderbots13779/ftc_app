package org.firstinspires.ftc.teamcode;

/**
 * Created by DiegoGutiDev on 11/12/17.
 */

import com.qualcomm.robotcore.hardware.Servo;

public class Grabber {

    private Servo leftServo, rightServo;

    public boolean closed = false;
    public boolean isPressed = false;

    private final double LEFT_FULL_OPEN_POSITION = (174.0/180);
    private final double LEFT_OPEN_POSITION = (139.0/180);
    private final double LEFT_CLOSED_POSITION = (84.0/180);
    private final double RIGHT_FULL_OPEN_POSITION = (28.0/180);
    private final double RIGHT_OPEN_POSITION = (63.0/180);
    private final double RIGHT_CLOSED_POSITION = (118.0/180);

    public Grabber(Servo left, Servo right) {

        this.leftServo = left;
        this.rightServo = right;

//        leftServo.setPosition(LEFT_FULL_OPEN_POSITION);
//        rightServo.setPosition(RIGHT_FULL_OPEN_POSITION);

    }

    public void Grab(boolean change) {

        if (!isPressed) {

            if (change) {
                if (closed) {
                    leftServo.setPosition(LEFT_OPEN_POSITION);
                    rightServo.setPosition(RIGHT_OPEN_POSITION);

                    closed = false;
                } else {
                    leftServo.setPosition(LEFT_CLOSED_POSITION);
                    rightServo.setPosition(RIGHT_CLOSED_POSITION);

                    closed = true;
                }

                isPressed = true;
            }

        }
        if (!change) {
            isPressed = false;
        }
    }

    public void GrabSide(boolean left, boolean right) {

        if (!isPressed) {

            if (right) {
                if (closed) {
                    rightServo.setPosition(RIGHT_OPEN_POSITION);
                    closed = false;
                } else {
                    rightServo.setPosition(RIGHT_CLOSED_POSITION);
                    closed = true;
                }

                isPressed = true;
            }

            if (left) {
                if (closed) {
                    leftServo.setPosition(LEFT_OPEN_POSITION);
                    closed = false;
                } else {
                    leftServo.setPosition(LEFT_CLOSED_POSITION);
                    closed = true;
                }

                isPressed = true;
            }

        }
        if (!right && !left) {
            isPressed = false;
        }
    }

//    public void reset() {
//        leftServo.setPosition(LEFT_FULL_OPEN_POSITION);
//        rightServo.setPosition(RIGHT_FULL_OPEN_POSITION);
//    }

}
