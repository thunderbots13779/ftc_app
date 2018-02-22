package org.firstinspires.ftc.teamcode.Autonomous_OPModes;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Actions.Action;
import org.firstinspires.ftc.teamcode.Actions.End;
import org.firstinspires.ftc.teamcode.Actions.RunToPosition;
import org.firstinspires.ftc.teamcode.Driver;
import org.firstinspires.ftc.teamcode.Robot;

@Autonomous
public class Auto extends Driver {

    State state = State.START;
    int i = 0;

    Action[] actions = {
//            new RunToPosition(100, Robot.Motors.FLIP),
//        new RunToPosition(-100, Robot.Motors.FLIP),
            new End()
    };

//    @Override
//    public void start() {
//        super.start();
//        Robot.motor_leftIntake.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        Robot.motor_leftIntake.setTargetPosition(1120);
//        Robot.motor_leftIntake.setPower(1);
//        Robot.motor_leftIntake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//    }

    @Override
    public void loop() {


        telemetry.addData("action", i);
        telemetry.addData("ticks", Robot.motor_flipper.getCurrentPosition());
////        if (Robot.angles != null) {
////            telemetry.addData("z rotation", Robot.angles.firstAngle);
////            telemetry.addData("y rotation", Robot.angles.secondAngle);
////            telemetry.addData("x rotation", Robot.angles.thirdAngle);
////        }
//        telemetry.update();



        switch (state) {
            case START:
                state = State.LOOP;
                actions[i].start();
                break;
            case LOOP:
                if (actions[i].check()) {
                    actions[i].loop();
                    break;
                } else {
                    state = State.STOP;
                    break;
                }
            case STOP:
                actions[i].end();
                i++;
                state = State.START;
                break;
        }
    }
}
