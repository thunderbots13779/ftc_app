package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcontroller.external.samples.BasicOpMode_Iterative;

import java.util.Timer;
import java.util.TimerTask;

@Autonomous
public class Autonomous_Code extends BasicOpMode_Iterative{

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
    private Timer timer;
    private TimerTask task;

    /** VARS **/
    private double servoUp = (174.0/180.0);
    private double servoDown = (67.0/180.0);
    private final double LEFT_OPEN_POSITION = (129.0/180.0);
    private final double LEFT_CLOSED_POSITION = (84.0/180.0);
    private final double RIGHT_OPEN_POSITION = (73.0/180.0);
    private final double RIGHT_CLOSED_POSITION = (118.0/180.0);
    double back = 0;
    double turn = 0;
    double columnTime = 0;
    double columnShift = .2;
    String strafeDirection;
    double period;
    double timePassed;
    int column = 3;

    /** CONSTRUCTOR **/
    public Autonomous_Code () {
        this.motor0 = motor0;
        this.motor1 = motor1;
        this.motor2 = motor2;
        this.motor3 = motor3;
        this.servo0 = servo0;
        this.servo1 = servo1;
        this.servo2 = servo2;
        this.servo3 = servo3;
        this.colorSensor = colorSensor;
        this.driveTrain = driveTrain;
        this.grabber = grabber;
        this.liftMotor = liftMotor;
        this.vuMarkIdentification = vuMarkIdentification;
    }

    /** OP MODE **/

    @Override
    public void start() {

        timer.scheduleAtFixedRate(task, 0, (long) period);

    }

    @Override
    public void loop() {

        telemetry.addData("Seconds Passes", timePassed / period);
        telemetry.update();

    }

    @Override
    public void stop() {

        timer.cancel();

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
    }

    /** SEQUENCES **/
    public void startSequence() {
        pickColumn();
        grab();
        liftUp();
        servo0.setPosition(servoDown);
        timer(1);
    }

    public  void auto(String color) {
        startSequence();
        boolean colorCheck = color(color);
        knockBall(colorCheck);
    }

    public void end() {
        columnShift();
        driveTrain.moveAuto(strafeDirection, columnTime);
        ungrab();
        driveTrain.moveAuto("fwd", .45);
        driveTrain.moveAuto("back", .3);
        grab();
        liftDown();
        driveTrain.moveAuto("fwd", .4);
        driveTrain.moveAuto("back", .15);
    }

    public void align() {
        driveTrain.moveAuto("back", back);
        driveTrain.moveAuto("fwd", back/2);
    }

    /** CASES **/
    public void redTop() {
        driveTrain.moveAuto("back", back);
        driveTrain.moveAuto("left", turn);
        driveTrain.moveAuto("fwd", .45);
        end();
    }

    public void redBottom() {
        driveTrain.moveAuto("back", .8);
        driveTrain.moveAuto("right", 1.5);
        driveTrain.moveAuto("strafeLeft", .5);
        driveTrain.moveAuto("pivotLeftBack", .3);
        end();
    }

    public void blueTop() {
        driveTrain.moveAuto("fwd", .7);
        driveTrain.moveAuto("left", 1.1);
        driveTrain.moveAuto("fwd", .45);
        end();
    }

    public void blueBottom() {
        driveTrain.moveAuto("fwd", .4);
        driveTrain.moveAuto("right", .7);
        driveTrain.moveAuto("fwd", .2);
        driveTrain.moveAuto("fwd", .35);
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
        servo3.setPosition(-1);
        timer(.3);
        servo3.setPosition(1);
        timer(.3);
        servo3.setPosition(.5);
    }

    private void knockLeft() {
        servo3.setPosition(1);
        timer(.3);
        servo3.setPosition(-1);
        timer(.3);
        servo3.setPosition(.5);
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

    /** SERVOS AND MOTORS **/
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
        timer(.35);
        motor2.setPower(0);
        timer(.5);
    }

    public void liftDown() {
        motor2.setPower(-1);
        timer(.2);
        motor2.setPower(0);
        timer(.45);
    }

    /** CORRECTION **/
    public void turn()

    /** COLUMN **/
    public void pickColumn() {
        while (column == 3) {
            column= vuMarkIdentification.identify();
            telemetry.addData("column: ", column);
            telemetry.update();
        }
    }

    public void columnShift() {
        if (column == 0) {
            strafeDirection = "strafeLeft";
            columnTime -= columnShift;
        } else if (column == 2) {
            strafeDirection = "strafeRight";
            columnTime += columnShift;
        }
    }

    /** TIMER **/ //NEEDS MODDING
    public void timer(final double time) {
        timePassed = 0;
        period = 1000;

        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                timePassed += period;
                if ((timePassed / period) <= time) {
                    timer.cancel();
                }
            }
        };
    }

}
