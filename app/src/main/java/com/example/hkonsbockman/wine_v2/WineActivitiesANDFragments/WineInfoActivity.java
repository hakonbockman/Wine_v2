package com.example.hkonsbockman.wine_v2.WineActivitiesANDFragments;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.hkonsbckman.wine_v2.R;
import com.example.hkonsbockman.wine_v2.model.Wine;

public class WineInfoActivity extends AppCompatActivity {

    Wine wine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wine_info);

        wine = getIntent().getParcelableExtra("wine");

        FragmentManager fragmentManager = getSupportFragmentManager();

        WineInfoFragment wineInfoFragment = (WineInfoFragment) fragmentManager.findFragmentById(R.id.activity_wine_info_fragment_xml_tag);

        wineInfoFragment.setDisplayedDetail(wine);

    }
}


    /*
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.WineMenuElement_allWines:
                Intent intent = new Intent(this, WineActivity.class);
                startActivity(intent);
                break;
            case R.id.WineMenuElement_wineInfo:
                Intent intent2 = new Intent(this, WineInfoActivity.class);
                startActivity(intent2);
                break;
        }
        return true;
    }
    */


/*

        fragmentManager = getFragmentManager();
        WineInfoFragment wineInfoFragment = new WineInfoFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.wine_info_fragment_XML_tag, wineInfoFragment, "wine_info_fragment");
        //fragmentTransaction.addToBackStack("wine_info_fragment"); // if you keep this line we get duplicate in stack..so I have a stack without requesting one. Great..
        fragmentTransaction.commit();

        // set find the view who has the toolbar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setTitle("Wine'O");
*/



//get the design of the toolbar/menu
//  toolbar.inflateMenu(R.menu.main_menu);
//  toolbar.setOnMenuItemClickListener(this);