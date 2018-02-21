package org.firstinspires.ftc.teamcode.Actions.TeleOP;

import org.firstinspires.ftc.teamcode.Actions.Action;
import org.firstinspires.ftc.teamcode.Robot;

public class Move implements Action {

    public void start() {

    }
    public void loop() {
        //TODO: Fix these controls to go both ways again
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
