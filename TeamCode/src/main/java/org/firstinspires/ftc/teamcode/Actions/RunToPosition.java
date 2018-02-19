package org.firstinspires.ftc.teamcode.Actions;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Actions.Action;
import org.firstinspires.ftc.teamcode.Motors;
import org.firstinspires.ftc.teamcode.Robot;

public class  RunToPosition implements Action {

    public int degrees;

    public DcMotor motor;

    Motors motors;

    public RunToPosition(int degrees, Motors motors) {

        this.degrees = degrees;
        this.motors = motors;

    }
    public void start() {
        switch (motors) {
            case LEFT:
                setPosition(Robot.motor_leftIntake);
                break;
            case RIGHT:
                setPosition(Robot.motor_right);
                break;
            case CENTER:
                setPosition(Robot.motor_center);
                break;
            case FlIPPER:
                setPosition(Robot.motor_flipper);
                break;
            case RAISER:
                setPosition(Robot.motor_raiser);
                break;
        }
    }

    public void loop() {



    }

    public void end() {

    }

    public boolean check() {

        boolean answer = false;

        switch (motors) {
            case LEFT:
                answer = Robot.motor_left.isBusy();
                break;
            case RIGHT:
                answer = Robot.motor_right.isBusy();
                break;
            case CENTER:
                answer = Robot.motor_center.isBusy();
                break;
            case FlIPPER:
                answer = Robot.motor_flipper.isBusy();
                break;
            case RAISER:
                answer = Robot.motor_raiser.isBusy();
                break;
        }

        if (!answer) {
            return false;
        } else {
            return true;
        }

    }

    public void setPosition(DcMotor motor) {

        int currentPosition = motor.getCurrentPosition();

        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setPower(1);
        motor.setTargetPosition(currentPosition + degrees);

    }

    public int revolution(int rot) {
        return rot*1680;
    }

    public int degreesToTicks(int degrees) {

        int ticks = (int)(1120 * degrees / 360d);

        return ticks;

    }

}
