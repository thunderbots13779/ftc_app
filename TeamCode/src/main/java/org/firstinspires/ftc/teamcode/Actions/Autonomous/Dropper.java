package org.firstinspires.ftc.teamcode.Actions.Autonomous;

import org.firstinspires.ftc.teamcode.Actions.Action;
import org.firstinspires.ftc.teamcode.Actions.Autonomous.Servos.Drop;
import org.firstinspires.ftc.teamcode.Actions.Autonomous.Servos.MoveServo;
import org.firstinspires.ftc.teamcode.Actions.Autonomous.Servos.SwivelLeft;
import org.firstinspires.ftc.teamcode.Actions.Autonomous.Servos.SwivelRight;
import org.firstinspires.ftc.teamcode.Actions.Autonomous.Servos.Up;
import org.firstinspires.ftc.teamcode.Robot;

public class Dropper implements Action {

    boolean expectedColor;
    ColorCheck colorCheck = new ColorCheck(expectedColor);

    public Dropper(boolean expectedColor) {
        this.expectedColor = expectedColor;
    }

    public void start() {
        new Drop().start();
    }
    public void loop() {
        colorCheck.loop();
    }

    public void end() {
        colorCheck.end();
        if (Robot.correctColor) {
            new SwivelLeft().start();
        } else  {
            new SwivelRight().start();
        }
        new Up().start();
    }

    public boolean check() {
        return false;
    }
}
