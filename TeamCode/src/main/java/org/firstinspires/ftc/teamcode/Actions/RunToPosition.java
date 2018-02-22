package org.firstinspires.ftc.teamcode.Actions;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Actions.Action;
import org.firstinspires.ftc.teamcode.Robot;

public class  RunToPosition implements Action {

    public int degrees;
    DcMotor motor;

    public RunToPosition(int degrees, Robot.Motors motors) {

        this.degrees = degrees;
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

        if (motor.getCurrentPosition() == motor.getTargetPosition()) {
            return true;
        } else {
            return false;
        }

    }

    public void setPosition() {

        int currentPosition = motor.getCurrentPosition();

        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setPower(1);
        motor.setTargetPosition(currentPosition + degrees);
    }

}
