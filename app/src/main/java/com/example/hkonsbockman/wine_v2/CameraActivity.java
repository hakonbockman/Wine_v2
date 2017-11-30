package com.example.hkonsbockman.wine_v2;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.hkonsbockman.wine_v2.model.Wine;
import com.example.hkonsbockman.wine_v2.wine.WineInfoActivity;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

import static android.Manifest.permission.CAMERA;

public class CameraActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler{
    private static final int REQUEST_CAMERA = 1;
    private ZXingScannerView scannerView;
    private boolean accepptedPermissions = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        scannerView = new ZXingScannerView(this);
        setContentView(scannerView);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){

            if(checkPermission()){
                Toast.makeText(CameraActivity.this, "Permission is granted!", Toast.LENGTH_LONG).show();
            }else{
                requestPermission();
            }
        }
    }

    private boolean checkPermission(){
        return (ContextCompat.checkSelfPermission(CameraActivity.this, CAMERA) == PackageManager.PERMISSION_GRANTED);
    }

    private void requestPermission(){
        ActivityCompat.requestPermissions(this, new String[]{CAMERA}, REQUEST_CAMERA);
       // buildNotification("Camera accessed", "The Wine'O application has now access to your phones rear camera.", R.drawable.ic_camera_notifications);
    }

    public void onRequestPermissionResult(final int requestCode, String permissions, int grantResults[]){
        switch (requestCode){
            case REQUEST_CAMERA :
                if(grantResults.length > 0){
                    boolean cameraAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    if(cameraAccepted){
                        Toast.makeText(CameraActivity.this, "Permission Granted", Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(CameraActivity.this, "Permission Denied", Toast.LENGTH_LONG).show();
                        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                            if(shouldShowRequestPermissionRationale(CAMERA)){
                                DisplayAlertMessage("You need to allow access for both permissions",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                                    requestPermissions(new String[]{CAMERA}, REQUEST_CAMERA);
                                                }
                                            }
                                        });
                                return;
                            }
                        }
                    }
                }
                break;
        }
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        scannerView.stopCamera();
    }

    @Override
    public void onResume(){
        super.onResume();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if(checkPermission()){
                if(scannerView == null){
                    scannerView = new ZXingScannerView(this);
                    setContentView(scannerView);
                }
                scannerView.setResultHandler(this);
                scannerView.startCamera();
            }
        }
    }

    public void DisplayAlertMessage(String message, DialogInterface.OnClickListener listener){
        new AlertDialog.Builder(CameraActivity.this)
                .setMessage(message)
                .setPositiveButton("OK", (DialogInterface.OnClickListener) listener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }

    @Override
    public void handleResult(Result result) {
        final String scanResult = result.getText();
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        Boolean bool = false;

        for(Wine wine: Wine.getWineList()){
            if(scanResult.equals(String.valueOf(wine.getVarenummer()))){
                bool = true;
                Intent intent = new Intent(this, WineInfoActivity.class);
                intent.putExtra("wine", wine);
                startActivity(intent);
            }
        }

        if(!bool){
            builder.setTitle("Wine was not Found");
            builder.setPositiveButton("Scan a new Wine", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    scannerView.resumeCameraPreview(CameraActivity.this);
                }
            });

            builder.setNeutralButton("Create a new Wine", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    goToCreateWineActivity(scanResult);
                }
            });

            builder.setMessage(scanResult);
            AlertDialog alert = builder.create();
            alert.show();
        }

    }

    public void goToCreateWineActivity(String scannedResult){
        Intent intent = new Intent(this, CreateWineActivity.class);
        intent.putExtra("VareNummer: ", scannedResult);
        startActivity(intent);
    }

    public void buildNotification(String title, String message, int imagePath){
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(imagePath)
                        .setContentTitle(title)
                        .setContentText(message);
    }
}


/****************************************   CODE GRAVEYARD *****************************************


 @Override
 public void handleResult(Result result) {
 final String scanResult = result.getText();
 final AlertDialog.Builder builder = new AlertDialog.Builder(this);
 builder.setTitle("Scan Result");
 builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
 @Override
 public void onClick(DialogInterface dialog, int which) {
 scannerView.resumeCameraPreview(CameraActivity.this);
 }
 });
 builder.setNeutralButton("Visit", new DialogInterface.OnClickListener() {
 @Override
 public void onClick(DialogInterface dialog, int which) {

 // TODO: Her må du på en eller annen måte kalle på en metode som finner rittig vin
 // TODO: basert på det varenummeret du har fått.
 Intent intent  = new Intent(Intent.ACTION_VIEW, Uri.parse(scanResult));
 startActivity(intent);
 }
 });
 builder.setMessage(scanResult);
 AlertDialog alert = builder.create();
 alert.show();
 }




 public static final int MY_PERMISSIONS_REQUEST_CAMERA = 100;
 public static final String ALLOW_KEY = "ALLOWED";
 public static final String CAMERA_PREF = "camera_pref";

 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_camera);
 Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
 setSupportActionBar(toolbar);
 ///////// Floating action Button ///////////
 /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
 fab.setOnClickListener(new View.OnClickListener() {
 @Override
 public void onClick(View view) {
 Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
 .setAction("Action", null).show();
 }
 });

       if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
               if(getFromPref(this, ALLOW_KEY)){
               showSettingsAlert();
               } else if ( ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA ) != PackageManager.PERMISSION_GRANTED ){

               // Should we show an explanation?
               if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)){
               showAlert();
               } else{
               // No explanation needed, we can request the permission.
               ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUEST_CAMERA);
               }
               }
               } else {
               openCamera();
               }

               }

               }



 public static void saveToPreferences(Context context, String key, Boolean allowed){
 SharedPreferences myPrefs = context.getSharedPreferences(CAMERA_PREF, context.MODE_PRIVATE);
 SharedPreferences.Editor prefsEditor = myPrefs.edit();
 prefsEditor.putBoolean(key, allowed);
 prefsEditor.commit();
 }

 private boolean getFromPref(Context context, String key) {
 SharedPreferences myPrefs = context.getSharedPreferences(CAMERA_PREF, Context.MODE_PRIVATE);
 return (myPrefs.getBoolean(key, false));
 }

 private void showAlert(){
 AlertDialog alertDialog = new AlertDialog.Builder(CameraActivity.this).create();
 alertDialog.setTitle("Alert");
 alertDialog.setMessage("App needs to access the Camera");

 alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "DONT ALLOW", new DialogInterface.OnClickListener() {
@Override
public void onClick(DialogInterface dialog, int which) {
dialog.dismiss();
finish();
}
});

 alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "ALLOW", new DialogInterface.OnClickListener() {
@Override
public void onClick(DialogInterface dialog, int which) {
dialog.dismiss();
ActivityCompat.requestPermissions(CameraActivity.this, new String[]{Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUEST_CAMERA);
}
});
 alertDialog.show();
 }

 private void showSettingsAlert() {
 AlertDialog alertDialog = new AlertDialog.Builder(CameraActivity.this).create();
 alertDialog.setTitle("Alert");
 alertDialog.setMessage("App needs to access the Camera");

 alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "DONT ALLOW", new DialogInterface.OnClickListener() {
@Override
public void onClick(DialogInterface dialog, int which) {
dialog.dismiss();
//finish();
}
});

 alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "SETTINGS", new DialogInterface.OnClickListener() {
@Override
public void onClick(DialogInterface dialog, int which) {
dialog.dismiss();
startInstallAppDetailsActivity(CameraActivity.this);
}
});

 alertDialog.show();
 }


 @Override
 public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
 switch (requestCode){
 case MY_PERMISSIONS_REQUEST_CAMERA: {
 for(int i = 0, len = permissions.length; i < len; i++){
 String permission = permissions[i];

 if(grantResults[i] == PackageManager.PERMISSION_DENIED){
 boolean showRationale = ActivityCompat.shouldShowRequestPermissionRationale(this, permission);

 if(showRationale){
 showAlert();
 } else if (!showRationale){
 // user denied flagging NEVER ASK AGAIN
 // you can either enable some fall back,
 // disable features of your app
 // or open another dialog explaining
 // again the permission and directing to
 // the app setting
 saveToPreferences(CameraActivity.this, ALLOW_KEY, true);
 }
 }
 }
 }
 }
 }

 @Override
 protected void onResume() {
 super.onResume();
 }

 public static void startInstallAppDetailsActivity(final Activity context) {
 if(context == null){
 return;
 }

 final Intent i = new Intent();
 i.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
 i.addCategory(Intent.CATEGORY_DEFAULT);
 i.setData(Uri.parse("package:" + context.getPackageName()));
 i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
 i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
 i.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
 context.startActivity(i);
 }

 private void openCamera(){
 Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
 startActivity(intent);
 }




 ******************************* CODE GRAVEYARD *******************************
  */