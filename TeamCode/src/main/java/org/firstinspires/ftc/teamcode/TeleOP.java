package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Actions.*;
import org.firstinspires.ftc.teamcode.Actions.TeleOP.Flip;
import org.firstinspires.ftc.teamcode.Actions.TeleOP.FlyWheels;
import org.firstinspires.ftc.teamcode.Actions.TeleOP.Move;
import org.firstinspires.ftc.teamcode.Actions.TeleOP.Raiser;
import org.firstinspires.ftc.teamcode.Actions.TeleOP.Rotate;

@TeleOp
public class TeleOP extends Driver{

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
        new RunToPosition(200, Robot.Motors.LEFT, .5).start();
//        flip.start();
//        intake.start();
//        move.start();
    }

    @Override
    public void loop() {

//        flip.loop();
//        intake.loop();
//        move.loop();
//
//        if (Robot.angles != null) {
//            telemetry.addData("x: ", Robot.angles.firstAngle);
//            telemetry.addData("y: ", Robot.angles.secondAngle);
//            telemetry.addData("z: ", Robot.angles.thirdAngle);
//        }
    }


}
