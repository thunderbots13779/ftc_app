package org.firstinspires.ftc.teamcode;

/**
 * Created by Pramodh on 2/10/18.
 */

public class FlyWheels implements Action{

    public void start() {

    }
    public void loop() {
        if(Robot.gamepad2.a) {
            Robot.motor_leftIntake.setPower(Robot.powerScale(Robot.gamepad2.left_trigger));
            Robot.motor_rightIntake.setPower(-Robot.powerScale(Robot.gamepad2.right_trigger));
        } else {
            Robot.motor_leftIntake.setPower(-Robot.powerScale(Robot.gamepad2.left_trigger));
            Robot.motor_rightIntake.setPower(Robot.powerScale(Robot.gamepad2.right_trigger));
        }
    }

    public void end() {

    }

    public boolean check() {
        return false;
    }

}
