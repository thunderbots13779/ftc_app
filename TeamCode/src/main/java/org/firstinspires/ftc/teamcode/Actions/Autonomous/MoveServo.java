package org.firstinspires.ftc.teamcode.Actions.Autonomous;

import org.firstinspires.ftc.teamcode.Actions.Action;
import org.firstinspires.ftc.teamcode.Robot;

public class MoveServo implements Action {

    double position;

    public MoveServo (Robot.Servos servos, double position) {
        Robot.servos = servos;
        this.position = position;
    }

    public void start() {
        switch (Robot.servos) {
            case SWIVEL:
                Robot.servo_swivel.setPosition(position);
                break;
            case DROPPER:
                Robot.servo_dropper.setPosition(position);
                break;
        }
    }
    public void loop() {

    }

    public void end() {

    }

    public boolean check() {
        return false;
    }

}
