package org.firstinspires.ftc.teamcode.Actions.Autonomous.Servos;

import android.util.Log;

import org.firstinspires.ftc.teamcode.Actions.Autonomous.Servos.MoveServo;
import org.firstinspires.ftc.teamcode.Robot;

public class Knock extends MoveServo {



    public Knock () {
        super(Robot.Servos.SWIVEL, Robot.position, 1000);


    }
}
