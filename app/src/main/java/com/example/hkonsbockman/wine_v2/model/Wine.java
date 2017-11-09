package com.example.hkonsbockman.wine_v2.model;

import com.example.hkonsbckman.wine_v2.R;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Håkon S. Bøckman on 16.10.2017.
 */

public class Wine {

    private String Datotid;
    private String Varenummer;
    private String Varenavn;
    private String Volum;
    private String Pris;
    private String LiterPris;
    private String VareType;
    private String Produktutvalg;
    private String Butikkkategori;
    private String Fylde;
    private String Friskhet;
    private String Garvestoffer;
    private String Bitterhet;
    private String Sodme;
    private String Farge;
    private String Lukt;
    private String Smak;
    private String PasserTil_1;
    private String PasserTil_2;
    private String PasserTil_3;
    private String Land;
    private String Distrikt;
    private String Underdistrikt;
    private String Argang;
    private String Rastoff;
    private String Metode; // Stored in oak barrel or metal barrel
    private String Alkohol;
    private String Sukker;
    private String Syre;
    private String Lagringsgrad;
    private String Produsent;
    private String Grossist;
    private String Distributor;
    private String Emballasjetype;
    private String Korktype;
    private String Vareurl;

    public Wine(){};

    public Wine(String datotid, String varenummer, String varenavn, String volum, String pris,
                String literPris, String vareType, String produktutvalg, String butikkkategori,
                String fylde, String friskhet, String garvestoffer, String bitterhet, String sodme, String farge,
                String lukt, String smak, String passerTil_1, String passerTil_2,
                String passerTil_3, String land, String distrikt, String underdistrikt, String argang,
                String rastoff, String metode, String alkohol, String sukker, String syre,
                String lagringsgrad, String produsent, String grossist, String distributor,
                String emballasjetype, String korktype, String vareurl) {
        Datotid = datotid;
        Varenummer = varenummer;
        Varenavn = varenavn;
        Volum = volum;
        Pris = pris;
        LiterPris = literPris;
        VareType = vareType;
        Produktutvalg = produktutvalg;
        Butikkkategori = butikkkategori;
        Fylde = fylde;
        Friskhet = friskhet;
        Garvestoffer = garvestoffer;
        Bitterhet = bitterhet;
        Sodme = sodme;
        Farge = farge;
        Lukt = lukt;
        Smak = smak;
        PasserTil_1 = passerTil_1;
        PasserTil_2 = passerTil_2;
        PasserTil_3 = passerTil_3;
        Land = land;
        Distrikt = distrikt;
        Underdistrikt = underdistrikt;
        Argang = argang;
        Rastoff = rastoff;
        Metode = metode;
        Alkohol = alkohol;
        Sukker = sukker;
        Syre = syre;
        Lagringsgrad = lagringsgrad;
        Produsent = produsent;
        Grossist = grossist;
        Distributor = distributor;
        Emballasjetype = emballasjetype;
        Korktype = korktype;
        Vareurl = vareurl;
    }


    public static List<Wine> getData() {

        List<Wine> data = new ArrayList<>();

        int[] images = {
                R.drawable.wine1,
                R.drawable.wine2,
                R.drawable.wine3,
                R.drawable.wine4,
                R.drawable.wine5
        };

        String[] Wines = {
                "wine 1",
                "wine 2",
                "wine 3",
                "wine 4",
                "wine 5"
        };

        for (int i = 0; i < images.length; i++) {

            Wine currentWine = new Wine();
            currentWine.setTitle(Wines[i]);
            currentWine.setImageID(images[i]);
            data.add(currentWine);
        }
        return data;

    }

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
}
