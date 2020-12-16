package com.example.warcardgame.adapters;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.warcardgame.R;
import com.example.warcardgame.objects.WinnerPlayer;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ScoreViewHolder> {
    private ArrayList<WinnerPlayer> mExampleList;
    private Context context;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public RecyclerViewAdapter(Context context, ArrayList<WinnerPlayer> exampleList) {
        this.context = context;
        if (exampleList != null) {
            mExampleList = exampleList;
        } else {
            mExampleList = new ArrayList<>();
        }
    }

    @NonNull
    @Override
    public ScoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new ScoreViewHolder(v, mListener);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ScoreViewHolder holder, int position) {
        WinnerPlayer currentWinnerPlayerItem = mExampleList.get(position);
        holder.item_LBL_name.setText(currentWinnerPlayerItem.getPlayerName());
        holder.item_LBL_score.setText("" + currentWinnerPlayerItem.getScore());
        holder.item_LBL_date.setText(currentWinnerPlayerItem.getDate());
        position += 1;
        holder.item_LBL_id.setText(" " + position);
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    public static class ScoreViewHolder extends RecyclerView.ViewHolder {
        private TextView item_LBL_id;
        private TextView item_LBL_name;
        private TextView item_LBL_score;
        private TextView item_LBL_date;

        public ScoreViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            item_LBL_id = itemView.findViewById(R.id.item_LBL_id);
            item_LBL_name = itemView.findViewById(R.id.item_LBL_name);
            item_LBL_score = itemView.findViewById(R.id.item_LBL_score);
            item_LBL_date = itemView.findViewById(R.id.item_LBL_date);
            itemView.setOnClickListener(e -> {
                if (listener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(position);
                    }
                }
            });
        }
    }


}
