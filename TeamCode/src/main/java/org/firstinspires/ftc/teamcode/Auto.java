package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class Auto extends Driver {

    State state = State.START;
    int i = 0;

    Action[] actions = {
            new Initialize(),
            new Grab(),
            new End()
    };

    @Override
    public void loop() {

        telemetry.addData("action", i);
        telemetry.update();

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
