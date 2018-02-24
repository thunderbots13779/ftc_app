package org.firstinspires.ftc.teamcode.Actions.Autonomous;

import android.util.Log;

import org.firstinspires.ftc.teamcode.Actions.Action;

public class Timed implements Action {

    public long initialTime;
    public long duration;
    int c = 1;

    public Timed(long duration) {

        this.duration = duration;

    }

    public void start() {

        initialTime = System.currentTimeMillis();
        Log.d("THUNDERBOTS: FIRST", ("" + System.currentTimeMillis()));

    }

    public void loop() {

    }

    public void end() {

    }

    public boolean check() {

        Log.d("THUNDERBOTS: count", ("" + c));
        c++;

        Log.d("THUNDERBOTS: remaining", ("" + ((initialTime + duration) - System.currentTimeMillis())));
        Log.d("THUNDERBOTS: endTime", ("" + (initialTime + duration)));
        Log.d("THUNDERBOTS: initial", ("" + initialTime));
        Log.d("THUNDERBOTS: cT", ("" + System.currentTimeMillis()));
        
        if (System.currentTimeMillis() > initialTime + duration) {
            return false;
        } else {
            return true;
        }

    }

}
