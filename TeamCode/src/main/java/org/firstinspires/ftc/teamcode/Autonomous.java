package org.firstinspires.ftc.teamcode;

public class Autonomous extends Driver {

    Action[] actions = {new Grab()};

    @Override
    public void loop() {
        State state = State.INITIALIZE;

        switch (state) {

            case INITIALIZE:
                state = State.START;
                actions[0].initialize();
                break;
            case START:
                state = State.CHECK;
                actions[0].start();
                break;
            case CHECK:
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
