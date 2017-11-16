package com.example.hkonsbockman.wine_v2.wine;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hkonsbckman.wine_v2.R;
import com.example.hkonsbockman.wine_v2.Wine;

import java.util.List;


public class WineInfoFragment extends Fragment  {

    private List<Wine> wineList;

    public final static String WINE_INDEX = "wineIndex";
    private static final int DEFAULT_WINE_INDEX = 1;

    private TextView wineTitleView;
    private TextView wineDescriptionView;
    private ImageView winePosterImageView;

    private int wineIndex;

    public WineInfoFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
                    // if                           false                           true
        wineIndex = savedInstanceState == null? DEFAULT_WINE_INDEX : savedInstanceState.getInt(WINE_INDEX, DEFAULT_WINE_INDEX);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.fragment_wine_info, container, false);

        // linking local variables to xml tags
        wineTitleView = fragmentView.findViewById(R.id.Wine_info_fragment_title);
        wineDescriptionView = fragmentView.findViewById(R.id.Wine_info_fragment_description);
        winePosterImageView = fragmentView.findViewById(R.id.Wine_info_fragment_picture);

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

        Drawable winePoster = ContextCompat.getDrawable(getActivity(), wine.getImageID());
        if(winePoster != null){
            winePosterImageView.setImageDrawable(winePoster);
        }

    }

}
