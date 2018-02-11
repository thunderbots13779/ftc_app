package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class TeleOP extends Driver{

    State state = State.START;

    Action[] actions = {
            new Initialize(),
            new FlyWheels(gamepad1.left_trigger, gamepad1.right_trigger)
    };

    @Override
    public void loop() {
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
