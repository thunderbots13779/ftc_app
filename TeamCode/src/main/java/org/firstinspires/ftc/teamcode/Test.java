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

    private DcMotor motor0;
    private DcMotor motor1;
    private DcMotor motor2;

    @Override
    public void runOpMode() {

//          motor0 = hardwareMap.get(DcMotor.class, "motor_left");
            motor1 = hardwareMap.get(DcMotor.class, "motor1");
            motor2 = hardwareMap.get(DcMotor.class, "motor2");

        //Wait for the game to start (driver presses PLAY)
        waitForStart();

        //run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            float direction = Math.abs(gamepad1.right_stick_y) / (gamepad1.right_stick_y);

            motor1.setPower(-gamepad1.left_trigger * direction);
            motor2.setPower(gamepad1.left_trigger * direction);

//            if(gamepad1.left_bumper) {
//                motor0.setPower(.47);
//            } else if (gamepad1.right_bumper) {
//                motor0.setPower(-.47);
//            } else {
//                motor0.setPower(0);
//            }


        }

    }
}
