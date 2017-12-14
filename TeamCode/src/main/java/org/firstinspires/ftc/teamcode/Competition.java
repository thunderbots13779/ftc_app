package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.SwitchableLight;

@TeleOp
public class Competition extends LinearOpMode {

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

        boolean redVisible = color();
        telemetry.addData("red? ", redVisible);
        servo0.setPosition(77.0/180.0);
        try {
            Thread.sleep((long)1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (redVisible) {
            driveTrain.moveSeconds((long)100, 1);
        } else {
            motor0.setPower(-1);
            motor1.setPower(.9);
            try {
                Thread.sleep((long)100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            motor0.setPower(0);
            motor1.setPower(0);
        }
        try {
            Thread.sleep((long)200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        servo0.setPosition(174.0/180.0);

        //run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            //SETUP
            setupTeleOp();

            //DRIVE TRAIN
            move();

            //GRABBER
            grab();

            //VERTICAL LIFT
            lift();

            //TELEMETRY
            telemetry(this.gamepad1, this.gamepad2);
        }
    }

    private void setupTeleOp() {
        //INITIALIZATION
        servo0.setPosition(174.0/180.0);

        //LIGHT
        SwitchableLight light = (SwitchableLight)colorSensor;
        light.enableLight(!light.isLightOn());
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

    private void move() {
        if (gamepad1.left_stick_y != 0 || gamepad1.right_stick_y != 0) {
            driveTrain.move(this.gamepad1.right_stick_y, this.gamepad1.left_stick_y);
        } else {
            driveTrain.move(this.gamepad2.right_stick_y, this.gamepad2.left_stick_y);}
        if (gamepad1.dpad_down || gamepad1.dpad_up) {
            driveTrain.dpad(this.gamepad1.dpad_up, this.gamepad1.dpad_down);
        } else {
            driveTrain.dpad(this.gamepad2.dpad_up, this.gamepad1.dpad_down);
        }
    }

    private void grab() {
        if (gamepad1.right_bumper) {
            grabber.Grab(this.gamepad1.right_bumper);
        } else {
            grabber.Grab(this.gamepad2.right_bumper);
        }
    }

    private void lift() {
        if (gamepad1.left_trigger != 0|| gamepad1.right_trigger != 0) {
            liftMotor.Lift(this.gamepad1.left_trigger, this.gamepad1.right_trigger, this.gamepad1.left_bumper);
        } else {
            liftMotor.Lift(this.gamepad2.left_trigger, this.gamepad2.right_trigger, this.gamepad2.left_bumper);
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
