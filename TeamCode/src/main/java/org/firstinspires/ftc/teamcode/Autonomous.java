package org.firstinspires.ftc.teamcode;

public class Autonomous extends Driver {

    Action[] actions = {
            new Initialize(),
            new Grab(),
            new End()
    };

    @Override
    public void loop() {
        State state = State.START;

        switch (state) {

            case START:
                state = State.LOOP;
                actions[0].start();
                break;
            case LOOP:
                if (actions[0].check()) {
                    actions[0].loop();
                    break;
                } else {
                    state = State.STOP;
                    break;
                }
            case STOP:


        }
    }
}
