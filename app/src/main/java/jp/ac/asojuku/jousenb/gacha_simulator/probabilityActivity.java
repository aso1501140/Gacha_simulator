package jp.ac.asojuku.jousenb.gacha_simulator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class probabilityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_probability);

        Button btn = (Button) findViewById(R.id.back);
        Button button = (Button) findViewById(R.id.Registration);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(probabilityActivity.this, dataActivity.class);
                startActivity(intent);
            }

        });

    }
}
