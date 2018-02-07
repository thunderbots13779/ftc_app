package org.firstinspires.ftc.teamcode;

public class Autonomous extends Driver {

<<<<<<< HEAD
    Actionable[] actions = {
            new Grab(),
=======
    Action[] actions = {
            new Initialize(),
            new Grab(),
            new End()
>>>>>>> 7937d308af6632764f1012ad3e5e78452a052b6a
    };

    @Override
    public void loop() {
<<<<<<< HEAD
        State state = State.INITIALIZE;
        int i = 0;
=======
        State state = State.START;
>>>>>>> 7937d308af6632764f1012ad3e5e78452a052b6a

        if (i <= actions.length) {
            switch (state) {

<<<<<<< HEAD
                case INITIALIZE:
                    state = State.START;
                    actions[i].initialize();
=======
            case START:
                state = State.LOOP;
                actions[0].start();
                break;
            case LOOP:
                if (actions[0].check()) {
                    actions[0].loop();
>>>>>>> 7937d308af6632764f1012ad3e5e78452a052b6a
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
