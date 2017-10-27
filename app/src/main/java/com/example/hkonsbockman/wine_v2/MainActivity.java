package Blam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setTitle(this.getTitle());

        toolbar.inflateMenu(R.menu.main_menu);
    }

    public void goToWineInfo(View view) {
        Intent intent = new Intent(this, WineInfoActivity.class);
        startActivity(intent);
    }

    public void goToWineListAllWines(View view) {
        Intent intent = new Intent(this, WineListAllWinesActivity.class);
        startActivity(intent);
    }

    public void goToWineActivity(View view) {
        Intent intent = new Intent(this, WineActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        return false;
    }
}
