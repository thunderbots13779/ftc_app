package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Pramodh on 2/10/18.
 */

public class Flippidoo implements Action{





    public void start() {
    }

    public void loop() {
        if (Robot.gamepad2.dpad_left){
            Robot.left.start();
        } else if (Robot.gamepad2.dpad_right) {
            Robot.right.start();
        }
        if(Robot.left.check()) {
            Robot.motor_flipper.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }
        if(Robot.right.check()) {
            Robot.motor_flipper.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }
    }
    
    public void end() {

    }

    public boolean check() {
        return false;
    }

}
