package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

/**
 * Created by pramo on 12/14/2017.
 */

@Autonomous
public class AutoTest extends LinearOpMode{

    private DcMotor motor0;
    private DcMotor motor1;
    private DcMotor motor2;
    private DcMotor motor3;
    private Servo servo0;
    private Servo servo1;
    private Servo servo2;
    private NormalizedColorSensor colorSensor;
    private TankDriveTrain driveTrain;
    private Grabber grabber;
    private VerticalLiftMotor liftMotor;
    private Autonomous_Code Auto;
    private VuforiaLocalizer vuforia;
    private int column;

    @Override
    public void runOpMode() {

        initialization();
        Auto = new Autonomous_Code(motor0, motor1, motor2, motor3, servo0, servo1, servo2, colorSensor, driveTrain, grabber, liftMotor);

        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);

        parameters.vuforiaLicenseKey = "AaccPCv/////AAAAGUHMoe4QMEQnovLFMgFScJEVe3Zia3YYTEl3U1EXcd1XRE7aV9ONZFR91dfsSQ4tnOBYK10+SvF1S1LEGkjeQWDBFvKci3ki3K7E440/ZRB0YGIuxYUVrp9AZ0PtSExOtE6bFXyksrCPcD6IV8rHvNJYwWbE/LUqrCj18TtN0QbWBXfVSmXmRnfVWBDOA8O8v7kCZzeBm328KlYb105Uo48MICRipR9/oua0rJ1QNIY+ytwxHabLCZgNlMr64+In/xB3aCtnHjTC8ClSxirmschtzlq+up6CzYkahlX45SnV6mGqJ345uPzUnJzAr9Z6QDEd17veQPMP3zLheBDWM3l/590e+i5qFLvjVrcu/Njs\n";

        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
        this.vuforia = ClassFactory.createVuforiaLocalizer(parameters);

        VuforiaTrackables relicTrackables = this.vuforia.loadTrackablesFromAsset("RelicVuMark");
        VuforiaTrackable relicTemplate = relicTrackables.get(0);
        relicTemplate.setName("relicVuMarkTemplate"); // can help in debugging; otherwise not necessary

        //Wait for the game to start (driver presses PLAY)
        waitForStart();

        jewelKnockoff();

        relicTrackables.activate();

        //run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            //Auto.auto("back", "red");
            //stop();
            RelicRecoveryVuMark vuMark = RelicRecoveryVuMark.from(relicTemplate);
            if (vuMark != RelicRecoveryVuMark.UNKNOWN) {

                telemetry.addData("VuMark", "%s visible", vuMark);

                OpenGLMatrix pose = ((VuforiaTrackableDefaultListener)relicTemplate.getListener()).getPose();
                telemetry.addData("Pose", format(pose));

                if (pose != null) {
                    VectorF trans = pose.getTranslation();
                    Orientation rot = Orientation.getOrientation(pose, AxesReference.EXTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES);

                    // Extract the X, Y, and Z components of the offset of the target relative to the robot
                    double tX = trans.get(0);
                    double tY = trans.get(1);
                    double tZ = trans.get(2);

                    // Extract the rotational components of the target relative to the robot
                    double rX = rot.firstAngle;
                    double rY = rot.secondAngle;
                    double rZ = rot.thirdAngle;
                }
            }
            else {
                telemetry.addData("VuMark", "not visible");
            }

            telemetry.update();

        }
    }

    public void initialization() {
        //HARDWARE MAPS
        motor0 = hardwareMap.get(DcMotor.class, "motor0");
        motor1 = hardwareMap.get(DcMotor.class, "motor1");
        motor2 = hardwareMap.get(DcMotor.class, "motor2");
        // motor3 = hardwareMap.get(DcMotor.class, "motor3");
        servo0 = hardwareMap.get(Servo.class, "servo0");
        servo1 = hardwareMap.get(Servo.class, "servo1");
        servo2 = hardwareMap.get(Servo.class, "servo2");
        colorSensor = hardwareMap.get(NormalizedColorSensor.class, "colorSensor");

        //INITIALIZATION
        driveTrain = new TankDriveTrain(motor0, motor1);
        grabber = new Grabber(servo1, servo2);
        liftMotor = new VerticalLiftMotor(motor2);
    }

    public void pictograph() {

    }

    public void jewelKnockoff() {
        boolean redVisible = color();
        telemetry.addData("red? ", redVisible);
        servo0.setPosition(77.0/180.0);
        try {
            Thread.sleep((long)1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (redVisible) {
            driveTrain.moveSeconds((long)1, 1);
        } else {
            motor0.setPower(-1);
            motor1.setPower(.9);
            try {
                Thread.sleep((long)100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            motor0.setPower(0);
            motor1.setPower(0);
        }
        try {
            Thread.sleep((long)200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        servo0.setPosition(174.0/180.0);
    }

    private boolean color() {
        int scale = 10000;
        double maxRed = 0;
        double maxBlue = 0;

        for (int i = 0; i < 10; i++) {
            NormalizedRGBA colors = colorSensor.getNormalizedColors();

            double red = scale * colors.red;
            double blue = scale * colors.blue;
            if (red > maxRed)
                maxRed = red;
            if (blue > maxBlue)
                maxBlue = blue;
            try {
                Thread.sleep((long).1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        boolean redVisible = maxRed > maxBlue;

        return redVisible;
    }

    String format(OpenGLMatrix transformationMatrix) {
        return (transformationMatrix != null) ? transformationMatrix.formatAsTransform() : "null";
    }

}
