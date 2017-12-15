package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
import com.qualcomm.robotcore.hardware.Servo;

public class Autonomous_Code {

    private DcMotor motor0;
    private DcMotor motor1;
    private DcMotor motor2;
    private DcMotor motor3;
    private Servo servo0;
    private Servo servo1;
    private Servo servo2;
    private NormalizedColorSensor colorSensor;
    private TankDriveTrain driveTrain;
    private Grabber grabber;
    private VerticalLiftMotor liftMotor;
    private double servoUp = (174.0/180.0);
    private double servoDown = (77.0/180.0);

    public Autonomous_Code (DcMotor motor_0, DcMotor motor_1, DcMotor motor_2, DcMotor motor_3,
                       Servo servo_0, Servo servo_1, Servo servo_2, NormalizedColorSensor color_sensor,
                       TankDriveTrain drive_Train, Grabber grabber_, VerticalLiftMotor lift_Motor) {
        this.motor0 = motor_0;
        this.motor1 = motor_1;
        this.motor2 = motor_2;
        this.motor3 = motor_3;
        this.servo0 = servo_0;
        this.servo1 = servo_1;
        this.servo2 = servo_2;
        this.colorSensor = color_sensor;
        this.driveTrain = drive_Train;
        this.grabber = grabber_;
        this.liftMotor = lift_Motor;
    }

    public  void auto(String color) {
        grabber.Grab(true);
        timer(1);
        grabber.Grab(true);
        servo0.setPosition(servoDown);
        timer(1);
        boolean redVisible = color(color);
        if (redVisible) {
            driveGoFront();
        } else {
            driveGoBack();
        }
        timer(1);
        servo0.setPosition(servoUp);
        timer(1);

    }

    public static void timer(double time) {
        try {
            Thread.sleep((long)(time*1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void driveGoFront() {
           driveTrain.moveAuto("fwd");
           timer(.1);
           driveTrain.moveAuto("back");
           timer(.12);
           driveTrain.moveAuto("stop");
    }

    public void driveGoBack() {
        driveTrain.moveAuto("back");
        timer(.1);
        driveTrain.moveAuto("fwd");
        timer(.1);
        driveTrain.moveAuto("stop");
    }

    public boolean color(String color) {
        int scale = 10000;
        double maxRed = 0;
        double maxBlue = 0;

        for (int i = 0; i < 10; i++) {
            NormalizedRGBA colors = colorSensor.getNormalizedColors();

            double red = scale * colors.red;
            double blue = scale * colors.blue;
            if (red > maxRed)
                maxRed = red;
            if (blue > maxBlue)
                maxBlue = blue;
            timer(.1);
        }

        boolean redVisible;

        if (color.equals("red")) {
            if (maxRed > maxBlue)
                redVisible = true;
            else
                redVisible = false;
        } else {
            if (maxRed < maxBlue)
                redVisible = false;
            else
                redVisible = true;
        }

        return redVisible;
    }
}
