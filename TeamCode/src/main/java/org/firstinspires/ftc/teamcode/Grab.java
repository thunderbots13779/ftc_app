package org.firstinspires.ftc.teamcode;

public class Grab implements Action {

    boolean open = false;

    public void start() {
        if (open) {
            Robot.servo_leftGrabber.setPosition(Robot.OPEN_POSITION_LEFT);
            Robot.servo_rightGrabber.setPosition(Robot.OPEN_POSITION_RIGHT);
            open = !open;
        } else {
            Robot.servo_leftGrabber.setPosition(Robot.OPEN_POSITION_LEFT);
            Robot.servo_rightGrabber.setPosition(Robot.OPEN_POSITION_RIGHT);
            open = !open;
        }
    }
    public void loop() {

    }

    public void end() {

    }

    public boolean check() {
        return true;
    }

}
