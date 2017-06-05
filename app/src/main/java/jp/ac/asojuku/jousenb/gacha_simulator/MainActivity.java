package jp.ac.asojuku.jousenb.gacha_simulator;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by tatsuya hayashi on 2017/05/26
 */

public class MainActivity extends AppCompatActivity {

    short


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Button buttonAction = (Button) findViewById(R.id.register);

        buttonAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,
                        GameListActivity.class);
                startActivity(intent);
            }
        });
    }
}


