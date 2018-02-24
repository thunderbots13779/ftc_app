package org.firstinspires.ftc.teamcode.Actions.Autonomous.Servos;

import org.firstinspires.ftc.teamcode.Actions.Autonomous.Servos.MoveServo;
import org.firstinspires.ftc.teamcode.Robot;

public class Drop extends MoveServo {

    public Drop () {
        super(Robot.Servos.DROPPER, 180, 1000);
    }
}
