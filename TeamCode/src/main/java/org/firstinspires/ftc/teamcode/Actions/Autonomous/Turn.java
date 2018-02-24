package org.firstinspires.ftc.teamcode.Actions.Autonomous;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Actions.Action;
import org.firstinspires.ftc.teamcode.Robot;

public class Turn implements Action {

    int marginOfError = 10;
    float angle;

    public Turn(float angle) {

        this.angle = angle;

    }
    public void start() {
        Robot.motor_right.setPower(1);
        Robot.motor_left.setPower(-1);
    }

    public void loop() {

    }

    public void end() {
        Robot.motor_right.setPower(0);
        Robot.motor_left.setPower(0);
    }

    public boolean check() {

        if ((angle + marginOfError) > Robot.angles.firstAngle && (angle - marginOfError) > Robot.angles.firstAngle) {
            return false;
        } else {
            return true;
        }

    }

}
