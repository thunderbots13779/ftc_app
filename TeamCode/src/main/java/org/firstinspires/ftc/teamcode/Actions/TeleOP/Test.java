package org.firstinspires.ftc.teamcode.Actions.TeleOP;

import org.firstinspires.ftc.teamcode.Actions.Action;
import org.firstinspires.ftc.teamcode.Robot;

public class Test implements Action {

    public void start() {

    }
    public void loop() {
        Robot.motor_leftIntake.setPower(Robot.gamepad1.left_stick_y);
    }

    public void end() {

    }

    public boolean check() {
        return false;
    }

}
