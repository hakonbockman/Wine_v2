package com.example.hkonsbckman.wine_v2;

import android.content.Intent;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import Wine.WineInfoActivity;
import Wine.WineInfoFragment;
import Wine.WineListAllWinesActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void goToWineInfo(View view) {
        Intent intent = new Intent(this, WineInfoActivity.class);
        startActivity(intent);


    }

    public void goToWineListAllWines(View view) {
        Intent intent = new Intent(this, WineListAllWinesActivity.class);
        startActivity(intent);


    }
}
