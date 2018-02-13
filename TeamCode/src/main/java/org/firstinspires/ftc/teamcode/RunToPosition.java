package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public class RunToPosition implements Action {

    public int degrees;

    public DcMotor motor;

    public RunToPosition(int degrees, DcMotor motor) {

        this.degrees = degrees;
        this.motor = motor;

    }

    public void start() {

        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        motor.setPower(.5);
//        motor.setTargetPosition(revolution(degrees));

    }

    public void loop() {
        if (motor.getCurrentPosition() < revolution(degrees)) {
            motor.setPower(.1);
        }
    }

    public void end() {

        motor.setPower(0);

    }

    public boolean check() {

        if (!motor.isBusy()) {
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
