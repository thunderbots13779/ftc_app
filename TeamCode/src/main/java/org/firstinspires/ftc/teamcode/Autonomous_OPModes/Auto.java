package org.firstinspires.ftc.teamcode.Autonomous_OPModes;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;
import org.firstinspires.ftc.teamcode.Actions.Action;
import org.firstinspires.ftc.teamcode.Actions.Autonomous.Dropper;
import org.firstinspires.ftc.teamcode.Actions.Autonomous.RunUsingEncoder;
import org.firstinspires.ftc.teamcode.Actions.End;
import org.firstinspires.ftc.teamcode.Actions.RunToPosition;
import org.firstinspires.ftc.teamcode.Driver;
import org.firstinspires.ftc.teamcode.Robot;

@Autonomous
public class Auto extends Driver {

    public static final String TAG = "Vuforia VuMark Sample";

    OpenGLMatrix lastLocation = null;

    VuforiaLocalizer vuforia;

    VuforiaTrackable relicTemplate;

    RelicRecoveryVuMark usable = RelicRecoveryVuMark.UNKNOWN;

    State state = State.START;
    Robot.AllianceColor expectedColor = Robot.AllianceColor.RED;
    int i = 0;

    Action[] actions = {
            new Dropper(expectedColor),
            new End()
    };

    @Override
    public void init() {
        super.init();
        Robot.allianceColor = Robot.AllianceColor.RED;
        initializeVuforia();
    }

    @Override
    public void init_loop() {

        RelicRecoveryVuMark vuMark = RelicRecoveryVuMark.from(relicTemplate);
        if (vuMark != RelicRecoveryVuMark.UNKNOWN) {

            usable = RelicRecoveryVuMark.from(relicTemplate);

        }
    }

    @Override
    public void loop() {
        String message = "";
        if (usable == RelicRecoveryVuMark.UNKNOWN) {
            message = "UNKNOWN";
        } else if (usable == RelicRecoveryVuMark.LEFT) {
            message = "LEFT";
        } else if (usable == RelicRecoveryVuMark.RIGHT) {
            message = "RIGHT";
        } else {
            message = "CENTER";
        }
        telemetry.addData("VuMark", message);
        telemetry.addData("Test", usable);
        telemetry.update();
        switch (state) {
            case START:
                state = State.LOOP;
                actions[i].start();
                break;
            case LOOP:
                if (actions[i].check()) {
                    actions[i].loop();
                    break;
                } else {
                    state = State.STOP;
                    break;
                }
            case STOP:
                actions[i].end();
                i++;
                state = State.START;
                break;
        }
    }

    public void initializeVuforia() {

        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);

        parameters.vuforiaLicenseKey = "AaccPCv/////AAAAGUHMoe4QMEQnovLFMgFScJEVe3Zia3YYTEl3U1EXcd1XRE7aV9ONZFR91dfsSQ4tnOBYK10+SvF1S1LEGkjeQWDBFvKci3ki3K7E440/ZRB0YGIuxYUVrp9AZ0PtSExOtE6bFXyksrCPcD6IV8rHvNJYwWbE/LUqrCj18TtN0QbWBXfVSmXmRnfVWBDOA8O8v7kCZzeBm328KlYb105Uo48MICRipR9/oua0rJ1QNIY+ytwxHabLCZgNlMr64+In/xB3aCtnHjTC8ClSxirmschtzlq+up6CzYkahlX45SnV6mGqJ345uPzUnJzAr9Z6QDEd17veQPMP3zLheBDWM3l/590e+i5qFLvjVrcu/Njs\n";


        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
        this.vuforia = ClassFactory.createVuforiaLocalizer(parameters);

        VuforiaTrackables relicTrackables = this.vuforia.loadTrackablesFromAsset("RelicVuMark");
        relicTemplate = relicTrackables.get(0);
        relicTemplate.setName("relicVuMarkTemplate");

        telemetry.addData(">", "Press Play to start");
        telemetry.update();

        relicTrackables.activate();

    }

    String format(OpenGLMatrix transformationMatrix) {
        return (transformationMatrix != null) ? transformationMatrix.formatAsTransform() : "null";
    }
}
