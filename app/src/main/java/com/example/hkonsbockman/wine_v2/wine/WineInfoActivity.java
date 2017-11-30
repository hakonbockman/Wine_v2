package com.example.hkonsbockman.wine_v2.wine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.hkonsbckman.wine_v2.R;
import com.example.hkonsbockman.wine_v2.model.Wine;

import java.util.List;

import pub.devrel.easypermissions.EasyPermissions;


public class WineInfoActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {

    private Wine wine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wine_info);

        wine = getIntent().getParcelableExtra("wine");

        FragmentManager fragmentManager = getSupportFragmentManager();

        WineInfoFragment wineInfoFragment = (WineInfoFragment) fragmentManager.findFragmentById(R.id.activity_wine_info_fragment_xml_tag);

        wineInfoFragment.setDisplayedDetail(wine);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {

    }


}
