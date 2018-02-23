package org.firstinspires.ftc.teamcode.Actions.Autonomous;

import android.graphics.Color;

import org.firstinspires.ftc.teamcode.Actions.Action;
import org.firstinspires.ftc.teamcode.Robot;

public class Dropper implements Action {

    Robot.AllianceColor expectedColor;
    ColorCheck colorCheck = new ColorCheck(expectedColor);

    public Dropper(Robot.AllianceColor allianceColor) {
        this.expectedColor = allianceColor;
    }

    public void start() {

    }
    public void loop() {
        colorCheck.loop();
    }

    public void end() {
        colorCheck.end();
        new MoveServo(Robot.Servos.SWIVEL, 90);
        new MoveServo(Robot.Servos.DROPPER, Robot.servoDown);
        if (Robot.correctColor) {
            new MoveServo(Robot.Servos.SWIVEL, 0);
        } else  {
            new MoveServo(Robot.Servos.SWIVEL, 180);
        }
        new MoveServo(Robot.Servos.DROPPER, Robot.servoUp);
    }

    public boolean check() {
        return false;
    }
}
