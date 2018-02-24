package org.firstinspires.ftc.teamcode.Actions.TeleOP;

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
    boolean lastPressedRight = false;
    boolean lastPressedLeft = false;

    public void start() {

    }

    public void loop() {
        if (!lastPressedRight && !lastPressedLeft) {
            if (Robot.gamepad2.right_bumper)
                lastPressedRight = true;
            if (Robot.gamepad2.left_bumper)
                lastPressedLeft = true;
            switch (Robot.flipperPos) {
                case BOTTOM:
                    if (Robot.gamepad2.right_bumper) {
                        Robot.pos = new RunToPosition(middle, Robot.Motors.FLIP, upPower);
                        Robot.pos.start();
                        Robot.flipperPos = Robot.FlipperPositions.MIDDLE;
                    }
                    break;
                case MIDDLE:
                    if (Robot.gamepad2.left_bumper) {
                        Robot.pos = new RunToPosition(bottom, Robot.Motors.FLIP, downPower);
                        Robot.pos.start();
                        Robot.flipperPos = Robot.FlipperPositions.BOTTOM;
                    } else if (Robot.gamepad2.right_bumper) {
                        Robot.pos = new RunToPosition(top, Robot.Motors.FLIP, upPower);
                        Robot.pos.start();
                        Robot.flipperPos = Robot.FlipperPositions.TOP;
                    }
                    break;
                case TOP:
                    if (Robot.gamepad2.left_bumper) {
                        Robot.pos = new RunToPosition(bottom, Robot.Motors.FLIP, downPower);
                        Robot.pos.start();
                        Robot.flipperPos = Robot.FlipperPositions.BOTTOM;
                    }
                    break;
            }
        } else {
            if (!Robot.gamepad2.right_bumper)
                lastPressedRight = false;
            if (!Robot.gamepad2.left_bumper)
                lastPressedLeft = false;
        }
    }

    public void end() {

    }

    public boolean check() {
        return false;
    }

}
