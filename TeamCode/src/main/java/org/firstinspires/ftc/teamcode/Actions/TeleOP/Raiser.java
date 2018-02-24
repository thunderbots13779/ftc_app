package org.firstinspires.ftc.teamcode.Actions.TeleOP;

import org.firstinspires.ftc.teamcode.Actions.Action;
import org.firstinspires.ftc.teamcode.Actions.RunToPosition;
import org.firstinspires.ftc.teamcode.Robot;

/**
 * Created by Pramodh on 2/10/18.
 */

public class Raiser implements Action {

    public void start() {

    }

    public void loop() {
        if (Robot.gamepad2.right_bumper) {
            Robot.motor_raiser.setPower(.5);
        } else if (Robot.gamepad2.left_bumper){
            Robot.motor_raiser.setPower(-.3);
        } else {
            Robot.motor_raiser.setPower(0);
        }
    }

    public void end() {

    }

    public boolean check() {
        return false;
    }

}
