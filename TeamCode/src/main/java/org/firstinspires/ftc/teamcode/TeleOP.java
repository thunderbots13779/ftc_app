package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Actions.*;
import org.firstinspires.ftc.teamcode.Actions.TeleOP.Flip;
import org.firstinspires.ftc.teamcode.Actions.TeleOP.FlyWheels;
import org.firstinspires.ftc.teamcode.Actions.TeleOP.Move;
import org.firstinspires.ftc.teamcode.Actions.TeleOP.Raiser;
import org.firstinspires.ftc.teamcode.Actions.TeleOP.Rotate;

@TeleOp
public class TeleOP extends Driver{

    Raiser raiser =  new Raiser();
    FlyWheels flyWheels = new FlyWheels();
    Move move = new Move();
    Rotate rotate = new Rotate();
    Flip flip = new Flip();

    @Override
    public void init() {
        super.init();


    }

    @Override
    public void start() {
        raiser.start();
        flyWheels.start();
        move.start();
        rotate.start();
        flip.start();
    }

    @Override
    public void loop() {
        raiser.loop();
        flyWheels.loop();
        move.loop();
        rotate.loop();
        flip.loop();
    }


}
