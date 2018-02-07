package org.firstinspires.ftc.teamcode;

public class Grab implements Actionable {

    boolean open = false;

    public void initialize() {

    }

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

    public boolean check() {
        return true;
    }

    public void stop() {

    }

}
