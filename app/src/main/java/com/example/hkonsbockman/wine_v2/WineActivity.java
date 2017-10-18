package com.example.hkonsbockman.wine_v2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import com.example.hkonsbckman.wine_v2.*;

import com.example.hkonsbckman.wine_v2.R;
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

        toolbar.setTitle(null);

        toolbar.inflateMenu(R.menu.wine_list_all_wines_menu);

        setUpRecyclerView();
    }

    private void setUpRecyclerView() {

        recyclerView = (RecyclerView) findViewById(R.id.wine_recycler_view);
        RecyclerAdapter adapter = new RecyclerAdapter(this, Wine.getData());

    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {

        return false;
    }
}
