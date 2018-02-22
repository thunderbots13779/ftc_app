package org.firstinspires.ftc.teamcode.Actions;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Actions.Action;
import org.firstinspires.ftc.teamcode.Robot;

public class  RunToPosition implements Action {

    public int degrees;

    public RunToPosition(int degrees, Robot.Motors motors) {

        this.degrees = degrees;
        Robot.motors = motors;

    }
    public void start() {
        switch (Robot.motors) {
            case LEFT:
                setPosition(Robot.motor_leftIntake);
                break;
            case RIGHT:
                setPosition(Robot.motor_right);
                break;
            case CENTER:
                setPosition(Robot.motor_center);
                break;
            case RAISER:
                setPosition(Robot.motor_raiser);
                break;
            case FLIP:
                setPosition(Robot.motor_flipper);
                break;
        }
    }

    public void loop() {

    }

    public void end() {

    }

    public boolean check() {

        switch (Robot.motors) {
            case LEFT:
                return Robot.motor_left.isBusy();
            case RIGHT:
                return Robot.motor_right.isBusy();
            case CENTER:
                return Robot.motor_center.isBusy();
            case RAISER:
                return Robot.motor_raiser.isBusy();
            case FLIP:
                return Robot.motor_flipper.isBusy();
            default:
                return false;
        }

    }

    public void setPosition(DcMotor motor) {

        int currentPosition = motor.getCurrentPosition();

        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setPower(1);
        motor.setTargetPosition(currentPosition + degrees);
    }

}
