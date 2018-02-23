package org.firstinspires.ftc.teamcode.Actions.TeleOP;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Actions.Action;
import org.firstinspires.ftc.teamcode.Actions.RunToPosition;
import org.firstinspires.ftc.teamcode.Robot;

/**
 * Created by Pramodh on 2/10/18.
 */

public class Flip implements Action {

    double upPower = .5;
    double downPower = .3;
    int bottom = 0;
    int middle = -170;
    int top = -400;

    public enum FlipperPositions {
        BOTTOM,
        MIDDLE,
        TOP
    }

    public void start() {

    }

    public void loop() {

        switch (Robot.flipperPos) {
            case BOTTOM:
                if (Robot.gamepad2.right_bumper) {
                    Robot.pos = new RunToPosition(middle, Robot.Motors.FLIP, upPower);
                    Robot.pos.start();
                    Robot.flipperPos = FlipperPositions.MIDDLE;
                }
                break;
            case MIDDLE:
                if (Robot.gamepad2.left_bumper) {
                    Robot.pos = new RunToPosition(bottom, Robot.Motors.FLIP, downPower);
                    Robot.pos.start();
                    Robot.flipperPos = FlipperPositions.BOTTOM;
                } else if (Robot.gamepad2.a) {
                    Robot.pos = new RunToPosition(top, Robot.Motors.FLIP, upPower);
                    Robot.pos.start();
                    Robot.flipperPos = FlipperPositions.TOP;
                }
                break;
            case TOP:
                if (Robot.gamepad2.left_bumper) {
                    Robot.pos = new RunToPosition(bottom, Robot.Motors.FLIP, downPower);
                    Robot.pos.start();
                    Robot.flipperPos = FlipperPositions.BOTTOM;
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
