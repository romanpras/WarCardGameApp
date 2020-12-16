package com.example.warcardgame.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.RequiresApi;

import com.example.warcardgame.R;
import com.example.warcardgame.objects.GpsTracker;
import com.example.warcardgame.objects.MoveActivity;
import com.example.warcardgame.objects.WinnerPlayer;
import com.example.warcardgame.utils.MySP;
import com.example.warcardgame.utils.MySoundUtils;

import java.util.Date;

public class WinnerActivity extends Activity_Base {
    public static final String EXTRA_KEY_WINNER_NAME = "EXTRA_KEY_WINNER_NAME";
    public static final String EXTRA_KEY_WINNER_SCORE = "EXTRA_KEY_WINNER_SCORE";
    private Button winner_BTN_close;
    private Button winner_BTN_topTen;
    private TextView winner_LBL_playerName;
    private TextView winner_LBL_score;
    private ImageView winner_IMG_background;
    private WinnerPlayer winnerPlayer;
    private String winnerName;
    private int winnerScore;
    private GpsTracker gpsTracker;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);

        MySoundUtils winnerSound = new MySoundUtils(R.raw.snd_winner);
        winnerSound.playSound(this,false);
        findViews();
        glide(this,"img_background",winner_IMG_background);

        winner_BTN_topTen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = moveBetweenActivity(WinnerActivity.this, TopTenActivity.class, null, MoveActivity.TOPTEN);
                startActivity(intent);
                closeActivity(WinnerActivity.this);
            }
        });

        winner_BTN_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeActivity(WinnerActivity.this);
            }
        });

        winnerName = getIntent().getStringExtra(EXTRA_KEY_WINNER_NAME);
        winner_LBL_playerName.setText(winnerName);
        winnerScore = getIntent().getIntExtra(EXTRA_KEY_WINNER_SCORE, -1);
        winner_LBL_score.setText("" + winnerScore);
        createNewRecord();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    /**
     * This function create new record of winner player and save it in shared preference
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void createNewRecord() {
        winnerPlayer = new WinnerPlayer();
        winnerPlayer.setPlayerName(winnerName);
        winnerPlayer.setScore(winnerScore);
        winnerPlayer.setDate(DateFormat.format("dd-MM-yyyy HH:mm:ss a", new Date()).toString());
        getLocation();

        MySP prefs = new MySP(getApplicationContext());
        prefs.add(winnerPlayer, (u, v) -> {
            if (u.getScore() == v.getScore())
                return 0;
            return u.getScore() < v.getScore() ? 1 : -1;
        });
    }

    /**
     * This function update the location of the winner player
     */
    public void getLocation(){
        gpsTracker = new GpsTracker(WinnerActivity.this);
        if(gpsTracker.canGetLocation()) {
            double latitude = gpsTracker.getLatitude();
            double longitude = gpsTracker.getLongitude();
            winnerPlayer.setLongitude(longitude);
            winnerPlayer.setLatitude(latitude);
        }
    }

    private void findViews() {
        winner_BTN_close = findViewById(R.id.winner_BTN_close);
        winner_LBL_playerName = findViewById(R.id.winner_LBL_playerName);
        winner_LBL_score = findViewById(R.id.winner_LBL_score);
        winner_BTN_topTen = findViewById(R.id.winner_BTN_topTen);
        winner_IMG_background = findViewById(R.id.winner_IMG_background);
    }
}