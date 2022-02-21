package myapp.game.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        final EditText playerone = findViewById(R.id.playerone);
        final EditText playertwo = findViewById(R.id.playertwo);
        final Button start=findViewById(R.id.start);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String getplayeroneName = playerone.getText().toString();
                final String getplayertwoName = playertwo.getText().toString();
                if (getplayeroneName.isEmpty() || getplayertwoName.isEmpty()){
                    Toast.makeText(MainActivity.this, "please enter player name", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(MainActivity.this,Ingame.class);
                    intent.putExtra("playerone",getplayeroneName);
                    intent.putExtra("playerTwo",getplayertwoName);
                    startActivity(intent);
                }

            }
        });
    }
}