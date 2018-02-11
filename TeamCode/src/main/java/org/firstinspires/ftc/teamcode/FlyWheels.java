package org.firstinspires.ftc.teamcode;

/**
 * Created by Pramodh on 2/10/18.
 */

public class FlyWheels implements Action{

    public FlyWheels () {
    }

    public void start() {

    }
    public void loop() {
        if (Robot.gamepad1.left_trigger > 0) {
            Robot.motor_leftIntake.setPower(Robot.powerScale(Robot.gamepad1.left_trigger));
            Robot.motor_rightIntake.setPower(-Robot.powerScale(Robot.gamepad1.left_trigger));
        } else {
            Robot.motor_leftIntake.setPower(-Robot.powerScale(Robot.gamepad1.right_trigger));
            Robot.motor_rightIntake.setPower(Robot.powerScale(Robot.gamepad1.right_trigger));
        }
    }

    public void end() {

    }

    public boolean check() {
        return false;
    }

}
