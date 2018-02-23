package org.firstinspires.ftc.teamcode.Actions.TeleOP;

import org.firstinspires.ftc.teamcode.Actions.Action;
import org.firstinspires.ftc.teamcode.Robot;

public class Move implements Action {

    public void start() {

    }
    public void loop() {
        if (Robot.gamepad1.left_bumper) {
            Robot.motor_center.setPower(1);
        } else if (Robot.gamepad1.right_bumper){
            Robot.motor_center.setPower(-1);
        } else {
            Robot.motor_center.setPower(0);
        }
        if (Robot.gamepad1.right_stick_y >= 0) {
            Robot.motor_right.setPower(-Robot.powerScale(Robot.gamepad1.right_stick_y));
        } else {
            Robot.motor_right.setPower(Robot.powerScale(Robot.gamepad1.right_stick_y));
        }
        if (Robot.gamepad1.left_stick_y >= 0) {
            Robot.motor_left.setPower(Robot.powerScale(Robot.gamepad1.left_stick_y));
        } else {
            Robot.motor_left.setPower(-Robot.powerScale(Robot.gamepad1.left_stick_y));
        }
//        Robot.motor_center.setPower(-Robot.gamepad1.left_stick_x);
//        if(Robot.gamepad1.left_stick_button) {
//            if (Robot.gamepad1.left_stick_y >= 0) {
//                Robot.motor_right.setPower(-Robot.lowerPowerScale(Robot.gamepad1.left_stick_y));
//                Robot.motor_left.setPower(Robot.lowerPowerScale(Robot.gamepad1.left_stick_y));
//            } else {
//                Robot.motor_right.setPower(Robot.lowerPowerScale(Robot.gamepad1.left_stick_y));
//                Robot.motor_left.setPower(-Robot.lowerPowerScale(Robot.gamepad1.left_stick_y));
//            }
//        } else {
//            if (Robot.gamepad1.left_stick_y >= 0) {
//                Robot.motor_right.setPower(-Robot.powerScale(Robot.gamepad1.left_stick_y));
//                Robot.motor_left.setPower(Robot.powerScale(Robot.gamepad1.left_stick_y));
//            } else {
//                Robot.motor_right.setPower(Robot.powerScale(Robot.gamepad1.left_stick_y));
//                Robot.motor_left.setPower(-Robot.powerScale(Robot.gamepad1.left_stick_y));
//            }
//        }
    }

    public void end() {

    }

    public boolean check() {
        return false;
    }

}
