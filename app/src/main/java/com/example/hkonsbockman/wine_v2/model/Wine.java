package com.example.hkonsbockman.wine_v2.model;

import com.example.hkonsbckman.wine_v2.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Håkon S. Bøckman on 16.10.2017.
 */

public class Wine {
    private String title;
    private int imageID;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public static List<Wine> getData(){

        List<Wine> data = new ArrayList<>();

        int[] images = {
                R.drawable.wine1,
                R.drawable.wine2,
                R.drawable.wine3,
                R.drawable.wine4,
                R.drawable.wine5
        };

        String [] Wines = {
                "wine 1",
                "wine 2",
                "wine 3",
                "wine 4",
                "wine 5"
        };

        for(int i = 0; i < images.length; i++){

            Wine currentWine = new Wine();
            currentWine.setTitle(Wines[i]);
            currentWine.setImageID(images[i]);
            data.add(currentWine);
        }
        return data;

    }
}
