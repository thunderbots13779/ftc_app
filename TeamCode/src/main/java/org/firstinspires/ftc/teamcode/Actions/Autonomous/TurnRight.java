package org.firstinspires.ftc.teamcode.Actions.Autonomous;

import org.firstinspires.ftc.teamcode.Robot;

public class TurnRight extends Timed {
    public TurnRight(long duration) {
        super(duration);
    }

    @Override
    public void start() {
        super.start();
        Robot.motor_right.setPower(-1);
        Robot.motor_left.setPower(-1);
    }

    @Override
    public void end() {
        super.end();
        Robot.motor_right.setPower(0);
        Robot.motor_left.setPower(0);
    }

}
