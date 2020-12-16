package com.example.warcardgame.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.warcardgame.objects.GameManager;
import com.example.warcardgame.R;
import com.example.warcardgame.objects.MoveActivity;
import com.example.warcardgame.objects.RetrieveData;
import com.example.warcardgame.utils.MySoundUtils;

import java.util.Timer;
import java.util.TimerTask;

public class GameActivity extends Activity_Base {

    private static final long DELAY = 1000;
    public static final String EXTRA_KEY_GAME_PLAYER_NAME_ONE = "EXTRA_KEY_GAME_PLAYER_NAME_ONE";
    public static final String EXTRA_KEY_GAME_PLAYER_NAME_TWO = "EXTRA_KEY_GAME_PLAYER_NAME_TWO";
    private GameManager game = new GameManager();
    private RetrieveData retrieveData;
    private TextView game_LBL_score_one;
    private ImageView game_IMG_card_one;
    private TextView game_LBL_score_two;
    private ImageView game_IMG_card_two;
    private ImageView game_IMG_play_button;
    private ImageView game_IMG_background;
    private TextView game_LBL_round;
    private TextView game_LBL_boyName;
    private TextView game_LBL_girlName;
    private ProgressBar game_PRB_progressBar;
    private Timer carousalTimer;
    private boolean flag = false;
    private MySoundUtils mySound = new MySoundUtils(R.raw.snd_card_flip);
    private int progressStatus = 0;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        findView();

        glide(GameActivity.this,"img_background",game_IMG_background);
        glide(GameActivity.this, "img_deck", game_IMG_card_one);
        glide(GameActivity.this, "img_deck", game_IMG_card_two);

        String namePlayerOne = getIntent().getStringExtra(EXTRA_KEY_GAME_PLAYER_NAME_ONE);
        game_LBL_boyName.setText(namePlayerOne);

        String namePlayerTwo = getIntent().getStringExtra(EXTRA_KEY_GAME_PLAYER_NAME_TWO);
        game_LBL_girlName.setText(namePlayerTwo);

        game.initGame(namePlayerOne,namePlayerTwo);

        game_IMG_play_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame();
                flag = true;
                game_IMG_play_button.setClickable(false);
                glide(GameActivity.this, "img_timer", game_IMG_play_button);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(flag){
            startGame();
        }
    }

    @Override
    protected void onStop() {

        super.onStop();
        if(flag){
            stopGame();
        }

    }

    /**
     * This function start the game through play displayManagerActivity function that repeats every 1 seconds
     */
    private void startGame() {
        carousalTimer = new Timer();
        carousalTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        displayManagerActivity();

                    }
                });
            }
        }, 0L, DELAY);
    }

    /**
     * This function stop the game
     */
    private void stopGame() {
        carousalTimer.cancel();
    }

    /**
     * This function update all parameters of every step of the game on the GameActivity
     */
    private void displayManagerActivity(){
        retrieveData = game.gameStep();
        if(retrieveData.getWinnerPlayer() == null){
            mySound.playSound(this,false);
            progressBar();
            game_LBL_score_one.setText("" + retrieveData.getPlayer1().getScore());
            game_LBL_score_two.setText("" + retrieveData.getPlayer2().getScore());

            glide(GameActivity.this, retrieveData.getPlayer1ImgIconName(), game_IMG_card_one);
            glide(GameActivity.this, retrieveData.getPlayer2ImgIconName(), game_IMG_card_two);

        }else{
            Intent intent;
            if(retrieveData.getWinnerPlayer().getMoveActivity() == MoveActivity.WINNER ) {
                intent = moveBetweenActivity(GameActivity.this, WinnerActivity.class, retrieveData, MoveActivity.WINNER);
            }else{
                intent = moveBetweenActivity(GameActivity.this, DrawActivity.class, retrieveData, MoveActivity.DRAW);
            }
            onStop();
            startActivity(intent);
            closeActivity(GameActivity.this);
        }
    }

    private void findView(){
        game_LBL_score_one = findViewById(R.id.game_LBL_score_one);
        game_IMG_card_one = findViewById(R.id.game_IMG_card_one);
        game_LBL_score_two = findViewById(R.id.game_LBL_score_two);
        game_IMG_card_two = findViewById(R.id.game_IMG_card_two);
        game_IMG_play_button = findViewById(R.id.game_IMG_play_button);
        game_PRB_progressBar = findViewById(R.id.game_PRB_progressBar);
        game_LBL_round = findViewById(R.id.game_LBL_round);
        game_LBL_boyName = findViewById(R.id.game_LBL_boyName);
        game_LBL_girlName = findViewById(R.id.game_LBL_girlName);
        game_IMG_background = findViewById(R.id.game_IMG_background);
    }
    /**
     * This function update the progress bar and round text
     */
    private void progressBar(){
        progressStatus += 1;
        game_PRB_progressBar.setProgress(progressStatus);
        game_LBL_round.setText("Round " + progressStatus);
    }
}