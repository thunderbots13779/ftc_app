package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by pramo on 1/3/2018.
 */

@Autonomous
public class SensorTest extends LinearOpMode {

//    Accelerometer a = new Accelerometer();
    @Override
    public void runOpMode() {
        waitForStart();
        while (opModeIsActive()) {
            telemetry.addLine("Accelerometer")
                    .addData("Y: ", Accelerometer.aY)
                    .addData("X: ", Accelerometer.aX)
                    .addData("Z: ", Accelerometer.aZ);
            telemetry.update();
        }
    }
}
