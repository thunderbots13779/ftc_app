package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class Auto extends Driver {

    State state = State.START;
    int i = 0;

    Action[] actions = {
            new Initialize(),
//            new Grab_Auto(),
//            new Timed(10000),
            new RunToPosition(1, Robot.motor_left),
            new End()
    };

    @Override
    public void loop() {

        telemetry.addData("action", i);
//        if (Robot.angles != null) {
//            telemetry.addData("z rotation", Robot.angles.firstAngle);
//            telemetry.addData("y rotation", Robot.angles.secondAngle);
//            telemetry.addData("x rotation", Robot.angles.thirdAngle);
//        }
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
