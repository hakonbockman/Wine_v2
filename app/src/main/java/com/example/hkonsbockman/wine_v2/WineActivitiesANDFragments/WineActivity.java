package com.example.hkonsbockman.wine_v2.WineActivitiesANDFragments;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.hkonsbckman.wine_v2.R;
import com.example.hkonsbockman.wine_v2.ioOperations.DatabaseHandling;
import com.example.hkonsbockman.wine_v2.model.Wine;

public class WineActivity extends AppCompatActivity implements  WineListFragment.OnWineFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wine);
    }

    @Override
    public void onWineSelected(Wine wine) {

        if(getResources().getBoolean(R.bool.twoPaneMode)){
            FragmentManager fragmentManager = getFragmentManager();


            WineInfoFragment wineInfoFragment = (WineInfoFragment) fragmentManager.findFragmentById(R.id.blam_blam);

            wineInfoFragment.setDisplayedDetail(wine);
        }
        else{
            Intent intent = new Intent(this, WineInfoActivity.class);
            intent.putExtra("wine", wine);
            startActivity(intent);
        }

    }

    public void writeToDatabase() {
        DatabaseHandling databaseHandling = new DatabaseHandling();
        databaseHandling.writeWineToDatabase(Wine.getWineList(), "Wines");
    }

}












/*      CODE GRAVE YARD


       toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Wine'O");
        toolbar.inflateMenu(R.menu.main_menu);
        toolbar.setOnMenuItemClickListener(this);



    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.write_to_database:
                writeToDatabase();
                break;
           // case R.id.read_csv_local:
           //     readFromLocalCSVFile();
           //     break;
        }
                return true;
                }


 */
