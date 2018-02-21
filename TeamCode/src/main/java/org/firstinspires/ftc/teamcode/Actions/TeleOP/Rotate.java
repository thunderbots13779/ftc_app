package org.firstinspires.ftc.teamcode.Actions.TeleOP;

import org.firstinspires.ftc.teamcode.Actions.Action;
import org.firstinspires.ftc.teamcode.Robot;

/**
 * Created by Pramodh on 2/12/18.
 */

public class Rotate implements Action {

    public void start() {
    }
    public void loop() {
        if (Robot.gamepad1.right_stick_button) {

            /*
                if (blue) {
                    cryptoAngle = 90;
                } else {
                    cryptoAngle = -90
                }
             */

            if (Robot.gamepad1.right_stick_y > .95) {
                //turn to cryptoAngle
            } else if (Robot.gamepad1.left_stick_y < -.95) {
                //turn to -cryptoAngle
            } else if (Robot.gamepad1.left_stick_x > .95) {
                //turn to 0
            } else if (Robot.gamepad1.left_stick_x < -.95) {
                //turn to 180
            }
        } else {
            if (Robot.gamepad1.left_stick_x > 0) {
                Robot.motor_left.setPower(1);
                Robot.motor_right.setPower(1);
            } else if (Robot.gamepad1.left_stick_x < 0){
                Robot.motor_left.setPower(-1);
                Robot.motor_right.setPower(-1);
            } else {
                Robot.motor_left.setPower(0);
                Robot.motor_right.setPower(0);
            }
        }
    }

    public void end() {

    }

    public boolean check() {
        return false;
    }

}
