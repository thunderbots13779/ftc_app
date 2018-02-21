package org.firstinspires.ftc.teamcode.Actions.Autonomous;

import android.renderscript.AllocationAdapter;

import org.firstinspires.ftc.teamcode.Actions.Action;
import org.firstinspires.ftc.teamcode.Robot;

/**
 * Created by Pramodh on 2/10/18.
 */

public class ColorCheck implements Action {

    public void start() {

    }

    public void loop() {

        Robot.colors = Robot.colorSensor.getNormalizedColors();
        double red = Robot.scale * Robot.colors.red;
        double blue = Robot.scale * Robot.colors.blue;
        if (red > Robot.maxRed)
            Robot.maxRed = red;
        if (blue > Robot.maxBlue)
            Robot.maxBlue = blue;

    }

    public void end() {
        if (Robot.allianceColor == Robot.AllianceColor.RED) {
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
