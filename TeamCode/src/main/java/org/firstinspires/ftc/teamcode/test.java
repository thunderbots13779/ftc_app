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

        int scale = 1000;
        int cc = 0;
        int x = 0;
        while(opModeIsActive()) {
            NormalizedRGBA colors = colorSensor.getNormalizedColors();
            int color = colors.toColor();
            telemetry.addLine("rawAndroid color: ")
                    .addData("r", scale * colors.red)
                    .addData("b", scale * colors.blue);
            telemetry.update();
            servo0.setPosition(77.0/180.0);
//            while(x <= 5) {
//                motor1.setPower(.5);
//                if ((1000*colors.red) > 20) {
//                    cc++;
//                }
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                motor1.setPower(-.5);
//                x++;
//            }
            //motor1.setPower(0);
            if (((1000*colors.red) > 4.5) && (1000*colors.red) > 1000*colors.blue) {
                motor1.setPower(.5);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    motor1.setPower(0);
                    servo0.setPosition(174.0/180.0);
                    stop();
                }
            } else {
                motor1.setPower(-.5);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    motor1.setPower(0);
                    servo0.setPosition(174.0/180.0);
                    stop();
                }
            }
//                motor1.setPower(.5);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                finally {
//                    motor1.setPower(0);
//                    stop();
//                }
//            } else {
//                motor1.setPower(.5);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                motor1.setPower(-.5);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } finally {
//                    motor1.setPower(0);
//                    stop();
//                }
//            }
            //drop.Drop(1000 * colors.red);

        }

       // driveTrain.moveSeconds(350);



//        grabber.reset();
    }
}