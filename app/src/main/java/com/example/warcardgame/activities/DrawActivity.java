package com.example.warcardgame.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.warcardgame.R;

public class DrawActivity extends Activity_Base {

    public static final String EXTRA_KEY_DRAW_SCORE = "EXTRA_KEY_DRAW_SCORE";
    private Button draw_BTN_close;
    private TextView draw_LBL_score;
    private ImageView draw_IMG_background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);

        findViews();
        glide(DrawActivity.this,"img_background",draw_IMG_background);

        draw_BTN_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeActivity(DrawActivity.this);
            }
        });

        int scoreFromPreviousActivity = getIntent().getIntExtra(EXTRA_KEY_DRAW_SCORE,-1);
        draw_LBL_score.setText("" + scoreFromPreviousActivity);
    }

    private void findViews(){
        draw_BTN_close = findViewById(R.id.draw_BTN_close);
        draw_LBL_score = findViewById(R.id.draw_LBL_score);
        draw_IMG_background = findViewById(R.id.draw_IMG_background);
    }
}