package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class AutonomousMovement{

    private DcMotor motor0, motor1, motor2, motor3;
    private Servo leftGrabber, rightGrabber, servo3;
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

    public AutonomousMovement(DcMotor motor0, DcMotor motor1, DcMotor motor2, DcMotor motor3, Servo servo1, Servo servo2, Servo servo3) {

        this.motor0 = motor0;
        this.motor1 = motor1;
        this.motor2 = motor3;
        this.motor3 = motor2;
        this.leftGrabber = servo1;
        this.rightGrabber = servo2;
        this.servo3 = servo3;

        this.motor0.setZeroPowerBehavior((DcMotor.ZeroPowerBehavior.BRAKE));
        this.motor1.setZeroPowerBehavior((DcMotor.ZeroPowerBehavior.BRAKE));

    }



}
