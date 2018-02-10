package org.firstinspires.ftc.teamcode;

public class Timed implements Action {

    public long initialTime;
    public long duration;

    public Timed(long duration) {

        this.duration = duration;

    }

    public void start() {

        initialTime = System.currentTimeMillis();

    }

    public void loop() {

    }

    public void end() {

    }

    public boolean check() {
        
        if (System.currentTimeMillis() > initialTime + duration) {
            return false;
        } else {
            return true;
        }

    }

}
