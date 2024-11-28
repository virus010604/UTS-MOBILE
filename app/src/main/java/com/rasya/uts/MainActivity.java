package com.rasya.uts;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ModelTrending> modelTrendingList = new ArrayList<>();
    TrendingAdapter trendingAdapter;
    ModelTrending modelTrending;
//    RecyclerView rvTrending;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Add HomeFragment to MainActivity using FragmentTransaction
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new HomeFragment())
                    .commit();
        }

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                int itemId = item.getItemId();
                if(itemId == R.id.navigation_home){
                    selectedFragment = new HomeFragment();
                }else if(itemId == R.id.navigation_dashboard){
                    selectedFragment = new FoodFragment();
                } else if (itemId == R.id.navigation_account) {
                    selectedFragment = new ProfilFragment();
                }

                // Ganti fragmen jika ada fragmen yang dipilih
                if (selectedFragment != null) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, selectedFragment)
                            .commit();
                }
                return true;
            }
        });

        setStatusbar();
    }

//    private void setInitLayout() {
////        // Inisialisasi RecyclerView dari XML baru
//        rvTrending = findViewById(R.id.rvTrending);
//        rvTrending.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
//        rvTrending.setHasFixedSize(true);
//    }

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
        trendingAdapter = new TrendingAdapter(this, modelTrendingList);
//        rvTrending.setAdapter(trendingAdapter);
    }

    public void setStatusbar() {
        if (Build.VERSION.SDK_INT < 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
        }
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
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
