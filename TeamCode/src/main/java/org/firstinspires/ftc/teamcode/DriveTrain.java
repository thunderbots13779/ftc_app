package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;

import java.util.Timer;
import java.util.TimerTask;

public class DriveTrain {

    BNO055IMU imu;

    public Orientation angles;
    public Acceleration gravity;

    public double angle;

    private DcMotor motorLeft, motorRight, motorMiddle;
    private int motorLeftDirection = 1;
    private int motorRightDirection = -1;

    public Timer timer;
    public TimerTask task;

    public DriveTrain(DcMotor motor0, DcMotor motor1, DcMotor motor3, HardwareMap hardwareMap) {

        this.motorLeft = motor0;
        this.motorRight = motor1;
        this.motorMiddle = motor3;

        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit           = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit           = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.calibrationDataFile = "BNO055IMUCalibration.json"; // see the calibration sample opmode
        parameters.loggingEnabled      = true;
        parameters.loggingTag          = "IMU";
        parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();

        imu = hardwareMap.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);

        imu.startAccelerationIntegration(new Position(), new Velocity(), 1000);

        motorLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        startUpdates();

    }

    public void turnAbsolute(float angle) {

        float marginOfError = 12;

        float right = angle - marginOfError;
        float left = angle + marginOfError;

        while (angles == null) {

        }

        float multiplier = angle / Math.abs(angle);

        while (!(angles.firstAngle < left && angles.firstAngle > right)) {

            motorLeft.setPower(-0.35f * multiplier);
            motorRight.setPower(-0.35f * multiplier);
        }

        motorLeft.setPower(0);
        motorRight.setPower(0);

    }

    public void turnRelative(float angle) {
        float initialAngle = angles.firstAngle;

    }

    public void startUpdates() {
        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                angles   = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1);
    }

    public void stopUpdates() {
        timer.cancel();
    }

}
