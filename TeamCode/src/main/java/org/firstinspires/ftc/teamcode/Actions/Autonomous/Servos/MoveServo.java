package org.firstinspires.ftc.teamcode.Actions.Autonomous.Servos;

import org.firstinspires.ftc.teamcode.Actions.Action;
import org.firstinspires.ftc.teamcode.Actions.Autonomous.Timed;
import org.firstinspires.ftc.teamcode.Robot;

public class MoveServo extends Timed {

    double position;

    public MoveServo (Robot.Servos servos, double position, long duration) {
        super(duration);
        Robot.servos = servos;
        this.position = position;
    }

    public void start() {
        super.start();
        switch (Robot.servos) {
            case SWIVEL:
                Robot.servo_swivel.setPosition(position);
                break;
            case DROPPER:
                Robot.servo_dropper.setPosition(position);
                break;
        }
    }

}
