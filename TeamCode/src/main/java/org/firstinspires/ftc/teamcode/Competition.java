package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class Competition extends LinearOpMode {

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

    @Override
    public void runOpMode() {

        initialization();

        //Wait for the game to start (driver presses PLAY)
        waitForStart();

        //run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            servo0.setPosition(174.0/180.0);
            servo3.setPosition(.5);

            //DRIVE TRAIN
            move();
            strafe();
            //GRABBER
            grab();

            //VERTICAL LIFT
            lift();

            //TELEMETRY
            telemetry(this.gamepad1, this.gamepad2);
        }
    }

    private void initialization() {

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

        //sends tests data to dc phone
        telemetry.addData("Status", "Initialized");
        telemetry.update();
    }

    private void move() {
        if (gamepad1.left_stick_y != 0 || gamepad1.right_stick_y != 0) {
            driveTrain.move(this.gamepad1.right_stick_y, this.gamepad1.left_stick_y);
        } else {
            driveTrain.move(this.gamepad2.right_stick_y, this.gamepad2.left_stick_y);
        }
        if (gamepad1.dpad_down || gamepad1.dpad_up) {
            driveTrain.dpad(this.gamepad1.dpad_up, this.gamepad1.dpad_down);
        } else {
            driveTrain.dpad(this.gamepad2.dpad_up, this.gamepad1.dpad_down);
        }
    }

    private void lift() {
        if (gamepad1.left_bumper || gamepad1.right_bumper) {
            liftMotor.Lift(this.gamepad1.left_bumper, this.gamepad1.right_bumper);
        } else {
            liftMotor.Lift(this.gamepad2.left_bumper, this.gamepad2.right_bumper);
        }
    }

    private void grab() {
        if (gamepad1.a) {
            grabber.Grab(this.gamepad1.a);
        } else {
            grabber.Grab(this.gamepad2.a);
        }
    }

    private void strafe() {
        if (gamepad1.left_trigger != 0|| gamepad1.right_trigger != 0) {
            driveTrain.strafe(this.gamepad1.left_trigger, this.gamepad1.right_trigger);
        } else {
            driveTrain.strafe(this.gamepad2.left_trigger, this.gamepad2.right_trigger);
        }
    }

    private void telemetry(Gamepad gamepad, Gamepad gamepadB) {
        double rounding = 0.001;
        double leftStickY = gamepad.left_stick_y - gamepad.left_stick_y % rounding;
        double leftStickX = gamepad.left_stick_x - gamepad.left_stick_x % rounding;
        double rightStickY = gamepad.right_stick_y - gamepad.right_stick_y % rounding;
        double rightStickX = gamepad.right_stick_x - gamepad.right_stick_x % rounding;

        //DRIVE GAMEPAD/GAMEPAD A
        telemetry.addLine("--- Gamepad A ---");
        telemetry.addLine("Left Trigger: ")
                .addData("  x: ", leftStickX)
                .addData("  y: ", leftStickY);
        telemetry.addLine("Right Trigger: ")
                .addData("  x: ", rightStickX)
                .addData("  y: ", rightStickY);
        telemetry.addData("Gear: ", driveTrain.getGear());

        //LIFT GAMEPAD/GAMEPAD B
        telemetry.addLine("--- Gamepad B ---");
        telemetry.addLine("Bumpers: ")
                .addData("  right: ", gamepadB.right_bumper)
                .addData("  left: ", gamepadB.left_bumper);
        telemetry.addLine("Triggers")
                .addData("  right: ", gamepad.right_trigger)
                .addData("  left: ", gamepad.left_trigger);

        telemetry.update();

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
            try {
                Thread.sleep((long).1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        boolean redVisible = maxRed > maxBlue;

        return redVisible;
    }
}
