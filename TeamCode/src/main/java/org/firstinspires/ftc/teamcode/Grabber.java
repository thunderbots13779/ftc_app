package org.firstinspires.ftc.teamcode;

/**
 * Created by DiegoGutiDev on 11/12/17.
 */

import com.qualcomm.robotcore.hardware.Servo;

public class Grabber {

    private Servo leftServo, rightServo;

    public boolean closed = false;
    public boolean leftClosed = false;
    public boolean rightClosed = false;
    public boolean isPressed = false;
    public boolean sideIsPressed = false;

    private final double LEFT_FULL_OPEN_POSITION = (174.0/180.0);
    private final double LEFT_OPEN_POSITION = (149.0/180.0);
    private final double LEFT_CLOSED_POSITION = (84.0/180.0);
    private final double RIGHT_FULL_OPEN_POSITION = (28.0/180.0);
    private final double RIGHT_OPEN_POSITION = (53.0/180.0);
    private final double RIGHT_CLOSED_POSITION = (118.0/180.0);

    public Grabber(Servo left, Servo right) {

        this.leftServo = left;
        this.rightServo = right;

//        leftServo.setPosition(LEFT_CLOSED_POSITION);
//        rightServo.setPosition(RIGHT_CLOSED_POSITION);

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

        if (!sideIsPressed) {

            if (right) {
                if (rightClosed) {
                    rightServo.setPosition(RIGHT_OPEN_POSITION);
                    rightClosed = false;
                } else {
                    rightServo.setPosition(RIGHT_CLOSED_POSITION);
                    rightClosed = true;
                }

                sideIsPressed = true;
            }

            if (left) {
                if (leftClosed) {
                    leftServo.setPosition(LEFT_OPEN_POSITION);
                    leftClosed = false;
                } else {
                    leftServo.setPosition(LEFT_CLOSED_POSITION);
                    leftClosed = true;
                }

                sideIsPressed = true;
            }

        }
        if (!right && !left) {
            sideIsPressed = false;
        }
    }

}
