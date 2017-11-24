package com.example.hkonsbockman.wine_v2.wine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;

import com.example.hkonsbckman.wine_v2.R;
import com.example.hkonsbockman.wine_v2.NavigationDrawerFragment;
import com.example.hkonsbockman.wine_v2.ioOperations.DatabaseHandling;
import com.example.hkonsbockman.wine_v2.model.Wine;
import static android.support.v4.view.MenuItemCompat.getActionView;

public class WineActivity extends AppCompatActivity implements WineListFragment.OnWineFragmentInteractionListener , android.support.v7.widget.SearchView.OnQueryTextListener {

    NavigationDrawerFragment navigationDrawerFragment;
    Toolbar toolbar;
    WineListFragment wineListFragment;

    public WineActivity() {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wine);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Wine'O");
        setSupportActionBar(toolbar);
        setUpDrawer();
    }

    /**
     *  Based on what item is selected, we go to the WineInfoActivity.
     *  And pass along the current object selected.
     * @param wine
     */
    @Override
    public void onWineSelected(Wine wine) {
        Intent intent = new Intent(this, WineInfoActivity.class);
        intent.putExtra("wine", wine);
        startActivity(intent);
    }

    // sets up the drawer menu
    private void setUpDrawer() {
        navigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.navigation_drawer_fragment); // fragment
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout); // id på drawerlayout som er line 4 på activity_wine.xml
        navigationDrawerFragment.setUpDrawer(drawerLayout, toolbar, R.id.nav_list_of_all_wines);
    }

    /**
     * Writes the whole Wine.getWinelist() to  the Firebase.
     */
    public void writeToDatabase() {
        DatabaseHandling databaseHandling = new DatabaseHandling();
        databaseHandling.writeWineToDatabase(Wine.getWineList(), "Wines");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) getActionView(menuItem);
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        wineListFragment = (WineListFragment) getSupportFragmentManager().findFragmentById(R.id.wine_list_fragment);
        wineListFragment.sortListDependingOnTheTextInput(query);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        wineListFragment = (WineListFragment) getSupportFragmentManager().findFragmentById(R.id.wine_list_fragment);
        wineListFragment.sortListDependingOnTheTextInput(newText);
        return true;
    }

}
