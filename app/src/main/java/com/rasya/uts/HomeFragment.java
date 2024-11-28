package com.rasya.uts;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    List<ModelTrending> modelTrendingList = new ArrayList<>();
    TrendingAdapter trendingAdapter;
    ModelTrending modelTrending;
    RecyclerView rvTrending;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Now that the layout is inflated, find the RecyclerView
        rvTrending = view.findViewById(R.id.rvTrending);
        setInitLayout();
        setTrending();

        return view;
    }

    private void setInitLayout() {
        // Initialize RecyclerView
        rvTrending.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rvTrending.setHasFixedSize(true);
    }

    private void setTrending() {
        // Tambahkan data dummy untuk trending
        modelTrending = new ModelTrending(R.drawable.complete_1, "Menu 1", "2.200 disukai");
        modelTrendingList.add(modelTrending);
        modelTrending = new ModelTrending(R.drawable.complete_2, "Menu 2", "1.220 disukai");
        modelTrendingList.add(modelTrending);
        modelTrending = new ModelTrending(R.drawable.complete_3, "Menu 3", "345 disukai");
        modelTrendingList.add(modelTrending);
        modelTrending = new ModelTrending(R.drawable.complete_4, "Menu 4", "590 disukai");
        modelTrendingList.add(modelTrending);

        // Set adapter untuk RecyclerView
        trendingAdapter = new TrendingAdapter(getActivity(), modelTrendingList);
        rvTrending.setAdapter(trendingAdapter);
    }

    public void setStatusbar() {
        if (Build.VERSION.SDK_INT < 21) {
            setWindowFlag(getActivity(), WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                getActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
        }
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(getActivity(), WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            getActivity().getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    public static void setWindowFlag(@NonNull Activity activity, final int bits, boolean on) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        if (on) {
            layoutParams.flags |= bits;
        } else {
            layoutParams.flags &= ~bits;
        }
        window.setAttributes(layoutParams);
    }
}