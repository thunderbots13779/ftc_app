package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public class TankDriveTrain {

    private DcMotor motorLeft, motorRight, motorStrafe;

    private final int MOTOR_0_DIRECTION = 1;
    private final int MOTOR_1_DIRECTION = -1;
    private double x0;
    private double x1;
    private double x2;
    private double powerScale = (1/1.1);
    private int gear = 1;
    public boolean isPressed = false;

    public TankDriveTrain(DcMotor motor0, DcMotor motor1/*, DcMotor motor3*/) {

        this.motorLeft = motor0;
        this.motorRight = motor1;

    }

    public void gearSwitch(int gear)
    {

        switch(gear) {
            case 1:
                powerScale = (0.5);
                break;
            case 2:
                powerScale = (1/1.1);
                break;
            case 3:
                powerScale = (1);
                break;
            default:
                powerScale = (1/1.1);
                break;
        }
    }

    public void dpad(boolean up, boolean down)
    {
        if (up && gear < 3 && !isPressed) {

            gear++;
            isPressed = true;

        } else if (down && gear > 1 && !isPressed) {

            gear--;
            isPressed = true;

        }

        if (!up && !down) {
            isPressed = false;
        }

        gearSwitch(gear);
    }

    public void move(double motor0Power, double motor1Power) {
        x0 = powerScale*(Math.pow(motor0Power, 2));
        x1 = powerScale*(Math.pow(motor1Power, 2));
        if (motor0Power >= 0) {
            motorLeft.setPower(MOTOR_0_DIRECTION * x0);
        } else if (motor0Power < 0) {
            motorLeft.setPower(MOTOR_0_DIRECTION * -x0);
        }
        if (motor1Power >= 0) {
            motorRight.setPower(MOTOR_1_DIRECTION * x1);
        } else if (motor1Power < 0) {
            motorRight.setPower(MOTOR_1_DIRECTION * -x1);
        }
    }

    public void moveAuto(String direction, double time) {
        if (direction.equals("back")) {
            motorRight.setPower(-.5);
            motorLeft.setPower(.4);
            stop(time);
        } else if (direction.equals("fwd")) {
            motorRight.setPower(.5);
            motorLeft.setPower(-.4);
            stop(time);
        } else if (direction.equals("right")){
            motorRight.setPower(.5);
            motorLeft.setPower(.4);
            stop(time);
        } else if (direction.equals("left")){
            motorRight.setPower(-.5);
            motorLeft.setPower(-.4);
            stop(time);
        } else if (direction.equals("pivotLeft")){
            motorLeft.setPower(.4);
            stop(time);
        } else if (direction.equals("pivotRight")){
            motorRight.setPower(-.5);
            stop(time);
        } else {
            motorRight.setPower(0);
            motorLeft.setPower(0);
        }
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

    //STRAFE
//    public void strafe(double motor3Power) {
//        x2 = powerScale*(Math.pow(motor3Power, 2));
//        if (motor3Power >= 0) {
//            motorLeft.setPower(MOTOR_0_DIRECTION * x0);
//        } else if (motor3Power < 0) {
//            motorLeft.setPower(MOTOR_0_DIRECTION * -x0);
//        }
//    }

    public double getPowerScale() { return powerScale; }
    public double getGear() { return gear; }

}
