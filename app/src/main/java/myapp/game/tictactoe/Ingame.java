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
            if (checkplayerwin()){

               windialog Windialog = new windialog(Ingame.this, playeronename.getText().toString()+"has won the match",Ingame.this);
              Windialog.setCancelable(false);
               Windialog.show();
            }
            else if(totalselectedboxes == 9){
                windialog Windialog = new windialog(Ingame.this, "It is draw!",Ingame.this);
                Windialog.setCancelable(false);
                Windialog.show();

            }
            else{
                changeplayerturn(2);
                totalselectedboxes++;

            }
        }
        else{
            imageView.setImageResource(R.drawable.o);

            if (checkplayerwin()){
                windialog Windialog = new windialog(Ingame.this, playertwoname.getText().toString()+"has won the match",Ingame.this);
                Windialog.setCancelable(false);
                Windialog.show();

            }
            else if(selectedboxposition == 9){
                windialog Windialog = new windialog(Ingame.this, "It is draw!",Ingame.this);
                Windialog.setCancelable(false);
                Windialog.show();

            }

            else{
                changeplayerturn(1);

                totalselectedboxes++;
            }
        }
    }

    private void changeplayerturn(int currentplayerturn){
        playerturn = currentplayerturn;
        if (playerturn == 1){
            playeronelayout.setBackgroundResource(R.drawable.round_black_blue_border);
            playertwolayout.setBackgroundResource(R.drawable.round_black_border);
        }
        else {
            playertwolayout.setBackgroundResource(R.drawable.round_black_blue_border);
            playeronelayout.setBackgroundResource(R.drawable.round_black_border);

        }
    }

    private boolean checkplayerwin(){
        boolean response = false;
        for (int i=0;i<combinationlist.size();i++){
            final int[] combination = combinationlist.get(i);

            if (boxpositions[combination[0]]== playerturn && boxpositions[combination[1]]==playerturn && boxpositions[combination[2]]== playerturn){
                response = true;
            }
        }
        return response;
    }


    private boolean isBoxselectable(int boxPosition){
        boolean response = false;
        if (boxpositions[boxPosition] == 0 ){
            response = true;
        }
        return response;
    }
    public void restartMatch(){
        boxpositions = new int[]{0,0,0,0,0,0,0,0,0};

        playerturn = 1;
        totalselectedboxes = 1;
        image1.setImageResource(R.drawable.trans_backg);
        image2.setImageResource(R.drawable.trans_backg);
        image3.setImageResource(R.drawable.trans_backg);
        image4.setImageResource(R.drawable.trans_backg);
        image5.setImageResource(R.drawable.trans_backg);
        image6.setImageResource(R.drawable.trans_backg);
        image7.setImageResource(R.drawable.trans_backg);
        image8.setImageResource(R.drawable.trans_backg);
        image9.setImageResource(R.drawable.trans_backg);

    }
}