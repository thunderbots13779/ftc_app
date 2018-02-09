package org.firstinspires.ftc.teamcode;

/**
 * Created by Pramodh on 2/8/18.
 */

public class Grab_Auto implements Action {

    public void start() {
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
    public void loop() {

    }

    public void end() {

    }

    public boolean check() {
        return false;
    }

}
