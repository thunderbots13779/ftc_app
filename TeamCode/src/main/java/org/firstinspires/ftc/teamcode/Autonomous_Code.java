package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;

import java.util.Timer;
import java.util.TimerTask;

@Autonomous
public class Autonomous_Code extends LinearOpMode{

    BNO055IMU imu;

    public Orientation angles;
    public Acceleration gravity;

    public double angle;

    private DcMotor motorLeft, motorRight, motorMiddle;
    private int motorLeftDirection = 1;
    private int motorRightDirection = -1;

    public Timer timer;
    public TimerTask task;

    /** INITS **/
    private DcMotor motor0;
    private DcMotor motor1;
    private DcMotor motor2;
    private DcMotor motor3;
    private Servo servo0;
    private Servo servo1;
    private Servo servo2;
    private Servo servo3;
    private NormalizedColorSensor colorSensor;
    private TankDriveTrain driveTrain;
    private Grabber grabber;
    private VerticalLiftMotor liftMotor;
    private VuMarkIdentification vuMarkIdentification;
//    private Timer timer;
//    private TimerTask task;

    /** VARS **/
    private double servoUp = (174.0/180.0);
    private double servoDown = (67.0/180.0);
    private final double LEFT_OPEN_POSITION = (129.0/180.0);
    private final double LEFT_CLOSED_POSITION = (84.0/180.0);
    private final double RIGHT_OPEN_POSITION = (73.0/180.0);
    private final double RIGHT_CLOSED_POSITION = (118.0/180.0);

    double back = 0;
    double turn = 0;
    long columnTime = 350;
    double columnShift = .2;
    String strafeDirection = "";
    double period;
    double timePassed;
    int column = 3;
    float angleOffset = 1;
    float currAngle;

    /** TIME VARIABLES **/
    long knockTime = 150;

    /** CONSTRUCTOR **/
    public Autonomous_Code () {
    }

    /** OP MODE **/
    @Override
    public void runOpMode() {

    }

    /** MAPS **/
    public void initialization() {
        //HARDWARE MAPS
        motor0 = hardwareMap.get(DcMotor.class, "motor0");
        motor1 = hardwareMap.get(DcMotor.class, "motor1");
        motor3 = hardwareMap.get(DcMotor.class, "motor2");
        motor2 = hardwareMap.get(DcMotor.class, "motor3");
        servo0 = hardwareMap.get(Servo.class, "servo0");
        servo1 = hardwareMap.get(Servo.class, "servo1");
        servo2 = hardwareMap.get(Servo.class, "servo2");
        servo3 = hardwareMap.get(Servo.class, "servo3");
        colorSensor = hardwareMap.get(NormalizedColorSensor.class, "colorSensor");

        //INITIALIZATION
        driveTrain = new TankDriveTrain(motor0, motor1, motor3);
        grabber = new Grabber(servo1, servo2);
        liftMotor = new VerticalLiftMotor(motor2);
        vuMarkIdentification = new VuMarkIdentification(hardwareMap, telemetry);

        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit           = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit           = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.calibrationDataFile = "BNO055IMUCalibration.json"; // see the calibration sample opmode
        parameters.loggingEnabled      = true;
        parameters.loggingTag          = "IMU";
        parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();

        imu = hardwareMap.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);

        imu.startAccelerationIntegration(new Position(), new Velocity(), 1000);

        motor0.setZeroPowerBehavior((DcMotor.ZeroPowerBehavior.BRAKE));
        motor1.setZeroPowerBehavior((DcMotor.ZeroPowerBehavior.BRAKE));

        startUpdates();
    }

    /** SEQUENCES **/
    public void startSequence() {
        pickColumn();
        grab();
        liftUp();
        servo0.setPosition(servoDown);
        pause(1000);
    }

    public void auto(String color) {
        startSequence();
        boolean colorCheck = color(color);
        knockBall(colorCheck);
        align(color);
    }

    public void end() {
//        columnShift();
        move("fwd", 450);
        ungrab();
        move("back", 450);
        grab();
        liftDown();
        move("fwd", 500);
        move("back", 150);
        stopUpdates();
    }

    public void align(String direction) {
        long first = 1000;
        long alignT = 1500;
        long backout = 450;
        if(direction.equals("red")) {
            move("back", first);
            pause(1000);
            turnAbsolute(0);
//            moveAuto.move("fwd", alignT);
//            moveAuto.move("back", backout);
        } else {
            move("front", first);
            pause(1000);
            turnAbsolute(0);
//            moveAuto.move("fwd", alignT);
//            moveAuto.move("back", backout);
        }
    }

    /** CASES **/
    public void redTop() {
        move("back", 1000);
        turnAbsolute(90);
        end();
    }

    public void blueBottom() {
        move("left", 1000);
        turnAbsolute(0);
        pause(1000);
        move("fwd", 250);
        move("left", columnTime);
//        if (column == 1) {
//            moveAuto.move("right", columnTime + 100);
//        } else if (column == 2) {
//            moveAuto.move("right", columnTime + 200);
//        }
        turnAbsolute(0);
        end();
    }

    public void blueTop() {
        move("fwd", 1000);
        turnAbsolute(90);
        end();
    }

    public void redBottom() {
        move("right", 1000);
//        moveAuto.turn("right", 1850);
//        pause(100);
        turnAbsolute(180);
        pause(1000);
        move("fwd", 250);
        move("right", columnTime);
//        if (column == 1) {
//            moveAuto.move("right", columnTime + 100);
//        } else if (column == 2) {
//            moveAuto.move("right", columnTime + 200);
//        }
        turnAbsolute(180);
        end();
    }

    /** KNOCK **/
    private void knockBall(boolean colorVisible) {
        if (colorVisible) {
            knockRight();
            servoPosUp();
        } else {
            knockLeft();
            servoPosUp();
        }
    }

    private void knockRight() {
        dropdown("right", knockTime);

    }

    private void knockLeft() {
        dropdown("left", knockTime);


    }

    public boolean color(String color) {
        int scale = 100;
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
            pause(100);
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

    /** SERVOS AND MOTORS **/
    public void servoPosUp() {
        pause(1000);
        servo0.setPosition(servoUp);
        pause(1000);
    }

    public void grab() {
        pause(500);
        servo2.setPosition(LEFT_CLOSED_POSITION);
        servo1.setPosition(RIGHT_CLOSED_POSITION);
        pause(1000);
    }

    public void ungrab() {
        pause(500);
        servo2.setPosition(LEFT_OPEN_POSITION);
        servo1 .setPosition(RIGHT_OPEN_POSITION);
        pause(1000);
    }

    public void liftUp() {
        lift("up", 800);
        pause(1000);
    }

    public void liftDown() {
        lift("down", 750);
        pause(450);
    }

    /** COLUMN **/
    public void pickColumn() {
        long duration = 3000;
        long endTime = System.currentTimeMillis() + duration;
        while (column == 3 && !checkTime(endTime) && opModeIsActive()) {
            column= vuMarkIdentification.identify();
            telemetry.addData("column: ", column);
            telemetry.update();
        }
        if (column == 3) {
            column = 1;
        }
    }

    public void columnShift() {
        if (column == 0) {
            strafeDirection = "left";
            columnTime -= columnShift;
        } else if (column == 2) {
            strafeDirection = "right";
            columnTime += columnShift;
        }
    }

    /** TIMER **/ //NEEDS MODDING
    private void pause(long time) {

        long endTime = System.currentTimeMillis() + time;
        while(!checkTime(endTime) && opModeIsActive()) {

        }
    }

    /** MOVEMENT **/

    public void move(String direction, long time) {
        long endTime = System.currentTimeMillis() + time;
        while (!checkTime(endTime) && opModeIsActive()) {
            if (direction.equals("back")) {
                motor1.setPower(-.5);
                motor0.setPower(.4);
            } else if (direction.equals("fwd")) {
                motor1.setPower(.5);
                motor0.setPower(-.4);
            } else if (direction.equals("right")) {
                motor2.setPower(-1);
            } else if (direction.equals("left")) {
                motor2.setPower(1);
            } else {
                motor1.setPower(0);
                motor0.setPower(0);
                motor2.setPower(0);
            }
        }
        motor1.setPower(0);
        motor0.setPower(0);
        motor2.setPower(0);
        pause();
    }

    public void turn(String direction, long time) {
        long endTime = System.currentTimeMillis() + time;
        while (!checkTime(endTime) && opModeIsActive()) {
            if (direction.equals("left")) {
                motor0.setPower(-.4);
                motor1.setPower(-.5);
            } else if (direction.equals("right")) {
                motor1.setPower(.5);
                motor0.setPower(.4);
            } else {
                motor1.setPower(0);
                motor0.setPower(0);
            }
        }
        motor1.setPower(0);
        motor0.setPower(0);
        pause();
    }

    public void lift(String direction, long time) {
        long endTime = System.currentTimeMillis() + time;
        while (!checkTime(endTime) && opModeIsActive()) {
            if (direction.equals("up")) {
                motor3.setPower(.5);
            } else if (direction.equals("down")) {
                motor3.setPower(-.5);
            } else {
                motor3.setPower(0);
            }
        }
        motor3.setPower(0);
        pause();
    }

    public void dropdown(String direction, long time) {
        long endTime = System.currentTimeMillis() + time;
        while (!checkTime(endTime) && opModeIsActive()) {
            if (direction.equals("right")) {
                servo3.setPosition(-1);
            } else if (direction.equals("left")) {
                servo3.setPosition(1);
            } else {
                servo3.setPosition(.5);
            }
        }
        servo3.setPosition(.5);
        pause();
    }

    private void pause() {
        long endTime = System.currentTimeMillis() + 750;
        while(!checkTime(endTime) && opModeIsActive()) {

        }
    }

    public void turnAbsolute(float angle) {

        float marginOfError = 12;

        float right = angle - marginOfError;
        float left = angle + marginOfError;

        while (angles == null && opModeIsActive()) {

        }

        float multiplier = angle / Math.abs(angle);

        while (!(angles.firstAngle < left && angles.firstAngle > right) && opModeIsActive()) {
            motor0.setPower(-0.35f * multiplier);
            motor1.setPower(-0.35f * multiplier);
        }

        motor0.setPower(0);
        motor1.setPower(0);
    }

    public void startUpdates() {
        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                angles   = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1);
    }

    public void stopUpdates() {
        timer.cancel();
    }

    public boolean checkTime(long endTime) {
        long currentTime = System.currentTimeMillis();
        if (currentTime > endTime) {
            return true;
        }
        return false;
    }

}
