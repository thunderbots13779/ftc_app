package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public class  RunToPosition implements Action {

    public int degrees;

    public DcMotor motor;

    public RunToPosition(int degrees, DcMotor motor) {

        this.degrees = degrees;
        this.motor = motor;

    }
//TODO: hi
    public void start() {

        Robot.motor_left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Robot.motor_left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        Robot.motor_left.setPower(.5);
        Robot.motor_left.setTargetPosition(revolution(degrees));

    }

    public void loop() {
//        if (motor.getCurrentPosition() < revolution(degrees)) {
//            motor.setPower(.1);
//        }
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

    public int revolution(int rot) {
        return rot*1680;
    }

    public int degreesToTicks(int degrees) {

        int ticks = (int)(1120 * degrees / 360d);

        return ticks;

    }

}
