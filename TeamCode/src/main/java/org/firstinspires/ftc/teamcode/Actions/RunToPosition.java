package org.firstinspires.ftc.teamcode.Actions;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Actions.Action;
import org.firstinspires.ftc.teamcode.Robot;

public class  RunToPosition implements Action {

    int ticks;
    double power;
    DcMotor motor;
    int marginOfError = 100;

    public RunToPosition(int ticks, Robot.Motors motors, double power) {

        this.ticks = ticks;
        this.power = power;
        Robot.motors = motors;


    }
    public void start() {
        switch (Robot.motors) {
            case LEFT:
                motor = Robot.motor_leftIntake;
                break;
            case RIGHT:
                motor = Robot.motor_rightIntake;
                break;
            case CENTER:
                motor = Robot.motor_center;
                break;
            case RAISER:
                motor = Robot.motor_raiser;
                break;
            case FLIP:
                motor = Robot.motor_flipper;
                break;
        }
        setPosition();
    }

    public void loop() {

    }

    public void end() {

    }

    public boolean check() {

        if (motor.getCurrentPosition() > (ticks - marginOfError) && motor.getCurrentPosition() < (ticks + marginOfError)) {
            return true;
        } else {
            return false;
        }

    }

    public void setPosition() {
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setPower(power);
        motor.setTargetPosition(ticks);
    }

}
