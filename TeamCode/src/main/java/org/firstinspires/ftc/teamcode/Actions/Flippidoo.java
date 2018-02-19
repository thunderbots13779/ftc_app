package org.firstinspires.ftc.teamcode.Actions;

import org.firstinspires.ftc.teamcode.Actions.Action;
import org.firstinspires.ftc.teamcode.Robot;

/**
 * Created by Pramodh on 2/10/18.
 */

public class Flippidoo implements Action {

    public Flippidoo () {
    }

    public void start() {

    }
    public void loop() {
        if(Robot.gamepad1.left_bumper){
            Robot.motor_flipper.setPower(.5);
        } else if (Robot.gamepad1.right_bumper){
            Robot.motor_flipper.setPower(-.5);
        } else {
            Robot.motor_flipper.setPower(0);
        }
    }


    public void end() {

    }

    public boolean check() {
        return false;
    }

}
