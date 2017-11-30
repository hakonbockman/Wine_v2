package com.example.hkonsbockman.wine_v2.wine;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hkonsbckman.wine_v2.R;
import com.example.hkonsbockman.wine_v2.adapter.WineRecycleAdapter;
import com.example.hkonsbockman.wine_v2.ioOperations.Storage;
import com.example.hkonsbockman.wine_v2.model.Wine;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.List;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;


public class WineInfoFragment extends Fragment {


    private RecyclerView recyclerView;
    private WineListFragment.OnWineFragmentInteractionListener listener;
    private WineRecycleAdapter adapter;

    private Wine wine;

    public Bitmap imageBitmap;
    ImageView imageView;
    Fragment fragment;

    private static String mCurrentPhotoPath;

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private static String [] camera_permission = {Manifest.permission.CAMERA};
    private static String currentImagePath;

    private List<Wine> wineList;

    public final static String WINE_INDEX = "wineIndex";
    private static final int DEFAULT_WINE_INDEX = 1;

    private TextView wineTitleView;
    private TextView wineTasteView;
    private TextView wineRegionView;
    private TextView wineColourView;
    private TextView wineYearView;
    private TextView wineVolumeView;
    private TextView wineCountryView;
    private TextView winePriceView;
    private TextView wineFits1View;
    private TextView wineFits2View;
    private TextView wineFits3View;


    private ImageView winePosterImageView;
    private int i  = 0;


    private int wineIndex;

    public WineInfoFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
                    // if                           true                           false
        wineIndex = savedInstanceState == null? DEFAULT_WINE_INDEX : savedInstanceState.getInt(WINE_INDEX, DEFAULT_WINE_INDEX);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        wineList = Wine.getWineList();
        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.fragment_wine_info, container, false);

        // linking local variables to xml tags
        wineTitleView = fragmentView.findViewById(R.id.Wine_info_fragment_title);
        wineTasteView = fragmentView.findViewById(R.id.Wine_info_fragment_taste);
        wineRegionView  = fragmentView.findViewById(R.id.Wine_info_fragment_region);
        wineColourView = fragmentView.findViewById(R.id.Wine_info_fragment_colour);
        wineYearView = fragmentView.findViewById(R.id.Wine_info_fragment_year);
        wineVolumeView = fragmentView.findViewById(R.id.Wine_info_fragment_volume);
        wineCountryView = fragmentView.findViewById(R.id.Wine_info_fragment_country);
        winePriceView = fragmentView.findViewById(R.id.Wine_info_fragment_price);
        wineFits1View = fragmentView.findViewById(R.id.Wine_info_fragment_fits1);
        wineFits2View = fragmentView.findViewById(R.id.Wine_info_fragment_fits2);
        wineFits3View = fragmentView.findViewById(R.id.Wine_info_fragment_fits3);




        winePosterImageView = fragmentView.findViewById(R.id.Wine_info_fragment_picture);
        winePosterImageView.setOnClickListener(v -> mCurrentPhotoPath = captureImageFromCamera(getActivity(), fragmentView, REQUEST_IMAGE_CAPTURE));

        return fragmentView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(WINE_INDEX, wineIndex);
    }

    /**
     * Setting the values based on the Wine object we receive.
     * This method demands a index value to identify which Wine this is
     * however I'm not entirely sure if this is the correct way, since a Wine
     * already has a "ID" value called "vareNummer"
     */
    public void setDisplayedDetail(Wine wine) {
        wineTitleView.setText(wine.getVarenavn());
        wineTasteView.setText(wine.getSmak());
        wineRegionView.setText(wine.getDistrikt());
        wineColourView.setText(wine.getFarge());
        wineYearView.setText(wine.getArgang());
        wineVolumeView.setText(wine.getVolum());
        wineCountryView.setText(wine.getLand());
        winePriceView.setText(wine.getPris());
        wineFits1View.setText(wine.getPasserTil_1());
        wineFits2View.setText(wine.getPasserTil_2());
        wineFits3View.setText(wine.getPasserTil_3());

        if(wine.getThumbnail() == null){
            Drawable winePoster = ContextCompat.getDrawable(getActivity(), wine.getImageID());
            if(winePoster != null){
                winePosterImageView.setImageDrawable(winePoster);
            }
        }else {
            byte [] decodedString = Base64.decode(wine.getByteArray_converted_to_string(), Base64.DEFAULT);
            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

            winePosterImageView.setImageBitmap(decodedByte);
        }

    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);

        if(resultCode != Activity.RESULT_OK)
            return;

        if(requestCode == REQUEST_IMAGE_CAPTURE && mCurrentPhotoPath != null){
         //   winePosterImageView.setImageBitmap(BitmapFactory.decodeFile(mCurrentPhotoPath));

            BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
            Bitmap bitmap = BitmapFactory.decodeFile(mCurrentPhotoPath, bitmapOptions);
/*
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 50, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();

            String encodedByteArray = Base64.encodeToString(byteArray, Base64.DEFAULT);

            wine.setByteArray_converted_to_string(encodedByteArray);

            bitmap = Bitmap.createScaledBitmap(bitmap, 512, 512, true);
*/
            winePosterImageView.setImageBitmap(bitmap);

        }

/// GLIDE  IS HERE !! /////////
        //Glide.with(this).load(mCurrentPhotoPath).into(winePosterImageView);

    }



    @AfterPermissionGranted(REQUEST_IMAGE_CAPTURE)
    public String captureImageFromCamera(Activity activity, View view, int intentCode){
        File file = null;
        Uri imageUri = null;
        Boolean bool = false;

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
                    startActivityForResult(intent, intentCode);
                }else
                    return null;

            }
        } else {
            bool = true;
            //
            EasyPermissions.requestPermissions(activity,
                    "You don't have permission for Camera," +
                            " do you want to allow this application " +
                            "access to your Camera?",
                    REQUEST_IMAGE_CAPTURE, camera_permission);
        }
        if (!bool){
            return file.getPath();
        }
        return null;
    }

}
