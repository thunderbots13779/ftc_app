package org.firstinspires.ftc.teamcode.Actions.Autonomous;

import org.firstinspires.ftc.teamcode.Robot;

/**
 * Created by Pramodh on 2/18/18.
 */

public class Dropper {
    public void start() {
        new ColorCheck();
        new MoveServo(Robot.Servos.SWIVEL, 90);
        new MoveServo(Robot.Servos.DROPPER, Robot.servoDown);
        if (Robot.correctColor) {
            new MoveServo(Robot.Servos.SWIVEL, 0);
        } else  {
            new MoveServo(Robot.Servos.SWIVEL, 180);
        }
        new MoveServo(Robot.Servos.DROPPER, Robot.servoUp);
    }
    public void loop() {
        
    }

    public void end() {

    }

    public boolean check() {
        return false;
    }
}
