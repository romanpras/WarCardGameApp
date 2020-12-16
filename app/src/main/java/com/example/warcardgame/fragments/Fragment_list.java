package com.example.warcardgame.fragments;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.warcardgame.R;
import com.example.warcardgame.adapters.RecyclerViewAdapter;
import com.example.warcardgame.objects.WinnerPlayer;
import com.example.warcardgame.utils.MySP;

import java.util.ArrayList;


public class Fragment_list extends Fragment {

    View view;
    private ArrayList<WinnerPlayer> list = new ArrayList<>();
    private RecyclerView recyclerView;
    private FragmentTopTenListener listener;

    public interface FragmentTopTenListener {
        void onGameUserInfoSent(WinnerPlayer user);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list,container,false);
        findViews(view);
        RecyclerViewAdapter exampleAdapter = new RecyclerViewAdapter(getContext(), list);
        exampleAdapter.setOnItemClickListener(position->{
            WinnerPlayer winnerPlayer = list.get(position);
            listener.onGameUserInfoSent(winnerPlayer);
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(exampleAdapter);
        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getContext() != null) {
            MySP shared = new MySP(getContext());
            list = shared.readDataFromStorage();
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if( context instanceof FragmentTopTenListener){
            // if our activity implements this interface
            listener = (FragmentTopTenListener) context;

        }else{
            throw new RuntimeException(context.toString() + "must implements FragmentHighScoreListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        view = null; // now cleaning up!
    }

    private void findViews(View view) {
        recyclerView = view.findViewById(R.id.recyclerView);
    }
}
