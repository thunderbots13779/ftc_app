package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by pramo on 12/14/2017.
 */

@Autonomous
public class Auto_Test extends Autonomous_Code{

    @Override
    public void runOpMode() {

        if (opModeIsActive()) {
            initialization();
            auto("blue");
            redBottom();
        }
    }

}
