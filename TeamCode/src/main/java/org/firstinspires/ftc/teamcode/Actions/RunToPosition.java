package org.firstinspires.ftc.teamcode.Actions;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Actions.Action;
import org.firstinspires.ftc.teamcode.Robot;

public class  RunToPosition implements Action {

    public int degrees;
    DcMotor motor;
    int currentPosition;



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

        if (motor.getCurrentPosition() == (currentPosition + degrees)) {
            return true;
        } else {
            return false;
        }

    }

    public void setPosition() {


        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        currentPosition = Robot.motor_flipper.getCurrentPosition();
        motor.setPower(1);
        motor.setTargetPosition(currentPosition + degrees);
    }

}
