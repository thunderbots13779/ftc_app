package org.firstinspires.ftc.teamcode.Actions.Autonomous;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Actions.Action;
import org.firstinspires.ftc.teamcode.Robot;

public class MoveAuto extends RunUsingEncoder{

    float power;

    public MoveAuto(int ticks, float power) {
        super(ticks, Robot.Motors.LEFT, power);
        this.power = power;
        Robot.motor_left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Robot.motor_left.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Robot.motor_right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Robot.motor_right.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void start() {
        super.start();
        Robot.motor_right.setPower(power);
    }

    public void end() {
        super.end();
        Robot.motor_right.setPower(power);
    }

}
