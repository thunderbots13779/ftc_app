package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class Driver extends OpMode {

    @Override
    public void init() {

        Robot.hardwareMap = hardwareMap;
        Robot.gamepad1 = gamepad1;
        Robot.initialize();
        Robot.startUpdates();

    }

    @Override
    public void init_loop() {

    }

    @Override
    public void start() {

    }

    @Override
    public void loop() {

    }

    @Override
    public void stop() {

        Robot.finalHeading = Robot.angles.firstAngle;
        Robot.timer.cancel();

    }

}
