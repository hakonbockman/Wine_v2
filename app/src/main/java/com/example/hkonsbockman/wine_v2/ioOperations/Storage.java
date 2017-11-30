package com.example.hkonsbockman.wine_v2.ioOperations;

import android.Manifest;
import android.app.Activity;
import android.os.Environment;
import android.support.annotation.NonNull;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

/**
 *
 * Created by Håkon S. Bøckman on 29.11.2017.
 *
 */
public class Storage implements EasyPermissions.PermissionCallbacks {

    //FirebaseStorage storage = FirebaseStorage.getInstance();
    //FirebaseStorage storage = FirebaseStorage.getInstance("gs://my-custom-bucket");


    private static final int STORAGE_PERMISSION = 1;
    private static String storagePermission = Manifest.permission.WRITE_EXTERNAL_STORAGE;
    private static String currentImagePath;

    Storage(){};

    @AfterPermissionGranted(STORAGE_PERMISSION)
    public static File createImageFile(Activity activity) throws IOException {
        // create an image file name
        if (EasyPermissions.hasPermissions(activity, storagePermission)) {
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String imageFileName = "JPEG_" + timeStamp + "_";

            File storageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "Camera");
            if (!storageDir.exists()) {
                storageDir.mkdir();
            }
            File file = File.createTempFile( imageFileName,".jpg", storageDir );
            currentImagePath = file.getAbsolutePath();
            return file;
        } else {
            // Do not have permission for storage, we gotta request it
            EasyPermissions.requestPermissions(
                    activity, "You don't have permission for" +
                            " storage, do you want to allow this " +
                            "application access to your local storage?",
                    STORAGE_PERMISSION, storagePermission);
            return null;
        }
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
