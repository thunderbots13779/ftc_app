package org.firstinspires.ftc.teamcode.Actions;

import android.graphics.Color;

import org.firstinspires.ftc.teamcode.Robot;

/**
 * Created by Pramodh on 2/18/18.
 */

public class Dropper {
    public void start() {
        new ColorCheck();
        Robot.servo_swivel.setPosition(90);
        Robot.servo_dropper.setPosition(Robot.servoDown);
        if (Robot.correctColor) {
            Robot.servo_swivel.setPosition(0.0);
        } else  {
            Robot.servo_swivel.setPosition(180.0);
        }
        Robot.servo_swivel.setPosition(90);
    }
    public void loop() {
        
    }

    public void end() {

    }

    public boolean check() {
        return false;
    }
}
