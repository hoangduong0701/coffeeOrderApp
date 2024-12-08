package com.example.coffeeshop.Activities;

import static android.net.ConnectivityManager.CONNECTIVITY_ACTION;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.coffeeshop.Fragments.CartFragment;
import com.example.coffeeshop.Fragments.FavouriteFragment;
import com.example.coffeeshop.Fragments.HomeFragment;
import com.example.coffeeshop.Fragments.NotificationFragment;
import com.example.coffeeshop.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
     Fragment current = new HomeFragment();
     Integer current_page = R.id.page_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(current);
        // Initialize and assign variable
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);
        // Set Home selected
        Intent i = getIntent();
        if (i!= null)
        {
            if(i.getIntExtra("notification",-1) == 1)
            {
                current_page = R.id.page_4;
                loadFragment(new NotificationFragment());
            }
        }
        // sự kiện khởi tạo mặc định
        bottomNavigationView.setSelectedItemId(current_page);
        // Perform item selected listener
        // sự kiện khi nhấn các nút bottom
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.page_1){
                    HomeFragment fragment = new HomeFragment();
                    loadFragment(fragment);
                }
                if (item.getItemId() == R.id.page_2){
                    CartFragment fragment = new CartFragment();
                    loadFragment(fragment);
                }
                if (item.getItemId() == R.id.page_3){
                    FavouriteFragment fragment = new FavouriteFragment();
                    loadFragment(fragment);
                }
                if (item.getItemId() == R.id.page_4){
                    NotificationFragment fragment = new NotificationFragment();
                    loadFragment(fragment);
                }

                return true;
            }
        });
    }


    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, fragment);
        transaction.commit();
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}