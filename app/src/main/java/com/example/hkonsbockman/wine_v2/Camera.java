package com.example.hkonsbockman.wine_v2;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.view.View;

import com.example.hkonsbockman.wine_v2.ioOperations.Storage;

import java.io.File;
import java.util.List;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * Created by Håkon S. Bøckman on 30.11.2017.
 */

public class Camera implements EasyPermissions.PermissionCallbacks {
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private static String [] camera_permission = {Manifest.permission.CAMERA};
    private static String currentImagePath;

    @AfterPermissionGranted(REQUEST_IMAGE_CAPTURE)
    public static String captureImageFromCamera(Activity activity, View view, int intentCode){
        File file = null;
        Uri imageUri = null;

        if(EasyPermissions.hasPermissions(activity, camera_permission)){
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

            if(intent.resolveActivity(activity.getPackageManager()) != null){
                try{
                    file = Storage.createImageFile(activity);
                }catch (Exception e){
                    Log.e("Can't Create ImageFile", e.getMessage());
                }
                if(file != null){
                    currentImagePath = file.getAbsolutePath();
                    //String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                    //String imageFileName = "JPEG_" + timeStamp + "_";
                    String authorities = activity.getApplicationContext().getPackageName() + ".fileprovider";
                    imageUri = FileProvider.getUriForFile(activity, authorities,file);

                    intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                    activity.startActivityForResult(intent, intentCode);
                }else
                    return null;

            }
        } else {
            //
            EasyPermissions.requestPermissions(activity,
                    "You don't have permission for Camera," +
                            " do you want to allow this application " +
                            "access to your Camera?",
                    REQUEST_IMAGE_CAPTURE, camera_permission);
        }
        return file.getPath();
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

    }
}
