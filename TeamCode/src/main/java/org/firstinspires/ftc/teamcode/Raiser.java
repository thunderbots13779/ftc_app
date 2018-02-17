package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.robotcore.internal.usb.exception.RobotUsbUnspecifiedException;

/**
 * Created by Pramodh on 2/10/18.
 */

public class Raiser implements Action{

    public void start() {
    }
    public void loop() {
        if (Robot.gamepad2.dpad_up){
            new RunToPosition(-1, Motors.RAISER).start();
        } else if (Robot.gamepad2.dpad_down) {
            new RunToPosition(1, Motors.RAISER).start();
        }


    }

    public void end() {
    }

    public boolean check() {
        return false;
    }

}
