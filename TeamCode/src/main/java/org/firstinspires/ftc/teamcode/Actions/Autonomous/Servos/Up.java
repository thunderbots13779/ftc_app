package org.firstinspires.ftc.teamcode.Actions.Autonomous.Servos;

import org.firstinspires.ftc.teamcode.Actions.Autonomous.Servos.MoveServo;
import org.firstinspires.ftc.teamcode.Robot;

public class Up extends MoveServo {

    public Up () {
        super(Robot.Servos.DROPPER, Robot.servoUp, 300);
    }

    public void start() {
        super.start();
    }

}
