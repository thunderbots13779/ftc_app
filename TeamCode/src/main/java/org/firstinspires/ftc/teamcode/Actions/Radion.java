package org.firstinspires.ftc.teamcode.Actions;

import org.firstinspires.ftc.teamcode.Actions.Action;
import org.firstinspires.ftc.teamcode.Robot;

/**
 * Created by Pramodh on 2/10/18.
 */

public class Radion implements Action {

    double x;
    double y;
    double angle;

    public void start() {
    }
    public void loop() {
        x = Robot.gamepad1.right_stick_x;
        y = Robot.gamepad1.right_stick_y;
        angle  = Math.toDegrees(Math.asin((-1*y)/(Math.sqrt(Math.pow(x, 2)+Math.pow(-1*y, 2)))));
        if(y == -1 && x == 0) {
            Robot.theta = 0;
        } else if (y >= 0 && x >= 0){
            Robot.theta = 90-angle;
        } else if (y <= 0 && x >= 0) {
            Robot.theta = 180-angle;
        } else if (y <= 0 && x <= 0) {
            Robot.theta = angle-90;
        } else if (y >= 0 && x <= 0) {
            Robot.theta = 360-angle;
        }

    }

    public void end() {

    }

    public boolean check() {
        return false;
    }

}
