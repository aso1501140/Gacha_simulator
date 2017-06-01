package jp.ac.asojuku.jousenb.gacha_simulator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sendButton = (Button)findViewById(R.id.button);
        sendButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, dataActivity.class);
                startActivity(intent);
            }
        });

        Button sendButton2 = (Button)findViewById(R.id.button2);
        sendButton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, gacha_activity.class);
                startActivity(intent);
            }
        });
    }
}
