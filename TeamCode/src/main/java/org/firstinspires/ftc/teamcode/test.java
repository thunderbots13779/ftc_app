package org.firstinspires.ftc.teamcode;

/**
 * Created by pramo on 12/9/2017.
 */

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class test extends LinearOpMode {
    private DcMotor motor0;
    private DcMotor motor1;
    private Servo servo0;

    @Override
    public void runOpMode() {

        //HARDWARE MAPS
        motor0 = hardwareMap.get(DcMotor.class, "motor0");
        motor1 = hardwareMap.get(DcMotor.class, "motor1");
        servo0 = hardwareMap.get(Servo.class, "servo0");

        //INITIALIZATION
        TankDriveTrain driveTrain = new TankDriveTrain(motor0, motor1);
        Dropdown drop = new Dropdown(servo0);

        //sends tests data to dc phone
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        //Wait for the game to start (driver presses PLAY)
        waitForStart();

        drop.Drop(1000);
       // driveTrain.moveSeconds(350);



//        grabber.reset();
    }
}