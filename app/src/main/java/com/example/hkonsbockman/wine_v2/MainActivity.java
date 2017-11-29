package com.example.hkonsbockman.wine_v2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.hkonsbckman.wine_v2.R;
import com.example.hkonsbockman.wine_v2.ioOperations.CSVFile;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.firebase.ui.auth.AuthUI;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.InputStream;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Toolbar toolbar;
    NavigationDrawerFragment navigationDrawerFragment;
    private boolean readFromLocalStorage = true;
    private CSVFile csvFile;
    private InputStream inputStream;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseAuth.AuthStateListener firebaseAuthStateListener;


    public static final int RC_SIGN_IN = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // FireBaseAuthSetup
        setupFireBaseLoginSystem();
        // read local file
        readFromLocalCSVFile();
        // Toolbar
        setupToolbar();
        // NavigationDrawer
        setUpDrawer();
        // FloatingActionButtonSetup
        setupFloatingActionButton();
    }

    private void setupFireBaseLoginSystem() {
        mAuth = FirebaseAuth.getInstance();

        firebaseAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                if(firebaseUser != null){
                    // do nothing
                } else {
                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setIsSmartLockEnabled(false)
                                    .setAvailableProviders(
                                            Arrays.asList(new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build(),
                                            new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build()))
                                    .build(),
                            RC_SIGN_IN);
                }
            }
        };
    }

    private void setupToolbar() {
        // set find the view who has the toolbar.
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Wine'O");
        //get the design of the toolbar/menu
        //toolbar.inflateMenu(R.menu.main_menu);
        //toolbar.setOnMenuItemClickListener(this);
        setSupportActionBar(toolbar);
    }



    public void setupFloatingActionButton(){
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), CameraActivity.class);
                startActivity(intent);
            }
        });
    }

    public void readFromLocalCSVFile() {
        if(readFromLocalStorage){
            inputStream = getResources().openRawResource(R.raw.produkter);
            csvFile = new CSVFile(inputStream);
            csvFile.readLocalFile();
        }
        readFromLocalStorage = false;
    }


    private void setUpDrawer() {
        navigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.navigation_drawer_fragment);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationDrawerFragment.setUpDrawer(drawerLayout, toolbar, R.id.nav_list_of_all_wines);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == RC_SIGN_IN){
            if (resultCode == RESULT_OK) {
                Toast.makeText(this,"Signed in", Toast.LENGTH_SHORT).show();
            } else if(resultCode == RESULT_CANCELED){
                Toast.makeText(this, "Signed in canceled", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        // setting the default "checked" button in the menu of navigationDrawer.
        navigationDrawerFragment.updateCheckedItem(R.id.nav_home);
    }

    @Override
    protected void onResume(){
        super.onResume();
        mAuth.addAuthStateListener(firebaseAuthStateListener);
    }

    /*
    /**
     * Don't know why this one was needed
     * but android studio insisted on me
     * using the post version of resume.
     * So far I have not Actively added
     * multi threading or Async methods
     *
    @Override
    protected void onPostResume() {
        super.onPostResume();
        mAuth.addAuthStateListener(firebaseAuthStateListener);
    }
*/
    @Override
    protected void onPause() {
        super.onPause();
        if(firebaseAuthStateListener != null){
            mAuth.removeAuthStateListener(firebaseAuthStateListener);
        }
    }

    @Override
    public void onClick(View view) {
        // OnClick on MyActionListener.
        // Do nothing for now
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

