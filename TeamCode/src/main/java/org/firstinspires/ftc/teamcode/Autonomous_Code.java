package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous
public class Autonomous_Code extends LinearOpMode{

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
    private AutonomousMovement moveAuto;
    private AutoTimer aTimer;
    public DriveTrain turnAngle;
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
        motor2 = hardwareMap.get(DcMotor.class, "motor2");
        motor3 = hardwareMap.get(DcMotor.class, "motor3");
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
        turnAngle = new DriveTrain(motor0, motor1, motor3, hardwareMap);
        moveAuto = new AutonomousMovement(motor0, motor1, motor2, motor3, servo1, servo2, servo3);
        motor0.setZeroPowerBehavior((DcMotor.ZeroPowerBehavior.BRAKE));
        motor1.setZeroPowerBehavior((DcMotor.ZeroPowerBehavior.BRAKE));
        turnAngle.startUpdates();
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
        moveAuto.move("fwd", 450);
        ungrab();
        moveAuto.move("back", 450);
        grab();
        liftDown();
        moveAuto.move("fwd", 500);
        moveAuto.move("back", 150);
        turnAngle.stopUpdates();
    }

    public void align(String direction) {
        long first = 1000;
        long alignT = 1500;
        long backout = 450;
        if(direction.equals("red")) {
            moveAuto.move("back", first);
            pause(1000);
            turnAngle.turnAbsolute(0);
//            moveAuto.move("fwd", alignT);
//            moveAuto.move("back", backout);
        } else {
            moveAuto.move("front", first);
            pause(1000);
            turnAngle.turnAbsolute(0);
//            moveAuto.move("fwd", alignT);
//            moveAuto.move("back", backout);
        }
    }

    /** CASES **/
    public void redTop() {
        moveAuto.move("back", 500);
        turnAngle.turnAbsolute(90);
        moveAuto.move("fwd", 450);
        end();
    }

    public void blueBottom() {
        moveAuto.move("left", 1000);
        turnAngle.turnAbsolute(0);
        pause(1000);
        moveAuto.move("fwd", 250);
        moveAuto.move("left", columnTime);
//        if (column == 1) {
//            moveAuto.move("right", columnTime + 100);
//        } else if (column == 2) {
//            moveAuto.move("right", columnTime + 200);
//        }
        turnAngle.turnAbsolute(0);
        end();
    }

    public void blueTop() {
        moveAuto.move("fwd", 1000);
        turnAngle.turnAbsolute(-90);
        end();
    }

    public void redBottom() {
        moveAuto.move("right", 1000);
//        moveAuto.turn("right", 1850);
//        pause(100);
        turnAngle.turnAbsolute(180);
        pause(1000);
        moveAuto.move("fwd", 250);
        moveAuto.move("right", columnTime);
//        if (column == 1) {
//            moveAuto.move("right", columnTime + 100);
//        } else if (column == 2) {
//            moveAuto.move("right", columnTime + 200);
//        }
        turnAngle.turnAbsolute(180);
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
        moveAuto.dropdown("right", knockTime);

    }

    private void knockLeft() {
        moveAuto.dropdown("left", knockTime);


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
        moveAuto.lift("up", 800);
        pause(1000);
    }

    public void liftDown() {
        moveAuto.lift("down", 750);
        pause(450);
    }

    /** COLUMN **/
    public void pickColumn() {
        aTimer = new AutoTimer(3000);
        while (column == 3 && !aTimer.checkTime()) {
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
        aTimer = new AutoTimer(time);
        while(!aTimer.checkTime()) {

        }
    }

//    public void timer(final double time) {
//        timePassed = 0;
//        period = 1000;
//
//        timer = new Timer();
//        task = new TimerTask() {
//            @Override
//            public void run() {
//                timePassed += period;
//                if ((timePassed / period) <= time) {
//                    timer.cancel();
//                }
//            }
//        };
//    }

}
