package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class Initialize implements Action {

    public void start() {

        Robot.initialize();

    }

    public void loop() {

    }

    public void end() {

    }

    public boolean check() {
        return false;
    }

}
