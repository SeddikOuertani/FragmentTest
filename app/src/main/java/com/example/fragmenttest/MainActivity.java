package com.example.fragmenttest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    Button firstFragBtn, secondFragBtn;

    FrameLayout fragmentHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstFragBtn = (Button) findViewById(R.id.button_fragment_1);
        secondFragBtn = (Button) findViewById(R.id.button_fragment_2);

        fragmentHolder = (FrameLayout) findViewById(R.id.fragment_holder);

        firstFragBtn.setOnClickListener(v->{
            loadFragment(new FirstFragment());
        });

        secondFragBtn.setOnClickListener(v->{
            loadFragment(new SecondFragment());
        });

    }

    public void loadFragment(Fragment fragment){

        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

        //Remplacement de ancienne fragment avec la nouvelle fragment
        transaction.replace(R.id.fragment_holder, fragment);
        transaction.commit(); // save the changes

    }
}