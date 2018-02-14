package org.firstinspires.ftc.teamcode;

/**
 * Created by Pramodh on 2/12/18.
 */

public class HDriveCorrection implements Action{

    public HDriveCorrection (float targetAngle) {
        Robot.targetAngle = targetAngle;
    }

    public void start() {

    }
    public void loop() {
        if (Robot.targetAngle-Robot.angles.firstAngle > 0) {
            Robot.motor_left.setPower(-(Robot.targetAngle-Robot.angles.firstAngle));
        } else if (Robot.targetAngle-Robot.angles.firstAngle < 0) {
            Robot.motor_right.setPower(Math.abs(Robot.targetAngle-Robot.angles.firstAngle));
        }
    }

    public void end() {

    }

    public boolean check() {
        return false;
    }

}

