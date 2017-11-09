package com.example.hkonsbockman.wine_v2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.example.hkonsbckman.wine_v2.R;
import com.example.hkonsbockman.wine_v2.adapter.RecycleAdapter;
import com.example.hkonsbockman.wine_v2.model.Wine;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.InputStream;
import java.util.List;

import static java.sql.DriverManager.println;

public class WineActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener {
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private List<Wine> wineList = Wine.getData();
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference wineDatabaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wine);

        // read from file
        InputStream inputStream = getResources().openRawResource(R.raw.produkter);
        CSVFile csvFile = new CSVFile(inputStream);

       // wineList = csvFile.read();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Wine'O");
        toolbar.inflateMenu(R.menu.main_menu);
        toolbar.setOnMenuItemClickListener(this);
        setUpRecyclerView();

    }

    public void writeToDatabase() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        //   firebaseAuth = FirebaseAuth.getInstance();
        wineDatabaseReference = firebaseDatabase.getReference().child("wines");
        for(Wine wine : wineList){
            wineDatabaseReference.setValue(wine);
        }


    }

    private void setUpRecyclerView(){
        recyclerView = (RecyclerView) findViewById(R.id.wine_recycler_view);
        RecycleAdapter adapter = new RecycleAdapter(this, wineList);
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
            case R.id.database_load:
                writeToDatabase();
                break;
        }
        return true;
    }

}
