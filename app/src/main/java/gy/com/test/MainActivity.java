package gy.com.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.eclipse.paho.android.service.MqttService;

import gy.com.test.service.MQTTService;

public class MainActivity extends AppCompatActivity {

    TextView gogogoggo;
    Button btn_click;
    LinearLayout parent;

    Button sendMessage;

    private int x=20;
    private int y=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gogogoggo = findViewById(R.id.gogogoggo);
        btn_click = findViewById(R.id.btn_click);
        parent = findViewById(R.id.parent);
        sendMessage = findViewById(R.id.sendMessage);

        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                parent.scrollTo(x,y);

                parent.scrollBy(x,y);
            }
        });

        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.i("cccccccccccc",MQTTServiceA.isConnect()+"");
//                if(!MQTTServiceA.isConnect()){
//                    MQTTServiceA.connect();
//                }
//                MQTTServiceA.publish("0");
              MQTTService.publish("MQTT");
            }
        });

        Intent intent = new Intent(this,MQTTService.class);
        startService(intent);
//        startService(new Intent(this, MQTTServiceA.class));
    }
}
