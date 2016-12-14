package rafael.alves.sensors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setButtonListeners();
    }

    private void setButtonListeners() {
        findViewById(R.id.btnSensorList).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showActivity(SensorListActivity.class);
            }
        });

        findViewById(R.id.btnLightSensor).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showActivity(LightSensorActivity.class);
            }
        });

        findViewById(R.id.btnProxSensor).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showActivity(ProximitySensorActivity.class);
            }
        });

        findViewById(R.id.btnAccelSensor).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showActivity(AccelerometerSensorActivity.class);
            }
        });
    }

    private void showActivity(Class<?> activity) {
        Intent intent = new Intent(MainActivity.this, activity);
        startActivity(intent);
    }
}
