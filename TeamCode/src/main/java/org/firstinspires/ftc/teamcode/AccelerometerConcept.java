//package org.firstinspires.ftc.teamcode;
//
//import android.content.Context;
//import android.hardware.Sensor;
//import android.hardware.SensorEvent;
//import android.hardware.SensorEventListener;
//import android.hardware.SensorManager;
//
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//
///**
// * Created by pramo on 12/9/2017.
// */
//
//@TeleOp
//public class AccelerometerConcept extends LinearOpMode implements SensorEventListener {
//
//    private SensorManager senSensorManager;
//    private Sensor senAccelerometer;
//
//    @Override
//    public void runOpMode() throws InterruptedException {
//
//        telemetry.addData("Status", "Initialized");
//        telemetry.update();
//
//        senSensorManager = (SensorManager)this.getSystemService(Context.SENSOR_SERVICE);
//
//        while(opModeIsActive()) {
//            telemetry.addData("Accelerometer X", "Initialized");
//            telemetry.update();
//        }
//    }
//
//    @Override
//    public void onSensorChanged(SensorEvent event) {
//
//    }
//
//    @Override
//    public void onAccuracyChanged(Sensor sensor, int accuracy) {
//
//    }
//}
