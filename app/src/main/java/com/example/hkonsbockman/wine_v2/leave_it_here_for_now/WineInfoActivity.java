package com.example.hkonsbockman.wine_v2;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hkonsbckman.wine_v2.R;

public class WineInfoActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wine_info);

        fragmentManager = getFragmentManager();

        WineInfoFragment wineInfoFragment = new WineInfoFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.wine_info_fragment_XML_tag, wineInfoFragment, "wine_info_fragment");
        fragmentTransaction.addToBackStack("wine_info_fragment");
        fragmentTransaction.commit();
    }
}
