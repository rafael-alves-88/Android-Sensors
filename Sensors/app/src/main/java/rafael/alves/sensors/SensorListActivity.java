package rafael.alves.sensors;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class SensorListActivity extends BaseDetailsActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_list);

        ListView lvSensors = (ListView) findViewById(R.id.lvSensors);
        lvSensors.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getSensors()));
    }

    private List<Sensor> getSensors() {
        SensorManager sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);

        return sensorManager.getSensorList(Sensor.TYPE_ALL);
    }
}
