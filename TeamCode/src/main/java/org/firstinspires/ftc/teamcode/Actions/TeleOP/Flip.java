package org.firstinspires.ftc.teamcode.Actions.TeleOP;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Actions.Action;
import org.firstinspires.ftc.teamcode.Actions.RunToPosition;
import org.firstinspires.ftc.teamcode.Robot;

/**
 * Created by Pramodh on 2/10/18.
 */

public class Flip implements Action {

    public enum FlipperPositions {
        BOTTOM,
        MIDDLE,
        TOP
    }

    FlipperPositions flipperPos = FlipperPositions.BOTTOM;

    public void start() {
        Robot.startingPos = Robot.motor_flipper.getCurrentPosition();
    }

    public void loop() {

        switch (flipperPos) {
            case BOTTOM:
                if (Robot.gamepad2.right_bumper) {
                    Robot.active = true;
                    new RunToPosition(Robot.increment, Robot.Motors.FLIP).start();
                    flipperPos = FlipperPositions.MIDDLE;
                }
                break;
            case MIDDLE:
                if (Robot.gamepad2.left_bumper) {
                    new RunToPosition(Robot.increment, Robot.Motors.FLIP).start();
                    flipperPos = FlipperPositions.BOTTOM;
                } else if (Robot.gamepad2.right_bumper){
                    new RunToPosition(-Robot.increment, Robot.Motors.FLIP).start();
                    flipperPos = FlipperPositions.TOP;
                }
                break;
            case TOP:
                if (Robot.gamepad2.left_bumper) {
                    new RunToPosition(Robot.increment, Robot.Motors.FLIP).start();
                    flipperPos = FlipperPositions.MIDDLE;
                }
                break;
        }
    }

    public void end() {

    }

    public boolean check() {
        return false;
    }

}
