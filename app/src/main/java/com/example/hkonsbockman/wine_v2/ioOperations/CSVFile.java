package com.example.hkonsbockman.wine_v2.ioOperations;

import com.example.hkonsbockman.wine_v2.Wine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Håkon S. Bøckman on 08.11.2017.
 */

public class CSVFile {
    InputStream inputStream;
    String csvLine;
    String[] row;
    String[] element;

    public CSVFile(InputStream inputStream){
        this.inputStream = inputStream;
    }

    public void readLocalFile(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            while ((csvLine = reader.readLine()) != null) {
                row = csvLine.split("\n");

                for ( Object row_ :row) {
                    element = row_.toString().split(";");
                    createNewWine();
                }
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
    }

    public void createNewWine(){
        Wine temp = new Wine();
        temp.setDate(element[0]);
        temp.setVarenummer(Integer.parseInt(element[1]));
        temp.setVarenavn(element[2]);
        temp.setVolum(element[3]);
        temp.setPris(element[4]);
        temp.setLiterPris(element[5]);
        temp.setVareType(element[6]);
        temp.setProduktutvalg(element[7]);
        temp.setButikkkategori(element[8]);
        temp.setFylde(element[9]);
        temp.setFriskhet(element[10]);
        temp.setGarvestoffer(element[11]);
        temp.setBitterhet(element[12]);
        temp.setSodme(element[13]);
        temp.setFarge(element[14]);
        temp.setLukt(element[15]);
        temp.setSmak(element[16]);
        temp.setPasserTil_1(element[17]);
        temp.setPasserTil_2(element[18]);
        temp.setPasserTil_3(element[19]);
        temp.setLand(element[20]);
        temp.setDistrikt(element[21]);
        temp.setUnderdistrikt(element[22]);
        temp.setArgang(element[23]);
        temp.setRastoff(element[24]);
        temp.setMetode(element[25]);
        temp.setAlkohol(element[26]);
        temp.setSukker(element[27]);
        temp.setSyre(element[28]);
        temp.setLagringsgrad(element[29]);
        temp.setProdusent(element[30]);
        temp.setGrossist(element[31]);
        temp.setDistributor(element[32]);
        temp.setEmballasjetype(element[33]);
        temp.setKorktype(element[34]);
        temp.setVareurl(element[35]);
    }

}






