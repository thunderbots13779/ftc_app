package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class AutonomousMovement {

    private DcMotor motorLeft, motorRight, motorMiddle, motorLift;
    private Servo leftGrabber, rightGrabber, colorKnocker;
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

    public AutonomousMovement(DcMotor motor0, DcMotor motor1, DcMotor motor2, DcMotor motor3, Servo servo1, Servo servo2, Servo servo3) {

        this.motorLeft = motor0;
        this.motorRight = motor1;
        this.motorMiddle = motor3;
        this.motorLift = motor2;
        this.leftGrabber = servo1;
        this.rightGrabber = servo2;
        this.colorKnocker = servo3;

        motorLeft.setZeroPowerBehavior((DcMotor.ZeroPowerBehavior.BRAKE));
        motorRight.setZeroPowerBehavior((DcMotor.ZeroPowerBehavior.BRAKE));

    }

    public void move(String direction, long time) {
        aTimer = new AutoTimer(time);
        while (!aTimer.checkTime()) {
            if (direction.equals("back")) {
                motorRight.setPower(-.5);
                motorLeft.setPower(.4);
            } else if (direction.equals("fwd")) {
                motorRight.setPower(.5);
                motorLeft.setPower(-.4);
            } else if (direction.equals("right")) {
                motorMiddle.setPower(-1);
            } else if (direction.equals("left")) {
                motorMiddle.setPower(1);
            } else {
                motorRight.setPower(0);
                motorLeft.setPower(0);
                motorMiddle.setPower(0);
            }
        }
        motorRight.setPower(0);
        motorLeft.setPower(0);
        motorMiddle.setPower(0);
        pause();
    }

    public void turn(String direction, long time) {
        aTimer = new AutoTimer(time);
        while (!aTimer.checkTime()) {
            if (direction.equals("left")) {
                motorLeft.setPower(-.4);
                motorRight.setPower(-.5);
            } else if (direction.equals("right")) {
                motorRight.setPower(.5);
                motorLeft.setPower(.4);
            } else {
                motorRight.setPower(0);
                motorLeft.setPower(0);
            }
        }
        motorRight.setPower(0);
        motorLeft.setPower(0);
        pause();
    }

    public void lift(String direction, long time) {
        aTimer = new AutoTimer(time);
        while (!aTimer.checkTime()) {
            if (direction.equals("up")) {
                motorLift.setPower(.5);
            } else if (direction.equals("down")) {
                motorLift.setPower(-.5);
            } else {
                motorLift.setPower(0);
            }
        }
        motorLift.setPower(0);
        pause();
    }

    public void dropdown(String direction, long time) {
        aTimer = new AutoTimer(time);
        while (!aTimer.checkTime()) {
            if (direction.equals("right")) {
                colorKnocker.setPosition(-1);
            } else if (direction.equals("left")) {
                colorKnocker.setPosition(1);
            } else {
                colorKnocker.setPosition(.5);
            }
        }
        colorKnocker.setPosition(.5);
        pause();
    }

    private void pause() {
        aTimer = new AutoTimer(750);
        while(!aTimer.checkTime()) {

        }
    }

}
