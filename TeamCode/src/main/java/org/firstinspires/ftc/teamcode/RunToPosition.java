package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public class  RunToPosition implements Action {

    public double revolutions;
    public DcMotor motor;

    Motors motors;

    public RunToPosition(double revolutions, Motors motors) {

        this.revolutions = revolutions;
        this.motors = motors;

    }
    public void start() {
        switch (motors) {
            case LEFT:
                motor = Robot.motor_left;
                break;
            case RIGHT:
                motor = Robot.motor_right;
                break;
            case CENTER:
                motor = Robot.motor_center;
                break;
            case FlIPPER:
                motor = Robot.motor_flipper;
                break;
            case RAISER:
                motor = Robot.motor_raiser;
                break;
        }
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setTargetPosition(revolution(revolutions));
        motor.setPower(.5);
    }

    public void loop() {

    }

    public void end() {

        Robot.motor_left.setPower(0);

    }

    public boolean check() {

        if (!Robot.motor_left.isBusy()) {
            return false;
        } else {
            return true;
        }

    }

    public int revolution(double rot) {
        return (int)(rot*1680);
    }

    public int degreesToTicks(int degrees) {

        int ticks = (int)(1120 * degrees / 360d);

        return ticks;

    }

}
