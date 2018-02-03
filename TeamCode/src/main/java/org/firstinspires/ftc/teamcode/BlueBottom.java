package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by pramo on 12/14/2017.
 */

@Autonomous
public class BlueBottom extends Autonomous_Code{

    @Override
    public void runOpMode() {

        waitForStart();
        initialization();
        if(opModeIsActive()) {
            auto("blue");
            blueBottom();
        }
    }

}
