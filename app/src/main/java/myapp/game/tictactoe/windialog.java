package myapp.game.tictactoe;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;



public class windialog extends Dialog {

    private final String message;
    private final Ingame ingame;

    public windialog(@NonNull Context context, String message, Ingame ingame) {
        super(context);
        this.message=message;
        this.ingame=ingame;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.win_dialouge_layout);

        final TextView messagetext = findViewById(R.id.messagetxt);
        final Button startagain = findViewById(R.id.startagainbtn);

        messagetext.setText(message);

        startagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
