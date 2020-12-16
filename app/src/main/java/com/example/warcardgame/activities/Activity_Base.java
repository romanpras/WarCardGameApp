package com.example.warcardgame.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

import com.example.warcardgame.objects.MoveActivity;
import com.example.warcardgame.objects.RetrieveData;
import com.example.warcardgame.utils.MyScreenUtils;

public class Activity_Base extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyScreenUtils.hideSystemUI(this);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            MyScreenUtils.hideSystemUI(this);
        }
    }

    /**
     * This function destroy the activity
     * @param activity receive the activity to close
     */
    public static void closeActivity(AppCompatActivity activity) {
        activity.finish();
    }

    /**
     * This function allow to move between various activities
     * @param context context object
     * @param newActivity The activity to which we want to move
     * @param retrieveData Object that contain parameters of each player
     * @param moveActivity Flag (WINNER|DRAW|GAME|DEFAULT)
     * @return Intent object
     */
    public static Intent moveBetweenActivity(Context context, Class newActivity , RetrieveData retrieveData, MoveActivity moveActivity){
        Intent intent = new Intent(context, newActivity);
        switch (moveActivity){
            case WINNER:
                intent.putExtra(WinnerActivity.EXTRA_KEY_WINNER_NAME, retrieveData.getWinnerPlayer().getPlayerName());
                intent.putExtra(WinnerActivity.EXTRA_KEY_WINNER_SCORE, retrieveData.getWinnerPlayer().getScore());
                break;
            case DRAW:
                intent.putExtra(DrawActivity.EXTRA_KEY_DRAW_SCORE, retrieveData.getWinnerPlayer().getScore());
                break;
            case GAME:
                intent.putExtra(GameActivity.EXTRA_KEY_GAME_PLAYER_NAME_ONE, retrieveData.getPlayer1().getName());
                intent.putExtra(GameActivity.EXTRA_KEY_GAME_PLAYER_NAME_TWO, retrieveData.getPlayer2().getName());
            default:
                break;
        }
        return intent;
    }

    /**
     * This function allow to read image with glide library
     * @param activity Current activity
     * @param imageName Name of the image in drawable package
     * @param view Sets the ImageView the resource will be loaded into
     */
    public static void glide(Context activity, String imageName, ImageView view){
        Glide
                .with(activity)
                .load(getResourceId(imageName,activity))
                .into(view);
    }

    /**
     * This function get the resource id of the image that exiting in drawable folder
     * @param imageName String of image name
     * @param context context object
     * @return a resource identifier for the given resource name
     */
    public static int getResourceId(String imageName,Context context){
        return context.getResources().getIdentifier(imageName,"drawable",context.getPackageName());
    }
}