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

/**
 * Created by pramo on 1/20/2018.
 */

public class AutoDriveTrain {

    // The IMU sensor object
    BNO055IMU imu;

    // State used for updating telemetry
    Orientation angles;
    Acceleration gravity;

    private DcMotor motorLeft, motorRight, motorMiddle;
    private double posOffset = .05;
    private double angleOffset = 1;
    private double X = 0;
    private double Y = 0;
    private double degree = 0;
    private int column = 2;

    public AutoDriveTrain(DcMotor motor0, DcMotor motor1, DcMotor motor3, HardwareMap hardwareMap) {

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

    }

    public void update() {
        angles   = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
        gravity  = imu.getGravity();
    }

    public void moveAuto(float x, float y) {
        while (X > (x + posOffset) && X < (x - posOffset)) {
            if (x > 0) {
                motorMiddle.setPower(.5);
            } else if(x < 0) {
                motorMiddle.setPower(-.5);
            }
        }
        motorMiddle.setPower(0);
        while (Y > (y + posOffset) && Y < (y - posOffset)) {
            if (y > 0) {
                motorRight.setPower(.5);
                motorLeft.setPower(-.4);
            } else if (y < 0) {
                motorRight.setPower(-.5);
                motorLeft.setPower(.4);
            }
        }
        motorRight.setPower(0);
        motorLeft.setPower(0);
    }

    public void posColumn() {
        if (column == 3) {
            moveAuto(1, 0);
        } else if (column == 1) {
            moveAuto(-1, 0);
        }
    }

    public void turnAuto(float angle) {
        while (degree > (angle + angleOffset) && degree < (angle - angleOffset)) {
            if (angle > 0) {
                motorMiddle.setPower(.5);
                motorLeft.setPower(-.4);
            } else if (angle < 0) {
                motorMiddle.setPower(-.5);
                motorRight.setPower(.5);
            }
        }
        motorMiddle.setPower(0);
        motorRight.setPower(0);
        motorLeft.setPower(0);
    }
}
