package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class TeleOP extends Driver{

//    State state = State.START;


//    Action[] actions = {
//            new Initialize(),
//            new FlyWheels()
//    };

    @Override
    public void start() {

        super.start();
        Robot.servo_leftFlipper.setPosition(97/180.0);
        Robot.servo_rightFlipper.setPosition(84/180.0);

    }

    @Override
    public void loop() {
        telemetry.addData("position: ", Robot.servo_leftFlipper.getPosition());
        telemetry.addData("position: ", Robot.servo_rightFlipper.getPosition());
        telemetry.update();
//        new RunToPosition(1, Motors.FlIPPER);
//        if (Robot.angles != null) {
//            telemetry.addData("z: ", Robot.currentHeading);
//        }
//        telemetry.addData("motor positionn: ", Robot.motor_left.getCurrentPosition());
//        float position = 1680f;
//        float power;
//        if (Robot.motor_left.getCurrentPosition() < position)
//            power = 1 - (Robot.motor_left.getCurrentPosition() / position) / 2;
//        else
//            power = 0;
//        telemetry.addData("motor power: ", power);
//        Robot.motor_left.setPower(power);
//        switch (state) {
//            case START:
//                state = State.LOOP;
//                for (Action a : actions) {
//                    a.start();
//                }
//                break;
//            case LOOP:
//                for (Action a : actions) {
//                    a.loop();
//                }
//                state = State.STOP;
//                break;
//            case STOP:
//                for (Action a : actions) {
//                    a.end();
//                }
//                state = State.START;
//                break;
//        }

    }

}
