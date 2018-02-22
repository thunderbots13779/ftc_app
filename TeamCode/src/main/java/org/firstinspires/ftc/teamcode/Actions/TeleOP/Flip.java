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

    public void start() {
        Robot.startingPos = Robot.motor_flipper.getCurrentPosition();
    }

    public void loop() {

        switch (Robot.flipperPos) {
            case BOTTOM:
                if (Robot.gamepad2.right_bumper) {
                    Robot.pos = new RunToPosition(-Robot.increment, Robot.Motors.FLIP);
                    Robot.pos.start();
                    if (Robot.pos.check()) {
                        Robot.flipperPos = FlipperPositions.MIDDLE;
                    }
                }
                break;
            case MIDDLE:
                if (Robot.gamepad2.left_bumper) {
                    Robot.pos = new RunToPosition(Robot.increment, Robot.Motors.FLIP);
                    Robot.pos.start();
                    if (Robot.pos.check()) {
                        Robot.flipperPos = FlipperPositions.BOTTOM;
                    }
                } else if (Robot.gamepad2.right_bumper){
                    Robot.pos = new RunToPosition(-Robot.increment, Robot.Motors.FLIP);
                    Robot.pos.start();
                    if (Robot.pos.check()) {
                        Robot.flipperPos = FlipperPositions.TOP;
                    }
                }
                break;
            case TOP:
                if (Robot.gamepad2.left_bumper) {
                    Robot.pos = new RunToPosition(Robot.increment, Robot.Motors.FLIP);
                    Robot.pos.start();
                    if (Robot.pos.check()) {
                        Robot.flipperPos = FlipperPositions.BOTTOM;
                    }
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
