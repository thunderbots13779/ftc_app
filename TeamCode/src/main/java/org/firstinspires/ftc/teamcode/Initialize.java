package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Initialize implements Action {

    public void start() {

        Robot.initialize();

        Robot.motor_left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }

    public void loop() {

    }

    public void end() {

    }

    public boolean check() {
        return false;
    }

}
