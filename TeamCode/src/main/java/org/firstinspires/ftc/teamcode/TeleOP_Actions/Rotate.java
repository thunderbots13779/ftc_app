package org.firstinspires.ftc.teamcode.TeleOP_Actions;

import org.firstinspires.ftc.teamcode.Action;
import org.firstinspires.ftc.teamcode.Robot;

/**
 * Created by Pramodh on 2/12/18.
 */

public class Rotate implements Action {

    public void start() {

    }
    public void loop() {
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

    public void end() {

    }

    public boolean check() {
        return false;
    }

}
