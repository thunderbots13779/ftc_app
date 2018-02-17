package org.firstinspires.ftc.teamcode;

import android.text.method.HideReturnsTransformationMethod;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class TeleOP extends Driver{

    State state = State.START;
    Raiser raiser =  new Raiser();
    FlyWheels flyWheels = new FlyWheels();
    Flippidoo flip = new Flippidoo();

    Action[] actions = {
//            new FlyWheels(),

    };

    @Override
    public void init() {
        super.init();


    }

    @Override
    public void loop() {
        flyWheels.loop();
        raiser.loop();
        flip.loop();
//          flyWheels.loop();
//        Robot.motor_raiser.setTargetPosition(1600);
//        Robot.motor_raiser.setPower(1);
//        raiser.loop();
//        switch (state) {
//            case START:
//                state = State.LOOP;
//                for (Action a : actions) {
//                    a.start();
//                }
//                break;
//            case LOOP:
//                for (Action a : actions) {
//                    a.loop();
//                }
//                state = State.STOP;
//                break;
//            case STOP:
//                for (Action a : actions) {
//                    a.end();
//                }
//                state = State.START;
//                break;
//        }

    }


}
