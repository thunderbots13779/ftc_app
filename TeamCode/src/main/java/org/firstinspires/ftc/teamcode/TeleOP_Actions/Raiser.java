package org.firstinspires.ftc.teamcode.TeleOP_Actions;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.internal.usb.exception.RobotUsbUnspecifiedException;
import org.firstinspires.ftc.teamcode.Action;
import org.firstinspires.ftc.teamcode.Robot;

/**
 * Created by Pramodh on 2/10/18.
 */

public class Raiser implements Action {



    public void start() {
    }
    public void loop() {
        Robot.motor_raiser.setPower(Robot.gamepad2.left_stick_y);
//        if (Robot.gamepad2.dpad_up){
//            Robot.up.start();
//        } else if (Robot.gamepad2.dpad_down) {
//            Robot.down.start();
//        }
//        if(Robot.up.check()) {
//            Robot.motor_raiser.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        }
//        if(Robot.down.check()) {
//            Robot.motor_raiser.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        }
    }

    public void end() {
    }

    public boolean check() {
        return false;
    }

}
