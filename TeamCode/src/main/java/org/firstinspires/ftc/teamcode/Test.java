package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class Test extends LinearOpMode {

    private Servo servo0;
    private Servo servo1;

    @Override
    public void runOpMode() {

        servo0 = hardwareMap.get(Servo.class, "servo0");
        servo1 = hardwareMap.get(Servo.class, "servo1");

        //Wait for the game to start (driver presses PLAY)
        waitForStart();

        //run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            if (this.gamepad1.left_stick_x > 0) {
                servo0.setPosition(1);
            } else if (this.gamepad1.left_stick_x < 0) {
                servo0.setPosition(0);
            } else {
                servo0.setPosition(1);
            }

            if (this.gamepad1.right_stick_x > 0) {
                servo1.setPosition(1);
            } else if (this.gamepad1.right_stick_x < 0) {
                servo1.setPosition(0);
            } else {
                servo1.setPosition(1);
            }
        }

    }
}
