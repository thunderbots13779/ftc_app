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
    private double servoDown = (67.0/180.0);
    private final double LEFT_OPEN_POSITION = (129.0/180.0);
    private final double LEFT_CLOSED_POSITION = (84.0/180.0);
    private final double RIGHT_OPEN_POSITION = (73.0/180.0);
    private final double RIGHT_CLOSED_POSITION = (118.0/180.0);
    double back = 0;
    double turn = 0;

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

    public  void auto(String color, String direction) {
        grab();
        liftUp();
        servo0.setPosition(servoDown);
        timer(1);
        boolean colorCheck = color(color);
        if (direction.equals("back")) {
            driveKnockBack(colorCheck);
        } else {
            driveKnockFront(colorCheck);
        }
    }

    public static void timer(double time) {
        try {
            Thread.sleep((long)(time*1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void driveKnockBack(boolean colorVisible) {
        if (colorVisible) {
            driveTrain.moveAuto("pivotRightFront", .185);
            servoPosUp();
            driveTrain.moveAuto("pivotRightBack", .22);
            back = .77;
            turn = .55;
        } else {
            driveTrain.moveAuto("pivotRightBack", .2);
            servoPosUp();
            driveTrain.moveAuto("pivotLeftBack", .22);
            back = .5;
            turn = .65;
        }
    }

    public void driveKnockFront(boolean colorVisible) {
        if (colorVisible) {
            driveTrain.moveAuto("pivotRightFront", .185);
            servoPosUp();
            driveTrain.moveAuto("pivotLeftFront", .22);
        } else {
            driveTrain.moveAuto("pivotRightBack", .2);
            servoPosUp();
            driveTrain.moveAuto("pivotRightFront", .22);
        }

    }

    public void servoPosUp() {
        timer(1);
        servo0.setPosition(servoUp);
        timer(1);
    }

    public void grab() {
        timer(.5);
        servo2.setPosition(LEFT_CLOSED_POSITION);
        servo1.setPosition(RIGHT_CLOSED_POSITION);
        timer(.5);
    }

    public void ungrab() {
        timer(.5);
        servo2.setPosition(LEFT_OPEN_POSITION);
        servo1 .setPosition(RIGHT_OPEN_POSITION);
        timer(.5);
    }

    public void liftUp() {
        motor2.setPower(1);
        timer(.55);
        motor2.setPower(0);
        timer(.5);
    }

    public void liftDown() {
        motor2.setPower(-1);
        timer(.55);
        motor2.setPower(0);
        timer(.55);
    }

    public void end() {
        ungrab();
        driveTrain.moveAuto("back", .3);
        grab();
        liftDown();
        driveTrain.moveAuto("fwd", .3);
        driveTrain.moveAuto("back", .15);
    }

    /**CASES**/
    public void topRed() {
        driveTrain.moveAuto("back", back);
        driveTrain.moveAuto("left", turn);
        driveTrain.moveAuto("fwd", .45);
        end();
    }

    public void bottomRed() {
        driveTrain.moveAuto("back", .2);
        driveTrain.moveAuto("right", .7);
        driveTrain.moveAuto("back", .2);
        driveTrain.moveAuto("left", .2);
        driveTrain.moveAuto("fwd", .5);
        driveTrain.moveAuto("right", 1.55);
        driveTrain.moveAuto("fwd", .35);
        end();
    }

    public void topBlue() {
        driveTrain.moveAuto("fwd", .7);
        driveTrain.moveAuto("left", 1.1);
        driveTrain.moveAuto("fwd", .45);
        end();
    }

    public void bottomBlue() {
        driveTrain.moveAuto("fwd", .4);
        driveTrain.moveAuto("right", .7);
        driveTrain.moveAuto("fwd", .2);
        driveTrain.moveAuto("left",.6);
        driveTrain.moveAuto("fwd", .35);
        end();
    }
    /*********/

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
        boolean blueVisible;

        if (color.equals("red")) {
            if (maxRed > maxBlue)
                redVisible = true;
            else
                redVisible = false;
            return redVisible;
        } else {
            if (maxRed < maxBlue)
                blueVisible = true;
            else
                blueVisible = false;
            return blueVisible;
        }
    }
}
