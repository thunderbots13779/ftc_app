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
public class Auto_Test extends Autonomous_Code{

    @Override
    public void runOpMode() {

        //Wait for the game to start (driver presses PLAY)
        waitForStart();

        if (opModeIsActive()) {
            //run until the end of the match (driver presses STOP)
            auto("blue");
            telemetry.addData("column", getColumn());
            telemetry.update();
            bottomRed();
        }
    }

}
