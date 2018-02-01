package org.firstinspires.ftc.teamcode;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/**
 * Created by pramo on 1/2/2018.
 */

public class Accelerometer extends Activity implements SensorEventListener {
    private final SensorManager mSensorManager;
    private final Sensor mAccelerometer;
    private final Sensor mGyroscope;
    public  static float aY = 0;
    public  static float aX = 0;
    public  static float aZ = 0;
    public float gY = 0;
    public float gX = 0;
    public float gZ = 0;
    SensorTest test = new SensorTest();

    public Accelerometer() {
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mGyroscope = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
    }

    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, mGyroscope, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    public void onAccuracyChanged(Sensor hi, int x) {

    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        String sensorName = sensorEvent.sensor.getName();
        aY = sensorEvent.values[0];
        aX = sensorEvent.values[1];
        aZ = sensorEvent.values[2];
        test.runOpMode();
//        Log.d(sensorName + ": X: " + sensorEvent.values[0] + "; Y: " + sensorEvent.values[1] + "; Z: " + sensorEvent.values[2] + ";");
    }

    public Sensor getmAccelerometer(){
        return mAccelerometer;
    }

    public float getaX(){
        return aX;
    }

    public float getaY(){
        return aY;
    }

    public float getaZ(){
        return aZ;
    }
}
