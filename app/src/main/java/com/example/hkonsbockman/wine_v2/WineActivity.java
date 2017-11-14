package com.example.hkonsbockman.wine_v2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.hkonsbckman.wine_v2.R;
import com.example.hkonsbockman.wine_v2.adapter.RecycleAdapter;
import com.example.hkonsbockman.wine_v2.model.Wine;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class WineActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener {
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private DatabaseHandling databaseHandling = new DatabaseHandling();
    private boolean readFromLocalStorage = true;
    private CSVFile csvFile;
    private InputStream inputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wine);

        readFromLocalCSVFile();
        
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Wine'O");
        toolbar.inflateMenu(R.menu.main_menu);
        toolbar.setOnMenuItemClickListener(this);
        setUpRecyclerView();

    }
    public void readFromLocalCSVFile() {
        if(readFromLocalStorage){
            inputStream = getResources().openRawResource(R.raw.produkter);
            csvFile = new CSVFile(inputStream);
            csvFile.readLocalFile();
        }
        readFromLocalStorage = false;
    }

    public void writeToDatabase() {
        databaseHandling.writeWineToDatabase(Wine.getWineList(), "Wines");
    }

    private void setUpRecyclerView(){
        recyclerView = (RecyclerView) findViewById(R.id.wine_recycler_view);
        RecycleAdapter adapter = new RecycleAdapter(this, Wine.getWineList());
        recyclerView.setAdapter(adapter);
       // LinearLayoutManager linearLayoutManagerVertical = new LinearLayoutManager(this);
       // linearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
       // recyclerView.setLayoutManager(linearLayoutManagerVertical);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mGridLayoutManager);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.write_to_database:
                writeToDatabase();
                break;
           /* case R.id.read_csv_local:
                readFromLocalCSVFile();
                break;*/
        }
        return true;
    }

}
