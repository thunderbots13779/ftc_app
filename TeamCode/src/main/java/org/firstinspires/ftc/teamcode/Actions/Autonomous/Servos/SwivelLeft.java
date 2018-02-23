package org.firstinspires.ftc.teamcode.Actions.Autonomous.Servos;

import org.firstinspires.ftc.teamcode.Actions.Autonomous.Servos.MoveServo;
import org.firstinspires.ftc.teamcode.Robot;

public class SwivelLeft extends MoveServo {



    public SwivelLeft () {
        super(Robot.Servos.DROPPER, Robot.servoLeft, 300);
        if (!Robot.correctColor) {
            position = Robot.servoRight;
        }

    }

    public void start() {
        super.start();
    }

}
