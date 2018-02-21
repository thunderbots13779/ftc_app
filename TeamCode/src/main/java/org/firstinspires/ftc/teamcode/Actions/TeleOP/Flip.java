package org.firstinspires.ftc.teamcode.Actions.TeleOP;

import org.firstinspires.ftc.teamcode.Actions.Action;
import org.firstinspires.ftc.teamcode.Actions.Autonomous.MoveServo;
import org.firstinspires.ftc.teamcode.Robot;

public class Flip implements Action {
    public void start() {
        if (Robot.gamepad2.a) {
            if (Robot.bottom) {
                new MoveServo(Robot.Servos.LEFT_FLIPPER, Robot.leftFlipperTop);
                new MoveServo(Robot.Servos.RIGHT_FLIPPER, Robot.rightFlipperTop);
                Robot.bottom = !Robot.bottom;
            } else {
                new MoveServo(Robot.Servos.LEFT_FLIPPER, Robot.leftFlipperBottom);
                new MoveServo(Robot.Servos.RIGHT_FLIPPER, Robot.rightFlipperBottom);
                Robot.bottom = !Robot.bottom;
            }
        }
    }
    public void loop() {

    }

    public void end() {

    }

    public boolean check() {
        return false;
    }

}
