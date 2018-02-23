package org.firstinspires.ftc.teamcode.Actions.Autonomous.Servos;

import org.firstinspires.ftc.teamcode.Actions.Autonomous.Servos.MoveServo;
import org.firstinspires.ftc.teamcode.Robot;

public class SwivelRight extends MoveServo {

    public SwivelRight () {
        super(Robot.Servos.DROPPER, Robot.servoRight, 300);
    }

    public void start() {
        super.start();
    }

}
