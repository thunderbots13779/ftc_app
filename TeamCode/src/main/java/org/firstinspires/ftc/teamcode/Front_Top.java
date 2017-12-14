package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous
public class Front_Top extends LinearOpMode {

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

    @Override
    public void runOpMode() {

        initialization();

        //Wait for the game to start (driver presses PLAY)
        waitForStart();

        //run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            boolean redVisible = color();
            telemetry(redVisible);
            grabber.Grab(true);
//            liftMotor.autoLift(.5, .2);
            servo0.setPosition(77.0/180.0);
            timer(1);
            if (redVisible) {
                driveTapnGo();
            } else {
                driveGo();
            }
            timer(1);
            servo0.setPosition(174.0/180.0);
            stop();
        }
    }

    private void initialization() {
        //HARDWARE MAPS
        motor0 = hardwareMap.get(DcMotor.class, "motor0");
        motor1 = hardwareMap.get(DcMotor.class, "motor1");
        motor2 = hardwareMap.get(DcMotor.class, "motor2");
        // motor3 = hardwareMap.get(DcMotor.class, "motor3");
        servo0 = hardwareMap.get(Servo.class, "servo0");
        servo1 = hardwareMap.get(Servo.class, "servo1");
        servo2 = hardwareMap.get(Servo.class, "servo2");
        colorSensor = hardwareMap.get(NormalizedColorSensor.class, "colorSensor");

        //INITIALIZATION
        driveTrain = new TankDriveTrain(motor0, motor1);
        grabber = new Grabber(servo1, servo2);
        liftMotor = new VerticalLiftMotor(motor2);

        //sends tests data to dc phone
        telemetry.addData("Status", "Initialized");
        telemetry.update();
    }

    private void lift() {
        if (gamepad1.left_trigger != 0|| gamepad1.right_trigger != 0) {
            liftMotor.Lift(this.gamepad1.left_trigger, this.gamepad1.right_trigger, this.gamepad1.left_bumper);
        } else {
            liftMotor.Lift(this.gamepad2.left_trigger, this.gamepad2.right_trigger, this.gamepad2.left_bumper);
        }
    }

    private void timer(double time) {
        try {
            Thread.sleep((long)(time*1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void telemetry(boolean red) {
        telemetry.addData("red? ", red);
    }

    private void driveTapnGo() {
        motor0.setPower(-1);
        motor1.setPower(.9);
        timer(.1);
        motor0.setPower(1);
        motor1.setPower(-.9);
        timer(.4);
        motor0.setPower(0);
        motor1.setPower(0);
    }

    private void driveGo() {
        motor0.setPower(1);
        motor1.setPower(-.9);
        timer(.4);
        motor0.setPower(0);
        motor1.setPower(0);

    }

    private boolean color() {
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

        if (maxRed > maxBlue)
            redVisible = true;
        else
            redVisible = false;

        return redVisible;
    }
}
