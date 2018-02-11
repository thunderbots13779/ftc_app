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
        if(Robot.gamepad1.a){
            Robot.motor_flipper.setPower(1);
        } else {
            Robot.motor_flipper.setPower(0);
        }
    }


    public void end() {

    }

    public boolean check() {
        return false;
    }

}
