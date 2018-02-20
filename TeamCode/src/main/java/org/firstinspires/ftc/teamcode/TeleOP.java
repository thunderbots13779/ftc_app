package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Actions.*;

@TeleOp
public class TeleOP extends Driver{

    State state = State.START;
    Raiser raiser =  new Raiser();
    FlyWheels flyWheels = new FlyWheels();
    Move move = new Move();


    Action[] actions = {
//            new FlyWheels(),

    };

    @Override
    public void init() {
        super.init();


    }

    @Override
    public void start() {

        super.start();


    }

    @Override
    public void loop() {
        flyWheels.loop();
        raiser.loop();
//        flip.loop();
        move.loop();


    }


}
