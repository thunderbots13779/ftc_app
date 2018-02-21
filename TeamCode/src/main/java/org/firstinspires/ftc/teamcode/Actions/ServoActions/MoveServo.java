package org.firstinspires.ftc.teamcode.Actions.ServoActions;

import org.firstinspires.ftc.teamcode.Actions.Action;
import org.firstinspires.ftc.teamcode.Robot;

/**
 * Created by Pramodh on 2/10/18.
 */

public class MoveServo implements Action {

    double position;

    public MoveServo (Robot.Servos servos, double position) {
        Robot.servos = servos;
        this.position = position;
    }

    public void start() {
        switch (Robot.servos) {
            case LEFT_FLIPPER:
                Robot.servo_leftFlipper.setPosition(position);
                break;
            case RIGHT_FLIPPER:
                Robot.servo_rightFlipper.setPosition(position);
                break;
            case LEFT_INTAKE:
                Robot.servo_leftIntake.setPosition(position);
                break;
            case RIGHT_INTAKE:
                Robot.servo_rightIntake.setPosition(position);
                break;
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
