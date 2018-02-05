package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by pramo on 12/14/2017.
 */

@Autonomous
public class Auto_Test extends Autonomous_Code{



    @Override
    public void runOpMode() {

        waitForStart();

        while (opModeIsActive()) {
            initialization();
//            grab();
            telemetry.addData("Time: ", System.currentTimeMillis());
            telemetry.update();
        }
    }

}
