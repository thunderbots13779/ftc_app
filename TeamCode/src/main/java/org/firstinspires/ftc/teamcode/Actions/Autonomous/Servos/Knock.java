package org.firstinspires.ftc.teamcode.Actions.Autonomous.Servos;

import org.firstinspires.ftc.teamcode.Actions.Autonomous.Servos.MoveServo;
import org.firstinspires.ftc.teamcode.Robot;

public class Knock extends MoveServo {



    public Knock () {
        super(Robot.Servos.DROPPER, Robot.servoLeft, 1000);
        if (!Robot.correctColor) {
            position = Robot.servoRight;
        }

    }

    public void start() {
        super.start();
    }

}
