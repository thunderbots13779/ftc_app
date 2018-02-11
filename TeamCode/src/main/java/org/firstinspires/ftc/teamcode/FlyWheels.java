package org.firstinspires.ftc.teamcode;

/**
 * Created by Pramodh on 2/10/18.
 */

public class FlyWheels implements Action{

    public FlyWheels (double leftTrigger, double rightTrigger) {
        Robot.leftTrigger = leftTrigger;
        Robot.rightTrigger = rightTrigger;
    }

    public void start() {

    }
    public void loop() {
        Robot.motor_leftIntake.setPower(Robot.powerScale(Robot.leftTrigger));
        Robot.motor_leftIntake.setPower(Robot.powerScale(Robot.leftTrigger));
    }

    public void end() {

    }

    public boolean check() {
        return false;
    }

}
