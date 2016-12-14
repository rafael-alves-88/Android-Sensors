package rafael.alves.sensors;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.OrientationEventListener;
import android.widget.TextView;

public class AccelerometerSensorActivity extends BaseDetailsActivity implements SensorEventListener {

    private TextView tvIsPortrait;
    private TextView tvXAxis;
    private TextView tvYAxis;
    private TextView tvZAxis;

    private OrientationEventListener mListener;
    private SensorManager mSensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer_sensor);

        tvIsPortrait = (TextView) findViewById(R.id.tvIsPortrait);
        tvXAxis = (TextView) findViewById(R.id.tvXAxis);
        tvYAxis = (TextView) findViewById(R.id.tvYAxis);
        tvZAxis = (TextView) findViewById(R.id.tvZAxis);

        addOrientationListener();
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mSensorManager.registerListener(this, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (mListener != null) {
            mListener.disable();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (mListener != null) {
            mListener.enable();
        }
    }

    private void addOrientationListener()
    {
        mListener = new OrientationEventListener(this, SensorManager.SENSOR_DELAY_UI)
        {
            public void onOrientationChanged(int orientation) {

                if ((orientation >= 230 && orientation <= 290) || (orientation >= 70 && orientation <= 90))
                {
                    tvIsPortrait.setText("NO");
                }
                else if (orientation == -1) {
                    //KEEP THE CURRENT STATE
                }
                else {
                    tvIsPortrait.setText("YES");
                }
            }
        };

        if(mListener.canDetectOrientation()) {
            mListener.enable();
        }
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            tvXAxis.setText(String.format("%f",sensorEvent.values[0]));
            tvYAxis.setText(String.format("%f",sensorEvent.values[1]));
            tvZAxis.setText(String.format("%f",sensorEvent.values[2]));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
