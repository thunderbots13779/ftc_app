package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class TeleOP extends Driver {

    @Override
    public void loop() {
        super.loop();
        telemetry.addData("z rotation", Robot.angles.firstAngle);
    }
}
