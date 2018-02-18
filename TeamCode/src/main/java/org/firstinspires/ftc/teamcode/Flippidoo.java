package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Pramodh on 2/10/18.
 */

public class Flippidoo implements Action{

    public enum FlipperPositions {
        BOTTOM,
        MIDDLE,
        TOP
    }

    FlipperPositions flipperPos = FlipperPositions.BOTTOM;

    public void start() {
    }

    public void loop() {

        switch (flipperPos) {
            case BOTTOM:
                Robot.flipperPosition(0.0);
                if (Robot.gamepad2.right_bumper)
                    flipperPos = FlipperPositions.MIDDLE;
                break;
            case MIDDLE:
                Robot.flipperPosition(20.0);
                if (Robot.gamepad2.left_bumper) {
                    flipperPos = FlipperPositions.BOTTOM;
                } else {
                    flipperPos = FlipperPositions.TOP;
                }
                break;
            case TOP:
                Robot.flipperPosition(110.0);
                if (Robot.gamepad2.left_bumper)
                    flipperPos = FlipperPositions.MIDDLE;
                break;
        }

//        if (Robot.gamepad2.dpad_left){
//            Robot.left.start();
//        } else if (Robot.gamepad2.dpad_right) {
//            Robot.right.start();
//        }
//        if(Robot.left.check()) {
//            Robot.motor_flipper.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        }
//        if(Robot.right.check()) {
//            Robot.motor_flipper.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        }
//        if(brake) {
//            Robot.motor_flipper.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        } else {
//            Robot.motor_flipper.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
//        }
    }
    
    public void end() {

    }

    public boolean check() {
        return false;
    }

}
