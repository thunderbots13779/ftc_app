package org.firstinspires.ftc.teamcode;

public class Autonomous extends Driver {

    Actionable[] actions = {
            new Grab(),
    };

    @Override
    public void loop() {
        State state = State.INITIALIZE;
        int i = 0;

        if (i <= actions.length) {
            switch (state) {

                case INITIALIZE:
                    state = State.START;
                    actions[i].initialize();
                    break;
                case START:
                    state = State.CHECK;
                    actions[i].start();
                    break;
                case CHECK:
                    if (actions[i].check()) {
                        actions[i].loop();
                        break;
                    } else {
                        state = State.STOP;
                        break;
                    }
                case STOP:


            }
            i++;
            state = State.INITIALIZE;
        }
    }
}
