package jp.ac.asojuku.jousenb.gacha_simulator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_list);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Button buttonAction = (Button) findViewById(R.id.button1);

        buttonAction.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(GameListActivity.this,gacha_activity.class);
                startActivity(intent);
            }
        });
        Button buttonAction2 = (Button) findViewById(R.id.button2);

        buttonAction.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(GameListActivity.this,gacha_activity.class);
                startActivity(intent);
            }
        });
        Button buttonAction3 = (Button) findViewById(R.id.button3);

        buttonAction.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(GameListActivity.this,gacha_activity.class);
                startActivity(intent);
            }
        });
        Button buttonActio4 = (Button) findViewById(R.id.button4);

        buttonAction.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(GameListActivity.this,gacha_activity.class);
                startActivity(intent);
            }
        });
    }
}
//やあ