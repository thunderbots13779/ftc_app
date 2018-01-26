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
public class RedBottom extends LinearOpMode{

    private DcMotor motor0;
    private DcMotor motor1;
    private DcMotor motor2;
    private DcMotor motor3;
    private Servo servo0;
    private Servo servo1;
    private Servo servo2;
    private Servo servo3;
    private NormalizedColorSensor colorSensor;
    private TankDriveTrain driveTrain;
    private Grabber grabber;
    private VerticalLiftMotor liftMotor;
    private Autonomous_Code Auto;
    private VuMarkIdentification vuMarkIdentification;

    @Override
    public void runOpMode() {

        initialization();
        Auto = new Autonomous_Code(motor0, motor1, motor2, motor3, servo0, servo1, servo2, servo3, colorSensor, driveTrain, grabber, liftMotor, vuMarkIdentification);

        //Wait for the game to start (driver presses PLAY)
        waitForStart();

        if (opModeIsActive()) {
            //run until the end of the match (driver presses STOP)
            Auto.auto("blue");
            telemetry.addData("column", vuMarkIdentification.identify());
            telemetry.update();
            Auto.bottomRed();
        }
    }

    public void initialization() {
        //HARDWARE MAPS
        motor0 = hardwareMap.get(DcMotor.class, "motor0");
        motor1 = hardwareMap.get(DcMotor.class, "motor1");
        motor2 = hardwareMap.get(DcMotor.class, "motor2");
        motor3 = hardwareMap.get(DcMotor.class, "motor3");
        servo0 = hardwareMap.get(Servo.class, "servo0");
        servo1 = hardwareMap.get(Servo.class, "servo1");
        servo2 = hardwareMap.get(Servo.class, "servo2");
        servo3 = hardwareMap.get(Servo.class, "servo3");
        colorSensor = hardwareMap.get(NormalizedColorSensor.class, "colorSensor");

        //INITIALIZATION
        driveTrain = new TankDriveTrain(motor0, motor1, motor3);
        grabber = new Grabber(servo1, servo2);
        liftMotor = new VerticalLiftMotor(motor2);
        vuMarkIdentification = new VuMarkIdentification(hardwareMap, telemetry);
    }


}
