package com.example.collectivetrip;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    Fragment activeFragment;
    Fragment waitFragment;
    Fragment archiveFragment;
    Fragment profileFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activeFragment = new ActiveFragment();
        waitFragment = new WaitFragment();
        archiveFragment = new ArchiveFragment();
        profileFragment = new ProfileFragment();

        FragmentTransaction fTrans = getSupportFragmentManager().beginTransaction();
        fTrans.replace(R.id.main_fragment, activeFragment);
        fTrans.commit();

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction fTrans = getSupportFragmentManager().beginTransaction();
                switch (item.getItemId()) {
                    case R.id.page_active:
                        fTrans.replace(R.id.main_fragment, activeFragment);
                        break;
                    case R.id.page_wait:
                        fTrans.replace(R.id.main_fragment, waitFragment);
                        break;
                    case R.id.page_archive:
                        fTrans.replace(R.id.main_fragment, archiveFragment);
                        break;
                    case R.id.page_profile:
                        fTrans.replace(R.id.main_fragment, profileFragment);
                        break;
                }
                fTrans.commit();
                return true;
            }
        });
    }
}