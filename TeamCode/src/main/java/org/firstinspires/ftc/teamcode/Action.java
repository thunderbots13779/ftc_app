package org.firstinspires.ftc.teamcode;

public interface Action {

    public void initialize();
    public void start();
    public void loop();
    public boolean check();
    public void end();

}
