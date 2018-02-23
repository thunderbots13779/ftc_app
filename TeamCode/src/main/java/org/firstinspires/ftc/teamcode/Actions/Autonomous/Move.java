package org.firstinspires.ftc.teamcode.Actions.Autonomous;

import org.firstinspires.ftc.teamcode.Actions.Action;
import org.firstinspires.ftc.teamcode.Robot;

public class Move extends RunUsingEncoder{

    public Move(int ticks, float power) {
        super(ticks, Robot.Motors.LEFT, power);
    }

}
