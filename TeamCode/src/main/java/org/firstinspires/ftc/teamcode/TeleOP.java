package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class TeleOP extends Driver{

    State state = State.START;

    Action[] actions = {
            new Initialize(),
            new FlyWheels(),
            new Radion()
    };

    @Override
    public void loop() {
        telemetry.addData("motor position: ", Robot.motor_leftIntake.getCurrentPosition());
        telemetry.addData("x", Robot.gamepad1.right_stick_x);
        telemetry.addData("y", -1*Robot.gamepad1.right_stick_y);
        telemetry.addData("theta", Robot.theta);
        telemetry.update();
        switch (state) {
            case START:
                state = State.LOOP;
                for (Action a : actions) {
                    a.start();
                }
                break;
            case LOOP:
                for (Action a : actions) {
                    a.loop();
                }
                state = State.STOP;
                break;
            case STOP:
                for (Action a : actions) {
                    a.end();
                }
                state = State.START;
                break;
        }
    }

}
