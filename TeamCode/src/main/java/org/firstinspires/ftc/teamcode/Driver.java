package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class Driver extends OpMode {

    @Override
    public void init() {
        map.hardwareMap = hardwareMap;
        Robot.initialize();
        Robot.startUpdates();
    }

    @Override
    public void loop() {

    }

    @Override
    public void stop() {
        Robot.timer.cancel();
    }

}
