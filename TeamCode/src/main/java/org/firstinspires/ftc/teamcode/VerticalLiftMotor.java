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

    public void Lift(double Left, double Right, boolean lb) {
        x0 = (0.5) * (Math.pow(Left, 2));
        x1 = (1 / 1.3) * (Math.pow(Right, 2));
            if (Left != 0) {
                liftMotor.setPower(-x0);
            } else if (Right != 0) {
                liftMotor.setPower(x1);
            } else if (Left == 0 || Right == 0) {
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
