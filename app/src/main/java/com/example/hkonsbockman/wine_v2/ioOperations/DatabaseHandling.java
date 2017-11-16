package com.example.hkonsbockman.wine_v2.ioOperations;

import android.util.Log;

import com.example.hkonsbockman.wine_v2.model.Wine;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * Created by Håkon S. Bøckman on 14.11.2017.
 */

public class DatabaseHandling {
    private static FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

    public static void writeWineToDatabase(ArrayList<Wine> inputArray, String Reference){
         firebaseDatabase = FirebaseDatabase.getInstance();
         DatabaseReference wineDatabaseReference = firebaseDatabase.getReference(Reference);

            for(Wine element : inputArray){
                String elementID = wineDatabaseReference.push().getKey();
                DatabaseReference wineRef = wineDatabaseReference.child(elementID);
                wineRef.setValue(element);
            }
    }

    public static void readFromDatabase(){
        Wine.getWineList().clear();

        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapShotWine : dataSnapshot.getChildren()){
                    Wine wine = dataSnapShotWine.getValue(Wine.class);
                    wine.getWineList().add(wine);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "Load Wines Failed:", databaseError.toException());
            }
        };
    }





    public DatabaseHandling() {}
}
