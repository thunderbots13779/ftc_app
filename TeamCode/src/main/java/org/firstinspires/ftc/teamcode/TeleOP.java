package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.TeleOP_Actions.Flippidoo;
import org.firstinspires.ftc.teamcode.TeleOP_Actions.FlyWheels;
import org.firstinspires.ftc.teamcode.TeleOP_Actions.Move;
import org.firstinspires.ftc.teamcode.TeleOP_Actions.Raiser;

@TeleOp
public class TeleOP extends Driver{

    State state = State.START;
    Raiser raiser =  new Raiser();
    FlyWheels flyWheels = new FlyWheels();
    Flippidoo flip = new Flippidoo();
    Move move = new Move();

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
//        flip.loop();
        move.loop();

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
