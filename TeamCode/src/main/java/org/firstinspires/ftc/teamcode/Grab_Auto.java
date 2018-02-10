package org.firstinspires.ftc.teamcode;

/**
 * Created by Pramodh on 2/8/18.
 */

public class Grab_Auto extends Timed {

    Robot.Grabber_State state = Robot.Grabber_State.CLOSED;

    public Grab_Auto(long duration) {
        super(duration);
    }

    public void start() {
        if(state == Robot.Grabber_State.CLOSED) {
            Robot.servo_leftGrabber.setPosition(Robot.CLOSED_POSITION_LEFT);
            Robot.servo_rightGrabber.setPosition(Robot.CLOSED_POSITION_RIGHT);
        } else if (state == Robot.Grabber_State.OPEN) {
            Robot.servo_leftGrabber.setPosition();
            Robot.servo_rightGrabber.setPosition();
        } else if (state == Robot.Grabber_State.FULLY_OPEN) {
            Robot.servo_leftGrabber.setPosition(Robot.OPEN_POSITION_LEFT);
            Robot.servo_rightGrabber.setPosition(Robot.OPEN_POSITION_RIGHT);
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
