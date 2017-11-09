package com.example.hkonsbockman.wine_v2;

import com.example.hkonsbockman.wine_v2.model.Wine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Håkon S. Bøckman on 08.11.2017.
 */

public class CSVFile {
    InputStream inputStream;
    List<Wine> wineList = new ArrayList<Wine>();

    public CSVFile(InputStream inputStream){
        this.inputStream = inputStream;
    }

    public List read(){
        String csvLine;
        String[] row;
        String[] element;
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        List rowlist = new ArrayList();

        try {
            while ((csvLine = reader.readLine()) != null) {
                row = csvLine.split(" ");
                rowlist.add(row);

                /*for ( Object row_ :row) {
                 /*   element = row_.toString().split(";");
                    for (Object element_:element) {
                        wineList.add(new Wine(element[0], element[1], element[2], element[3], element[4], element[5]
                                , element[6], element[7], element[8], element[9], element[10], element[11]
                                , element[12], element[13], element[14], element[15], element[16], element[17]
                                , element[18], element[19], element[20], element[21], element[22], element[23]
                                , element[24], element[25], element[26], element[27], element[28], element[29]
                                , element[30], element[31], element[32], element[33], element[34], element[35]
                                ));
                    }
                }*/
            }
        }catch (IOException e){
            throw new RuntimeException("Error in reading CSV file" + e);
        }
        finally {
            try {
                inputStream.close();
            }catch (IOException e2 ){
                throw new RuntimeException("Error while closing input stream " + e2);
            }
        }

      //  return wineList;
        return rowlist;
    }
}
