package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public class AutonomousMovement {

    private DcMotor motorLeft, motorRight, motorMiddle;

    private AutoTimer aTimer;
    private final int MOTOR_0_DIRECTION = 1;
    private final int MOTOR_1_DIRECTION = -1;
    private double x0;
    private double x1;
    private double ssr;
    private double ssl;
    private double powerScale = (1/1.2);
    private int gear = 2;
    public boolean isPressed = false;
    double revAngle = 0;
    double currAngle = revAngle;

    public AutonomousMovement(DcMotor motor0, DcMotor motor1, DcMotor motor3) {

        this.motorLeft = motor0;
        this.motorRight = motor1;
        this.motorMiddle = motor3;

    }

    public void turnAuto(String direction/*, double angle*/) {
//        while (!checkAngle(angle)) {
        if (direction.equals("right")) {
            motorMiddle.setPower(-.5);
            motorRight.setPower(.5);
        } else if (direction.equals("left")) {
            motorMiddle.setPower(-.5);
            motorLeft.setPower(-.4);
        } else {
            motorLeft.setPower(0);
            motorRight.setPower(0);
            motorMiddle.setPower(0);
        }
    }

    public void moveAuto(String direction, long time) {
        aTimer = new AutoTimer(time);
        while (!aTimer.checkTime()) {
            if (direction.equals("back")) {
                motorRight.setPower(-.5);
                motorLeft.setPower(.4);
            } else if (direction.equals("fwd")) {
                motorRight.setPower(.5);
                motorLeft.setPower(-.4);
            } else if (direction.equals("right")) {
                motorRight.setPower(.5);
                motorLeft.setPower(.4);
            } else if (direction.equals("left")) {
                motorRight.setPower(-.5);
                motorLeft.setPower(-.4);
            } else if (direction.equals("strafeLeft")) {
                motorMiddle.setPower(.5);
            } else if (direction.equals("strafeRight")) {
                motorMiddle.setPower(-.5);
            } else {
                motorRight.setPower(0);
                motorLeft.setPower(0);
            }
        }
    }
}
