package org.firstinspires.ftc.teamcode;

import android.util.Log;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Actions.*;
import org.firstinspires.ftc.teamcode.Actions.Autonomous.RunUsingEncoder;
import org.firstinspires.ftc.teamcode.Actions.TeleOP.Flip;
import org.firstinspires.ftc.teamcode.Actions.TeleOP.FlyWheels;
import org.firstinspires.ftc.teamcode.Actions.TeleOP.Move;
import org.firstinspires.ftc.teamcode.Actions.TeleOP.Raiser;
import org.firstinspires.ftc.teamcode.Actions.TeleOP.Rotate;
import org.firstinspires.ftc.teamcode.Actions.TeleOP.Test;

@TeleOp
public class TeleOP extends Driver{

    double upPower = .5;
    double downPower = .3;
    int bottom = 0 ;
    int middle = -170;
    int top = -500;

    private final double LEFT_FULL_OPEN_POSITION = (174.0/180.0);
    private final double LEFT_OPEN_POSITION = (149.0/180.0);
    private final double LEFT_CLOSED_POSITION = (84.0/180.0);
    private final double RIGHT_FULL_OPEN_POSITION = (28.0/180.0);
    private final double RIGHT_OPEN_POSITION = (53.0/180.0);
    private final double RIGHT_CLOSED_POSITION = (118.0/180.0);

    public boolean closed = false;
    public boolean leftClosed = false;
    public boolean rightClosed = false;
    public boolean isPressed = false;
    public boolean sideIsPressed = false;


    Raiser raiser = new Raiser();
    FlyWheels intake = new FlyWheels();
    Move move = new Move();
    Rotate rotate = new Rotate();
    Flip flip = new Flip();

    @Override
    public void init() {
        super.init();
        Robot.floatMotors();


    }

    @Override
    public void start() {
//        flip.start();
//        intake.start();
//        move.start();
//        raiser.start();
        Robot.servo_dropper.setPosition(Robot.servoUp);
    }

    @Override
    public void loop() {
//        flip.loop();
//        intake.loop();
//        move.loop();
//        raiser.loop();
//        Robot.motor_left.setPower(gamepad1.left_stick_y);
//        Robot.motor_right.setPower(-gamepad1.right_stick_y);
//        if (gamepad1.left_bumper) {
//            Robot.motor_center.setPower(-1);
//        } else if (gamepad1.right_bumper) {
//            Robot.motor_center.setPower(1);
//        } else {
//            Robot.motor_center.setPower(0);
//        }
//        Robot.motor_raiser.setPower(gamepad2.left_stick_y);
//        Robot.motor_flipper.setPower(gamepad2.right_stick_y);
//        if (gamepad2.left_trigger > 0) {
//            Robot.motor_leftIntake.setPower(-1);
//            Robot.motor_rightIntake.setPower(1);
//        } else if (gamepad2.right_bumper) {
//            Robot.motor_leftIntake.setPower(1);
//            Robot.motor_rightIntake.setPower(-1);
//        } else {
//            Robot.motor_leftIntake.setPower(0);
//            Robot.motor_rightIntake.setPower(0);
//        }

        if (Robot.gamepad2.left_trigger > 0) {
            Robot.motor_flipper.setPower(-Robot.powerScale(Robot.gamepad2.left_trigger));
        } else if (Robot.gamepad2.right_trigger > 0) {
            Robot.motor_flipper.setPower(Robot.powerScale(Robot.gamepad2.right_trigger));
        }

//        Robot.motor_flipper.setPower(1);

        if (Robot.gamepad2.left_bumper) {
            Robot.motor_leftIntake.setPower(1);
            Robot.motor_rightIntake.setPower(-1);
        } else if (Robot.gamepad2.right_bumper){
            Robot.motor_leftIntake.setPower(-1);
            Robot.motor_rightIntake.setPower(1);
        } else {
            Robot.motor_leftIntake.setPower(0);
            Robot.motor_rightIntake.setPower(0
            );
        }

        if (Robot.gamepad1.left_bumper) {
            Robot.motor_center.setPower(1);
        } else if (Robot.gamepad1.right_bumper){
            Robot.motor_center.setPower(-1);
        } else {
            Robot.motor_center.setPower(0);
        }
        if (Robot.gamepad1.right_stick_y >= 0) {
            Robot.motor_right.setPower(-Robot.powerScale(Robot.gamepad1.right_stick_y));
        } else {
            Robot.motor_right.setPower(Robot.powerScale(Robot.gamepad1.right_stick_y));
        }
        if (Robot.gamepad1.left_stick_y >= 0) {
            Robot.motor_left.setPower(Robot.highpPwerScale(Robot.gamepad1.left_stick_y));
        } else {
            Robot.motor_left.setPower(-Robot.highpPwerScale(Robot.gamepad1.left_stick_y));
        }

        if (Robot.gamepad2.a) {
            Robot.motor_raiser.setPower(1);
        } else if (Robot.gamepad2.b){
            Robot.motor_raiser.setPower(-.3);
        } else {
            Robot.motor_raiser.setPower(0);
        }

        if (!isPressed) {

            if (change) {
                if (closed) {
                    leftServo.setPosition(LEFT_OPEN_POSITION);
                    rightServo.setPosition(RIGHT_OPEN_POSITION);

                    closed = false;
                } else {
                    leftServo.setPosition(LEFT_CLOSED_POSITION);
                    rightServo.setPosition(RIGHT_CLOSED_POSITION);

                    closed = true;
                }

                isPressed = true;
            }

        }
        if (!change) {
            isPressed = false;
        }
    }

}
