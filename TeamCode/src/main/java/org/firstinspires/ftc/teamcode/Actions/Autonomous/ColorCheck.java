package org.firstinspires.ftc.teamcode.Actions.Autonomous;

import android.util.Log;

import com.qualcomm.robotcore.hardware.NormalizedRGBA;

import org.firstinspires.ftc.teamcode.Actions.Action;
import org.firstinspires.ftc.teamcode.Robot;

/**
 * Created by Pramodh on 2/10/18.
 */

public class ColorCheck extends Timed{

    boolean expectedColor;
    double red;
    double blue;
    final int scale = 100;
    double maxRed = 0;
    double maxBlue = 0;
    NormalizedRGBA colors;

    public ColorCheck(boolean expectedColor, long duration) {
        super(duration);
        this.expectedColor = expectedColor;
    }

    public void start() {
        if (Robot.colorSensor.getNormalizedColors().red > Robot.colorSensor.getNormalizedColors().blue) {
            Robot.servo_swivel.setPosition(Robot.servoLeft);
        } else {
            Robot.servo_swivel.setPosition(Robot.servoRight);
        }
    }

    public void loop() {

        colors = Robot.colorSensor.getNormalizedColors();
        red = scale * colors.red;
        blue = scale * colors.blue;
        Log.d("RED: ", "" + red);
        Log.d("BLUE: ", "" + blue);
        maxRed += red;
        maxBlue += blue;

    }

    public void end() {
//        if (expectedColor) {
//            if (maxRed > maxBlue)
//                Robot.servo_swivel.setPosition(Robot.servoLeft);
//            else
//                Robot.servo_swivel.setPosition(Robot.servoRight);
//        } else {
//            if (maxRed < maxBlue)
//                Robot.servo_swivel.setPosition(Robot.servoLeft);
//            else
//                Robot.servo_swivel.setPosition(Robot.servoRight);
//        }

    }

}
