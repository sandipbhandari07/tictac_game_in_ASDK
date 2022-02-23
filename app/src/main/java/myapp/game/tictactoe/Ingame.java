package myapp.game.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Ingame extends AppCompatActivity {

    private final List<int[]> combinationlist = new ArrayList<>();

    private int[] boxpositions = {0,0,0,0,0,0,0,0,0};

    private int playerturn = 1;

    private int totalselectedboxes = 1;

    private LinearLayout playeronelayout , playertwolayout ;

    private TextView playeronename,playertwoname;

    private ImageView image1,image2,image3,image4,image5,image6,image7,image8,image9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingame);

        playeronename = findViewById(R.id.player_onename);
        playertwoname = findViewById(R.id.player_twoname);

        playeronelayout = findViewById(R.id.playeronelayout);
        playertwolayout = findViewById(R.id.playertwolayout);

        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        image5 = findViewById(R.id.image5);
        image6 = findViewById(R.id.image6);
        image7 = findViewById(R.id.image7);
        image8 = findViewById(R.id.image8);
        image9 = findViewById(R.id.image9);


        combinationlist.add(new int[]{0,1,2});
        combinationlist.add(new int[]{3,4,5});
        combinationlist.add(new int[]{6,7,8});
        combinationlist.add(new int[]{0,3,6});
        combinationlist.add(new int[]{1,4,7});
        combinationlist.add(new int[]{2,5,8});
        combinationlist.add(new int[]{2,4,6});
        combinationlist.add(new int[]{0,4,8});

        final String getplayeronename = getIntent().getStringExtra("playerone");
        final String getplayertwoname = getIntent().getStringExtra("playertwo");

        playeronename.setText(getplayeronename);
        playertwoname.setText(getplayertwoname);


        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isBoxselectable(0)){

                }
            }
        });
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxselectable(1)){

                }

            }
        });
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxselectable(2)){

                }

            }
        });
        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isBoxselectable(3)){

                }
            }
        });
        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isBoxselectable(4)){

                }
            }
        });
        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isBoxselectable(5)){

                }
            }
        });
        image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isBoxselectable(6)){

                }
            }
        });
        image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isBoxselectable(7)){

                }
            }
        });
        image9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isBoxselectable(8)){

                }
            }
        });
    }

    private void performaction (ImageView imageView, int selectedboxposition){
        boxpositions[selectedboxposition] = playerturn;
        if (playerturn == 1){
            imageView.setImageResource(R.drawable.x);
            if ()
        }
    }



    private boolean isBoxselectable(int boxPosition){
        boolean response = false;
        if (boxpositions[boxPosition] == 0 ){
            response = true;
        }
        return response;
    }
}