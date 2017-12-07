package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 *Created by Pramodh on 10/27/2017.
 */
@TeleOp
public class Driver extends LinearOpMode {
    private DcMotor motor0;
    private DcMotor motor1;
    private DcMotor motor2;
    private Servo servo0;
    private Servo servo1;
    private Servo servo2;

    @Override
    public void runOpMode() {

        //HARDWARE MAPS
        motor0 = hardwareMap.get(DcMotor.class, "motor0");
        motor1 = hardwareMap.get(DcMotor.class, "motor1");
        motor2 = hardwareMap.get(DcMotor.class, "motor2");
        servo0 = hardwareMap.get(Servo.class, "servo0");
        servo1 = hardwareMap.get(Servo.class, "servo1");
        servo2 = hardwareMap.get(Servo.class, "servo2");

        //INITIALIZATION
        TankDriveTrain driveTrain = new TankDriveTrain(motor0, motor1);
        Grabber grabber = new Grabber(servo1, servo2);
        VerticalLiftMotor liftMotor = new VerticalLiftMotor(motor2);

        //sends tests data to dc phone
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        //Wait for the game to start (driver presses PLAY)
        waitForStart();

        //run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            //DRIVE TRAIN
            driveTrain.dpad(this.gamepad1.dpad_up, this.gamepad2.dpad_up, this.gamepad1.dpad_down, this.gamepad2.dpad_down);
            if (gamepad1.left_stick_y != 0 || gamepad1.right_stick_y != 0) {
                driveTrain.move(this.gamepad1.right_stick_y, this.gamepad1.left_stick_y);
            } else {
                driveTrain.move(this.gamepad2.right_stick_y, this.gamepad2.left_stick_y);
            }

            //STRAFE
//            if (gamepad1.left_stick_x != 0) {
//                driveTrain.strafe(this.gamepad1.left_stick_x);
//            } else {
//                driveTrain.strafe(this.gamepad2.left_stick_x);
//            }

            //GRABBER
            if (gamepad1.right_bumper) {
                grabber.Grab(this.gamepad1.right_bumper);
            } else {
                grabber.Grab(this.gamepad2.right_bumper);
            }

            //VERTICAL LIFT
//            lift.Lift(this.gamepad1.left_bumper, this.gamepad2.left_bumper, this.gamepad1.left_trigger, this.gamepad2.left_trigger);
            if (gamepad1.left_trigger != 0|| gamepad1.right_trigger != 0) {
                liftMotor.Lift(this.gamepad1.left_trigger, this.gamepad1.right_trigger);
            } else {
                liftMotor.Lift(this.gamepad2.left_trigger, this.gamepad2.right_trigger);
            }

            //TELEMETRY
            telemetry.addData("Left Bumper", this.gamepad1.left_bumper);
            telemetry.addData("Right Bumper", this.gamepad1.right_bumper);
            telemetry.addData("Left Trigger", this.gamepad1.left_trigger);
            telemetry.addData("Right Trigger", this.gamepad1.right_trigger);
            telemetry.addData("Left Stick Y", this.gamepad1.left_stick_y);
            telemetry.addData("Right Stick Y", this.gamepad1.right_stick_y);
            telemetry.addData("power level", driveTrain.getPowerScale());
            telemetry.addData("gear", driveTrain.getGear());
            telemetry.update();
        }

//        grabber.reset();
    }
}