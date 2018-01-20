package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by pramo on 1/20/2018.
 */

public class AutoDriveTrain {

    private DcMotor motorLeft, motorRight, motorMiddle;
    private double posOffset = .05;
    private double angleOffset = 1;

    public AutoDriveTrain(DcMotor motor0, DcMotor motor1, DcMotor motor3) {

        this.motorLeft = motor0;
        this.motorRight = motor1;
        this.motorMiddle = motor3;

    }

    public void moveAuto(String direction) {
        if (direction.equals("back")) {
            motorRight.setPower(-.5);
            motorLeft.setPower(.4);
        } else if (direction.equals("fwd")) {
            motorRight.setPower(.5);
            motorLeft.setPower(-.4);
        } else if (direction.equals("right")){
            motorRight.setPower(.5);
            motorLeft.setPower(.4);
        } else if (direction.equals("left")){
            motorRight.setPower(-.5);
            motorLeft.setPower(-.4);
        } else if (direction.equals("strafeLeft")){
            motorMiddle.setPower(-.5);
        } else if (direction.equals("strafeRight")){
            motorMiddle.setPower(.5);
        } else if (direction.equals("pivotLeftBack")){
            motorLeft.setPower(.4);
        } else if (direction.equals("pivotRightBack")){
            motorRight.setPower(-.5);
        } else if (direction.equals("pivotLeftFront")){
            motorLeft.setPower(-.4);
        } else if (direction.equals("pivotRightFront")){
            motorRight.setPower(.5);
        } else {
            motorRight.setPower(0);
            motorLeft.setPower(0);
        }
    }

    public void moveTime(String direction, double time) {
        moveAuto(direction);
        stop(time);
    }

    public void stop(double time) {
        timer(time);
        motorLeft.setPower(0);
        motorRight.setPower(0);
        timer(.2);
    }

    private void timer(double time) {
        try {
            Thread.sleep((long)(time*1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void movePos(float endPos, float currPos, String direction) {
        while (currPos > (endPos+ posOffset) && currPos < (endPos- posOffset)) {
            moveAuto(direction);
        }
        stop(0);
    }

    public void turnAngle(float endAngle, float currentAngle, String direction) {
        while (currentAngle > (endAngle+ posOffset) && currentAngle < (endAngle- posOffset)) {
            moveAuto(direction);
        }
        stop(0);
    }

}
