package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by pramo on 12/14/2017.
 */

@Autonomous
public class Auto_Test extends AutoTimer{

    @Override
    public void runOpMode() {

        if (opModeIsActive()) {
            telemetry.addData("Time: ", getTime());
            telemetry.update();
        }
    }

}
