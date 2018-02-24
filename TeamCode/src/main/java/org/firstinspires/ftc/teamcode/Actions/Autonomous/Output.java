package org.firstinspires.ftc.teamcode.Actions.Autonomous;

import org.firstinspires.ftc.teamcode.Robot;

public class Output extends Timed {
    public Output(long duration) {
        super(duration);
    }

    @Override
    public void start() {
        super.start();
        Robot.motor_rightIntake.setPower(-1);
        Robot.motor_leftIntake.setPower(1);
    }

    @Override
    public void end() {
        super.end();
        Robot.motor_rightIntake.setPower(0);
        Robot.motor_leftIntake.setPower(0);
    }

}
