package com.example.hkonsbockman.wine_v2;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.hkonsbckman.wine_v2.R;
import com.example.hkonsbockman.wine_v2.fragments.NavigationDrawerFragment;
import com.example.hkonsbockman.wine_v2.leave_it_here_for_now.WineInfoActivity;

import static com.example.hkonsbckman.wine_v2.R.id.toolbar;

public class MainActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener {
    Toolbar toolbar;
    NavigationDrawerFragment navigationDrawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set find the view who has the toolbar.
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Win'O");
        //get the design of the toolbar/menu
        //toolbar.inflateMenu(R.menu.main_menu);
        //toolbar.setOnMenuItemClickListener(this);
        setSupportActionBar(toolbar);

        setUpDrawer();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Hello, I'm a snackbar!", Snackbar.LENGTH_LONG)
                        .setAction("Kill", new MyActionListener()).show();
            }
        });

    }

    private void setUpDrawer() {
        navigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.navigation_drawer_fragment);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationDrawerFragment.setUpDrawer(drawerLayout, toolbar, R.id.nav_shows);
    }

    @Override
    protected void onStart() {
        navigationDrawerFragment.updateCheckedItem(R.id.nav_shows);
        super.onStart();
    }

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

    private class MyActionListener  implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            // Code to do the desired Action
            Snackbar.make(v, "I'm dead! =(", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
    }
}

