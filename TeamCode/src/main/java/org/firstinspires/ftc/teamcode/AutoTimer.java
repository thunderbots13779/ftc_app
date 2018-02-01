package org.firstinspires.ftc.teamcode;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by Pramodh on 1/31/18.
 */

public class AutoTimer extends Autonomous_Code{

    public String getTime() {
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());

        return currentDateTimeString;
    }

}
