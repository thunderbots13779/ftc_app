package org.firstinspires.ftc.teamcode.Autonomous_OPModes;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Actions.Action;
import org.firstinspires.ftc.teamcode.Actions.Autonomous.Dropper;
import org.firstinspires.ftc.teamcode.Actions.Autonomous.RunUsingEncoder;
import org.firstinspires.ftc.teamcode.Actions.End;
import org.firstinspires.ftc.teamcode.Actions.RunToPosition;
import org.firstinspires.ftc.teamcode.Driver;
import org.firstinspires.ftc.teamcode.Robot;

@Autonomous
public class Auto extends Driver {

    State state = State.START;
    boolean expectedColor = true;
    int i = 0;

    Action[] actions = {
            new Dropper(expectedColor),
            new End()
    };

    @Override
    public void init() {
        Robot.RED = true;
    }

    @Override
    public void loop() {
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
