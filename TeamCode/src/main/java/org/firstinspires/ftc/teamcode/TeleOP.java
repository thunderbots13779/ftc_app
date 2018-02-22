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

    State state = State.START;
//    Raiser raiser =  new Raiser();
//    FlyWheels flyWheels = new FlyWheels();
//    Move move = new Move();
//    Rotate rotate = new Rotate();

//    RunToPosition pos = new RunToPosition(-500, Robot.Motors.FLIP);

    Action[] actions = {
//            new FlyWheels(),

    };

    @Override
    public void init() {
        super.init();


    }

    @Override
    public void start() {
//        new RunToPosition(500, Robot.Motors.FLIP).start();
//        pos.start();
        Robot.motor_leftIntake.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        Robot.motor_leftIntake.setPower(1);
        Robot.motor_leftIntake.setTargetPosition(1680);
    }

    @Override
    public void loop() {
        telemetry.addData("position : ", Robot.motor_leftIntake.getCurrentPosition());
        telemetry.addData("is busy : ", Robot.motor_leftIntake.isBusy());
//        new Flip().loop();
//        telemetry.addData("Curr: ", Robot.motor_flipper.getCurrentPosition());
//        telemetry.addData("Target: ", Robot.motor_flipper.getTargetPosition());
//        telemetry.addData("Check: ", pos.check());
//        telemetry.addData("Encoders: ", Robot.motor_flipper.isBusy());
//        switch (Robot.flipperPos) {
//            case BOTTOM:
//                telemetry.addData("BOTTOM: ", Robot.motor_flipper.isBusy());
//                break;
//            case MIDDLE:
//                telemetry.addData("MIDDLE: ", Robot.motor_flipper.isBusy());
//                break;
//            case TOP:
//                telemetry.addData("TOP: ", Robot.motor_flipper.isBusy());
//                break;
//        }
    }


}
