package com.example.hkonsbockman.wine_v2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.hkonsbckman.wine_v2.R;
import com.example.hkonsbockman.wine_v2.adapter.RecycleAdapter;
import com.example.hkonsbockman.wine_v2.leave_it_here_for_now.WineInfoActivity;
import com.example.hkonsbockman.wine_v2.model.Wine;

public class WineActivity extends AppCompatActivity
        implements Toolbar.OnMenuItemClickListener {
    private Toolbar toolbar;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wine);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Win'O");
        toolbar.inflateMenu(R.menu.main_menu);
        toolbar.setOnMenuItemClickListener(this);

        setUpRecyclerView();
    }

    private void setUpRecyclerView(){

        recyclerView = (RecyclerView) findViewById(R.id.wine_recycler_view);
        RecycleAdapter adapter = new RecycleAdapter(this, Wine.getData());
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
}
