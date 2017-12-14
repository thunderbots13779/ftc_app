<<<<<<< HEAD
package org.firstinspires.ftc.teamcode;

/**
 * Created by pramo on 12/9/2017.
 */

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class test extends LinearOpMode {
    private DcMotor motor0;
    private DcMotor motor1;
    private Servo servo0;
    private NormalizedColorSensor colorSensor;

    @Override
    public void runOpMode() {

        //HARDWARE MAPS
        motor0 = hardwareMap.get(DcMotor.class, "motor0");
        motor1 = hardwareMap.get(DcMotor.class, "motor1");
        servo0 = hardwareMap.get(Servo.class, "servo0");
        colorSensor = hardwareMap.get(NormalizedColorSensor.class, "colorSensor");


        //INITIALIZATION
        TankDriveTrain driveTrain = new TankDriveTrain(motor0, motor1);

        //sends tests data to dc phone
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        //Wait for the game to start (driver presses PLAY)
        waitForStart();

        servo0.setPosition(77.0/180.0);

        int scale = 10000;
        double threshold = 20;

        double red = 0;
        double blue = 0;

        boolean redVisible;

        while(opModeIsActive()) {

            NormalizedRGBA colors = colorSensor.getNormalizedColors();
            int color = colors.toColor();

            red = scale * colors.red;
            blue = scale * colors.blue;

            redVisible = (red > threshold) && (red > blue);

            telemetry.addLine("rawAndroid color: ")
                    .addData("r", (int)red)
                    .addData("b", (int)blue);
            telemetry.addLine().addData("red visible", redVisible);
            telemetry.update();
//            servo0.setPosition(77.0 / 180.0);

            if (redVisible) {
//                motor1.setPower(.5);
//                motor0.setPower(-.5);
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } finally {
//                    motor1.setPower(0);
//                    servo0.setPosition(174.0 / 180.0);
//                    stop();
//                }
            } else {
//                motor0.setPower(.5);
//                motor1.setPower(-.5);
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } finally {
//                    motor1.setPower(0);
//                    servo0.setPosition(174.0 / 180.0);
//                    stop();
//                }
            }
        }
    }
}
=======
>>>>>>> 044f912596f754c81b61a1b53836de73fd78232a
