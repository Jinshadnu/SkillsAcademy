package com.example.skillsacademy.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.skillsacademy.R;
import com.example.skillsacademy.databinding.ActivityHomeBinding;
import com.example.skillsacademy.home.navigation.HomeFragment;
import com.example.skillsacademy.home.navigation.MyCourseFragment;
import com.example.skillsacademy.home.navigation.ProfileFragment;
import com.example.skillsacademy.home.navigation.SearchFragment;
import com.example.skillsacademy.utilities.Constants;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
public ActivityHomeBinding homeBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        homeBinding= DataBindingUtil.setContentView(this,R.layout.activity_home);

        openFragment(new HomeFragment(), Constants.HOME_FRAGMENT_TAG);


        homeBinding.bottomNavigationView.setOnNavigationItemSelectedListener(this);






    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.navigationHome:
                openFragment(new HomeFragment(), Constants.HOME_FRAGMENT_TAG);
                break;
            case R.id.navigationSearch:
                openFragment(new SearchFragment(), Constants.SEARCH_FRAGMENT_TAG);
                break;
            case R.id.navigationProfile:
                openFragment(new ProfileFragment(), Constants.PROFILE_FRAGMENT_TAG);
                break;
            case R.id.navigationmyCorse:
                openFragment(new MyCourseFragment(), Constants.MYCOURSE_FRAGMENT_TAG);
                break;
        }
        return true;
    }

    public void openFragment(Fragment fragment,String tag){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.layoutFragment,fragment,tag);
        transaction.addToBackStack(null);
        transaction.commit();
    }


}