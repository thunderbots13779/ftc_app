package org.firstinspires.ftc.teamcode.Actions.Autonomous;

import org.firstinspires.ftc.teamcode.Actions.Action;
import org.firstinspires.ftc.teamcode.Robot;

/**
 * Created by Pramodh on 2/10/18.
 */

public class ColorCheck implements Action {

    Robot.AllianceColor expectedColor;
    double red;
    double blue;

    public ColorCheck(Robot.AllianceColor allianceColor) {
        this.expectedColor = allianceColor;
    }

    public void start() {

    }

    public void loop() {

        Robot.colors = Robot.colorSensor.getNormalizedColors();
        red = Robot.scale * Robot.colors.red;
        blue = Robot.scale * Robot.colors.blue;
        if (red > Robot.maxRed)
            Robot.maxRed = red;
        if (blue > Robot.maxBlue)
            Robot.maxBlue = blue;

    }

    public void end() {
        if (expectedColor == Robot.allianceColor) {
            if (Robot.maxRed > Robot.maxBlue)
                Robot.correctColor = true;
            else
                Robot.correctColor = false;
        } else {
            if (Robot.maxRed < Robot.maxBlue)
                Robot.correctColor = true;
            else
                Robot.correctColor = false;
        }
    }

    public boolean check() {
        return false;
    }

}
