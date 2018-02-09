package org.firstinspires.ftc.teamcode;

public class Grab implements Action {

    public Grab (boolean backButtonPressed) {
        Robot.backButtonPressed = backButtonPressed;
    }

    public void start() {
        if (Robot.backButtonPressed) {
            if (Robot.open) {
                Robot.servo_leftGrabber.setPosition(Robot.OPEN_POSITION_LEFT);
                Robot.servo_rightGrabber.setPosition(Robot.OPEN_POSITION_RIGHT);
                Robot.open = !Robot.open;
            } else {
                Robot.servo_leftGrabber.setPosition(Robot.OPEN_POSITION_LEFT);
                Robot.servo_rightGrabber.setPosition(Robot.OPEN_POSITION_RIGHT);
                Robot.open = !Robot.open;
            }
        }
    }
    public void loop() {

    }

    public void end() {

    }

    public boolean check() {
        return false;
    }

}
