package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by pramo on 11/15/2017.
 */

public class VerticalLiftMotor {

    private DcMotor liftMotor;
    private double x0;
    private double x1;

    public VerticalLiftMotor(DcMotor motor) {

        this.liftMotor = motor;

    }

    public void Lift(double Left, double Right) {

//        if (gp1LeftBumper|| gp2LeftBumper) {
//            liftMotor.setPower(1.0);
//        } else if (gp1Trigger != 0 || gp2Trigger != 0) {
//            liftMotor.setPower(-1.0);
//        } else {
//            liftMotor.setPower(0.0);
//        }

        x0 = (1/1.3)*(Math.pow(Left, 2));
        x1 = (1/1.3)*(Math.pow(Right, 2));
        if (Left != 0) {
            liftMotor.setPower(-x0);
        } else if (Right != 0) {
            liftMotor.setPower(x1);
        } else if (Left == 0 || Right == 0){
            liftMotor.setPower(0);
        }
    }

}
