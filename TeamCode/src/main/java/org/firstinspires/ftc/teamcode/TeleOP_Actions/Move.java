package org.firstinspires.ftc.teamcode.TeleOP_Actions;

import org.firstinspires.ftc.teamcode.Action;
import org.firstinspires.ftc.teamcode.Robot;

/**
 * Created by Pramodh on 2/12/18.
 */

public class Move implements Action {

    public void start() {

    }
    public void loop() {
        if(Robot.gamepad1.left_stick_button) {
            Robot.motor_center.setPower(-Robot.lowerPowerScale(Robot.gamepad1.left_stick_x));
            Robot.motor_right.setPower(Robot.lowerPowerScale(Robot.gamepad1.left_stick_y));
            Robot.motor_left.setPower(-Robot.lowerPowerScale(Robot.gamepad1.left_stick_y));
        } else {
            Robot.motor_center.setPower(-Robot.powerScale(Robot.gamepad1.left_stick_x));
            Robot.motor_right.setPower(Robot.powerScale(Robot.gamepad1.left_stick_y));
            Robot.motor_left.setPower(-Robot.powerScale(Robot.gamepad1.left_stick_y));
        }

    }

    public void end() {

    }

    public boolean check() {
        return false;
    }

}
