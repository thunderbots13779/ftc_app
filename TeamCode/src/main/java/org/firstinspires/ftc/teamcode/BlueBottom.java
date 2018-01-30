package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by pramo on 12/14/2017.
 */

@Autonomous
public class BlueBottom extends Autonomous_Code{

    @Override
    public void runOpMode() {

        if (opModeIsActive()) {
            initialization();
            auto("blue");
            bottomBlue();
        }
    }

}
