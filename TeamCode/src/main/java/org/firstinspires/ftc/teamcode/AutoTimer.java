package org.firstinspires.ftc.teamcode;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by Pramodh on 1/31/18.
 */

public class AutoTimer{

    long initialTime;
    long endTime;

    public AutoTimer(long duration) {
        initialTime = System.currentTimeMillis();
        this.endTime = initialTime + duration;
    }

    public boolean checkTime() {
        long currentTime = System.currentTimeMillis();
        if (currentTime > endTime) {
            return true;
        }
        return false;
    }

}
