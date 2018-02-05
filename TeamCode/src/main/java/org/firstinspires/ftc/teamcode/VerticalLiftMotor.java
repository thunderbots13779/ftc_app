package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by pramo on 11/15/2017.
 */

public class VerticalLiftMotor {

    private DcMotor liftMotor;
   // private DcMotor liftMotor1;
    private double x0;
    private double x1;

    public VerticalLiftMotor(DcMotor motor/*, DcMotor motor1*/) {

        this.liftMotor = motor;
    }

    public void Lift(boolean Left, boolean Right) {
            if (Left) {
                liftMotor.setPower(-1);
            } else if (Right) {
                liftMotor.setPower(1);
            } else {
                liftMotor.setPower(0);
            }
    }

    public void autoLift(double power, double time) {
        liftMotor.setPower(power);
        try {
            Thread.sleep((long)(time*1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        liftMotor.setPower(0);
    }

}
