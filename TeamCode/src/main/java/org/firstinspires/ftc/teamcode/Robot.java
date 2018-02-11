package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;

import java.util.Timer;
import java.util.TimerTask;

public class Robot {

    /** Object Definitions **/

    // Hardware Map
    public static HardwareMap hardwareMap;

    // Gamepad
    public static Gamepad gamepad1;

    // Define the Motors

//    public static DcMotor mo\tor_left;
//    public static DcMotor motor_right;
//    public static DcMotor motor_center;
      public static DcMotor motor_leftIntake;
      public static DcMotor motor_rightIntake;

    // Define the Servos

    public static Servo servo_swivel;
    public static Servo servo_dropper;
    public static Servo servo_leftGrabber;
    public static Servo servo_rightGrabber;

    // Define the Gyroscope

    public static BNO055IMU imu;

    // Define the Color Sensor

    public static NormalizedColorSensor colorSensor;

    // Define the Timers

    public static Timer timer;
    public static TimerTask task;

    // Define State Variables

    public static Orientation angles;

    /** Constants **/

    //Servo Constants
    public static final double servoUp = (174.0/180.0);
    public static final double servoDown = (67.0/180.0);

    public static final double OPEN_POSITION_LEFT = (129.0/180.0);
    public static final double OPEN_POSITION_RIGHT = (73.0/180.0);

    public static final double CLOSED_POSITION_LEFT = (84.0/180.0);
    public static final double CLOSED_POSITION_RIGHT = (118.0/180.0);

    public static final double WHEEL_DIAMETER = 0;
    public static final double WHEEL_Circumference = 2 * Math.PI * WHEEL_DIAMETER / 2;

    /** Auto Action Variables **/

    /** Action Variables **/
    public static double leftTrigger;
    public static double rightTrigger;
    public static boolean backButtonPressed = false;
    public static boolean open = true;
    public static double powerScaleFactor = 1.0/1.2;

    /** Methods **/
    public static double powerScale(double scale) {
        return powerScaleFactor*Math.pow(scale, 2);
    }

    public static void initialize() {


        // Finding the Motors from the Configuration

//        motor_left = map.hardwareMap.get(DcMotor.class, "motor_left");
//        motor_right = map.hardwareMap.get(DcMotor.class, "motor_right");
//        motor_center = map.hardwareMap.get(DcMotor.class, "motor_center");
          motor_leftIntake = hardwareMap.get(DcMotor.class, "motor_leftIntake");
          motor_rightIntake = hardwareMap.get(DcMotor.class, "motor_rightIntake");\
//
//        // Finding the Servos from the Configuration
//
//        servo_swivel = map.hardwareMap.get(Servo.class, "servo_swivel");
//        servo_dropper = map.hardwareMap.get(Servo.class, "servo_dropper");
//        servo_leftGrabber = hardwareMap.get(Servo.class, "servo_leftGrabber");
//        servo_rightGrabber = hardwareMap.get(Servo.class, "servo_rightGrabber");

        // Finding the Gyroscope

//        imu = map.hardwareMap.get(BNO055IMU.class, "imu");

        // Finding the Color Sensor

//        colorSensor = map.hardwareMap.get(NormalizedColorSensor.class, "colorSensor");

        // Initialize the Gyrosensor

//        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
//        parameters.angleUnit           = BNO055IMU.AngleUnit.DEGREES;
//        parameters.accelUnit           = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
//        parameters.calibrationDataFile = "BNO055IMUCalibration.json"; // see the calibration sample opmode
//        parameters.loggingEnabled      = true;
//        parameters.loggingTag          = "IMU";
//        parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();
//
//        imu.initialize(parameters);
//
//        imu.startAccelerationIntegration(new Position(), new Velocity(), 1000);

        // Setting Motor Behavior
//
//        motor_left.setZeroPowerBehavior((DcMotor.ZeroPowerBehavior.BRAKE));
//        motor_right.setZeroPowerBehavior((DcMotor.ZeroPowerBehavior.BRAKE));
//        motor_center.setZeroPowerBehavior((DcMotor.ZeroPowerBehavior.BRAKE));

    }

//    public static void startUpdates() {
//        timer = new Timer();
//        task = new TimerTask() {
//            @Override
//            public void run() {
//                angles   = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
//            }
//        };
//        timer.scheduleAtFixedRate(task, 0, 1);
//    }
//
//    public void resetMotors() {
//        motor_left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        motor_right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        motor_center.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//    }

}
