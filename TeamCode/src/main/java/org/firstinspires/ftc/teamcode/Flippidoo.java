package org.firstinspires.ftc.teamcode;

/**
 * Created by Pramodh on 2/10/18.
 */

public class Flippidoo implements Action{

    public Flippidoo () {
    }

    public void start() {

    }
    public void loop() {
        if (Robot.gamepad2.dpad_right){
            new RunToPosition(-.05, Motors.FlIPPER).start();
        } else if (Robot.gamepad2.dpad_left) {
            new RunToPosition(.05, Motors.FlIPPER).start();
        }
    }


    public void end() {

    }

    public boolean check() {
        return false;
    }

}
