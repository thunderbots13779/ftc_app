/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 *Created by Pramodh on 10/27/2017.
 */
@TeleOp
public class Drive extends LinearOpMode {
    private DcMotor motor0;
    private DcMotor motor1;
    private Servo servo0;
    private Servo servo1;
    private Servo servo2;
    private boolean rbOn = false;
    private int increment = 1;

    @Override
    public void runOpMode() {
        motor0 = hardwareMap.get(DcMotor.class, "motor0");
        motor1 = hardwareMap.get(DcMotor.class, "motor1");
        servo0 = hardwareMap.get(Servo.class, "servo0");
        servo1 = hardwareMap.get(Servo.class, "servo1");
        servo2 = hardwareMap.get(Servo.class, "servo2");



        //sends tests data to dc phone
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        //Wait for the game to start (driver presses PLAY)
        waitForStart();

        //run until the end of the match (driver presses STOP)
        /*
        while (opModeIsActive()) {
            telemetry.addData("Status", "Initialized");
            telemetry.update();
        }
        */
        double leftMotorPower = 0;
        double rightMotorPower = 0;
        while (opModeIsActive()) {
            leftMotorPower = -this.gamepad1.left_stick_y;
            motor0.setPower(leftMotorPower);

            rightMotorPower = this.gamepad1.right_stick_y;
            motor1.setPower(rightMotorPower);

            //check to see if we need to move the servo.
            if (gamepad1.right_bumper || gamepad2.right_bumper)
                rbOn = !rbOn;

            if ((gamepad1.left_bumper || gamepad2.left_bumper)
                    && rbOn) {
                servo2.setPosition(1);
            } else if ((gamepad1.left_trigger != 0 || gamepad2.left_trigger != 0)
                    && rbOn) {
                servo2.setPosition(0);

            } else {
                servo2.setPosition(.5);
            }

            if (increment >= 0 && increment <=4) {
                if ((gamepad1.left_bumper || gamepad2.left_bumper)
                        && !rbOn) {
                    servo2.setPosition(1);
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    servo2.setPosition(0.5);
                    increment++;

                } else if ((gamepad1.left_trigger != 0 || gamepad2.left_trigger != 0)
                        && !rbOn) {
                    servo2.setPosition(0);
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    servo2.setPosition(0.5);
                    increment--;
                }
            }

        }


        telemetry.addData("Servo Position", servo0.getPosition());
        telemetry.addData("Left Power", leftMotorPower);
        telemetry.addData("Right Power", rightMotorPower);
        telemetry.addData("Motor Power", motor0.getPower());
        telemetry.addData("Motor Power1", motor1.getPower());
        telemetry.addData("Status", "Running");
        telemetry.update();
        }
}