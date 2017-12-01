package com.example.hkonsbockman.wine_v2.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import com.example.hkonsbckman.wine_v2.R;

import java.util.ArrayList;

/**
 * Created by Håkon S. Bøckman on 16.10.2017.
 */

public class Wine implements Parcelable {

    private String Date;
    private int Varenummer;
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

    private int wine_icon_id = R.drawable.wine_icon;
    private String title;
    private int imageID;
    private static ArrayList<Wine> wineList = new ArrayList<>();
    private Bitmap thumbnail;
    private Bitmap picture;
    private String picturePATH;

    public String getByteArray_converted_to_string() {
        return byteArray_converted_to_string;
    }

    public void setByteArray_converted_to_string(String byteArray_converted_to_string) {
        this.byteArray_converted_to_string = byteArray_converted_to_string;
    }

    private String byteArray_converted_to_string;

    public String getPicturePATH() {
        return picturePATH;
    }

    public void setPicturePATH(String picturePATH) {
        this.picturePATH = picturePATH;
    }

    public Bitmap getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Bitmap thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Bitmap getPicture() {
        return picture;
    }

    public void setPicture(Bitmap picture) {
        this.picture = picture;
    }

    public Wine(){
        wineList.add(this);
        this.setImageID(wine_icon_id);
    }



    public static final Creator<Wine> CREATOR = new Creator<Wine>() {
        @Override
        public Wine createFromParcel(Parcel in) {
            return new Wine(in);
        }

        @Override
        public Wine[] newArray(int size) {
            return new Wine[size];
        }
    };

    public static ArrayList<Wine> getWineList() {
        return wineList;
    }

    public static ArrayList<Wine> getData() {

        ArrayList<Wine> data = new ArrayList<Wine>();

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

    public void setDate(String date) {
        this.Date = date;
    }

    public void setVarenummer(int varenummer) {
        this.Varenummer = varenummer;
    }

    public void setVarenavn(String varenavn) {
        this.Varenavn = varenavn;
    }

    public void setVolum(String volum) {
        this.Volum = volum;
    }

    public void setPris(String pris) {
        this.Pris = pris;
    }

    public void setLiterPris(String literPris) {
        this.LiterPris = literPris;
    }

    public void setVareType(String vareType) {
        this.VareType = vareType;
    }

    public void setProduktutvalg(String produktutvalg) {
        this.Produktutvalg = produktutvalg;
    }

    public void setButikkkategori(String butikkkategori) {
        this.Butikkkategori = butikkkategori;
    }

    public void setFylde(String fylde) {
        this.Fylde = fylde;
    }

    public void setFriskhet(String friskhet) {
        this.Friskhet = friskhet;
    }

    public void setGarvestoffer(String garvestoffer) {
        this.Garvestoffer = garvestoffer;
    }

    public void setBitterhet(String bitterhet) {
        this.Bitterhet = bitterhet;
    }

    public void setSodme(String sodme) {
        this.Sodme = sodme;
    }

    public void setFarge(String farge) {
        this.Farge = farge;
    }

    public void setLukt(String lukt) {
        this.Lukt = lukt;
    }

    public void setSmak(String smak) {
        this.Smak = smak;
    }

    public void setPasserTil_1(String passerTil_1) {
        this.PasserTil_1 = passerTil_1;
    }

    public void setPasserTil_2(String passerTil_2) {
        this.PasserTil_2 = passerTil_2;
    }

    public void setPasserTil_3(String passerTil_3) {
        this.PasserTil_3 = passerTil_3;
    }

    public void setLand(String land) {
        this.Land = land;
    }

    public void setDistrikt(String distrikt) {
        this.Distrikt = distrikt;
    }

    public void setUnderdistrikt(String underdistrikt) {
        this.Underdistrikt = underdistrikt;
    }

    public void setArgang(String argang) {
        this.Argang = argang;
    }

    public void setRastoff(String rastoff) {
        this.Rastoff = rastoff;
    }

    public void setMetode(String metode) {
        this.Metode = metode;
    }

    public void setAlkohol(String alkohol) {
        this.Alkohol = alkohol;
    }

    public void setSukker(String sukker) {
        this.Sukker = sukker;
    }

    public void setSyre(String syre) {
        this.Syre = syre;
    }

    public void setLagringsgrad(String lagringsgrad) {
        this.Lagringsgrad = lagringsgrad;
    }

    public void setProdusent(String produsent) {
        this.Produsent = produsent;
    }

    public void setGrossist(String grossist) {
        this.Grossist = grossist;
    }

    public void setDistributor(String distributor) {
        this.Distributor = distributor;
    }

    public void setEmballasjetype(String emballasjetype) {
        this.Emballasjetype = emballasjetype;
    }

    public void setKorktype(String korktype) {
        this.Korktype = korktype;
    }

    public void setVareurl(String vareurl) {
        this.Vareurl = vareurl;
    }

    public String getDate() {
        return Date;
    }

    public int getVarenummer() {
        return Varenummer;
    }

    public String getVarenavn() {
        return Varenavn;
    }

    public String getVolum() {
        return Volum;
    }

    public String getPris() {
        return Pris;
    }

    public String getLiterPris() {
        return LiterPris;
    }

    public String getVareType() {
        return VareType;
    }

    public String getProduktutvalg() {
        return Produktutvalg;
    }

    public String getButikkkategori() {
        return Butikkkategori;
    }

    public String getFylde() {
        return Fylde;
    }

    public String getFriskhet() {
        return Friskhet;
    }

    public String getGarvestoffer() {
        return Garvestoffer;
    }

    public String getBitterhet() {
        return Bitterhet;
    }

    public String getSodme() {
        return Sodme;
    }

    public String getFarge() {
        return Farge;
    }

    public String getLukt() {
        return Lukt;
    }

    public String getSmak() {
        return Smak;
    }

    public String getPasserTil_1() {
        return PasserTil_1;
    }

    public String getPasserTil_2() {
        return PasserTil_2;
    }

    public String getPasserTil_3() {
        return PasserTil_3;
    }

    public String getLand() {
        return Land;
    }

    public String getDistrikt() {
        return Distrikt;
    }

    public String getUnderdistrikt() {
        return Underdistrikt;
    }

    public String getArgang() {
        return Argang;
    }

    public String getRastoff() {
        return Rastoff;
    }

    public String getMetode() {
        return Metode;
    }

    public String getAlkohol() {
        return Alkohol;
    }

    public String getSukker() {
        return Sukker;
    }

    public String getSyre() {
        return Syre;
    }

    public String getLagringsgrad() {
        return Lagringsgrad;
    }

    public String getProdusent() {
        return Produsent;
    }

    public String getGrossist() {
        return Grossist;
    }

    public String getDistributor() {
        return Distributor;
    }

    public String getEmballasjetype() {
        return Emballasjetype;
    }

    public String getKorktype() {
        return Korktype;
    }

    public String getVareurl() {
        return Vareurl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Date);
        dest.writeInt(Varenummer);
        dest.writeString(Varenavn);
        dest.writeString(Volum);
        dest.writeString(Pris);
        dest.writeString(LiterPris);
        dest.writeString(VareType);
        dest.writeString(Produktutvalg);
        dest.writeString(Butikkkategori);
        dest.writeString(Fylde);
        dest.writeString(Friskhet);
        dest.writeString(Garvestoffer);
        dest.writeString(Bitterhet);
        dest.writeString(Sodme);
        dest.writeString(Farge);
        dest.writeString(Lukt);
        dest.writeString(Smak);
        dest.writeString(PasserTil_1);
        dest.writeString(PasserTil_2);
        dest.writeString(PasserTil_3);
        dest.writeString(Land);
        dest.writeString(Distrikt);
        dest.writeString(Underdistrikt);
        dest.writeString(Argang);
        dest.writeString(Rastoff);
        dest.writeString(Metode);
        dest.writeString(Alkohol);
        dest.writeString(Sukker);
        dest.writeString(Syre);
        dest.writeString(Lagringsgrad);
        dest.writeString(Produsent);
        dest.writeString(Grossist);
        dest.writeString(Distributor);
        dest.writeString(Emballasjetype);
        dest.writeString(Korktype);
        dest.writeString(Vareurl);
        dest.writeInt(wine_icon_id);
        dest.writeString(title);
        dest.writeInt(imageID);
    }

    public Wine(Wine wine){
        this.Date = wine.Date;
        this.Varenummer = wine.Varenummer;
        this.Varenavn = wine.Varenavn;
        this.Volum = wine.Volum;
        this.Pris = wine.Pris;
        this.LiterPris = wine.LiterPris;
        this.VareType = wine.VareType;
        this.Produktutvalg = wine.Produktutvalg;
        this.Butikkkategori = wine.Butikkkategori;
        this.Fylde = wine.Fylde;
        this.Friskhet = wine.Friskhet;
        this.Garvestoffer = wine.Garvestoffer;
        this.Bitterhet = wine.Bitterhet;
        this.Sodme = wine.Sodme;
        this.Farge = wine.Farge;
        this.Lukt = wine.Lukt;
        this.Smak = wine.Smak;
        this.PasserTil_1 = wine.PasserTil_1;
        this.PasserTil_2 = wine.PasserTil_2;
        this.PasserTil_3 = wine.PasserTil_3;
        this.Land = wine.Land;
        this.Distrikt = wine.Distrikt;
        this.Underdistrikt = wine.Underdistrikt;
        this.Argang = wine.Argang;
        this.Rastoff = wine.Rastoff;
        this.Metode = wine.Metode;
        this.Alkohol = wine.Alkohol;
        this.Sukker = wine.Sukker;
        this.Syre = wine.Syre;
        this.Lagringsgrad = wine.Lagringsgrad;
        this.Produsent = wine.Produsent;
        this.Grossist = wine.Grossist;
        this.Distributor = wine.Distributor;
        this.Emballasjetype = wine.Emballasjetype;
        this.Korktype = wine.Korktype;
        this.Vareurl = wine.Vareurl;
        this.setImageID(wine_icon_id);
    }

    protected Wine(Parcel in) {
        Date = in.readString();
        Varenummer = in.readInt();
        Varenavn = in.readString();
        Volum = in.readString();
        Pris = in.readString();
        LiterPris = in.readString();
        VareType = in.readString();
        Produktutvalg = in.readString();
        Butikkkategori = in.readString();
        Fylde = in.readString();
        Friskhet = in.readString();
        Garvestoffer = in.readString();
        Bitterhet = in.readString();
        Sodme = in.readString();
        Farge = in.readString();
        Lukt = in.readString();
        Smak = in.readString();
        PasserTil_1 = in.readString();
        PasserTil_2 = in.readString();
        PasserTil_3 = in.readString();
        Land = in.readString();
        Distrikt = in.readString();
        Underdistrikt = in.readString();
        Argang = in.readString();
        Rastoff = in.readString();
        Metode = in.readString();
        Alkohol = in.readString();
        Sukker = in.readString();
        Syre = in.readString();
        Lagringsgrad = in.readString();
        Produsent = in.readString();
        Grossist = in.readString();
        Distributor = in.readString();
        Emballasjetype = in.readString();
        Korktype = in.readString();
        Vareurl = in.readString();
        wine_icon_id = in.readInt();
        title = in.readString();
        imageID = in.readInt();
        wineList.add(this);
    }
}


/*****
 *
 *
 *
 *     public Wine(String datotid, String varenummer, String varenavn, String volum, String pris,
 String literPris, String vareType, String produktutvalg, String butikkkategori,
 String fylde, String friskhet, String garvestoffer, String bitterhet, String sodme, String farge,
 String lukt, String smak, String passerTil_1, String passerTil_2,
 String passerTil_3, String land, String distrikt, String underdistrikt, String argang,
 String rastoff, String metode, String alkohol, String sukker, String syre,
 String lagringsgrad, String produsent, String grossist, String distributor,
 String emballasjetype, String korktype, String vareurl) {


 this.Date = datotid;
 this.Varenummer = varenummer;
 this.Varenavn = varenavn;
 this.Volum = volum;
 this.Pris = pris;
 this.LiterPris = literPris;
 this.VareType = vareType;
 this.Produktutvalg = produktutvalg;
 this.Butikkkategori = butikkkategori;
 this.Fylde = fylde;
 this.Friskhet = friskhet;
 this.Garvestoffer = garvestoffer;
 this.Bitterhet = bitterhet;
 this.Sodme = sodme;
 this.Farge = farge;
 this.Lukt = lukt;
 this.Smak = smak;
 this.PasserTil_1 = passerTil_1;
 this.PasserTil_2 = passerTil_2;
 this.PasserTil_3 = passerTil_3;
 this.Land = land;
 this.Distrikt = distrikt;
 this.Underdistrikt = underdistrikt;
 this.Argang = argang;
 this.Rastoff = rastoff;
 this.Metode = metode;
 this.Alkohol = alkohol;
 this.Sukker = sukker;
 this.Syre = syre;
 this.Lagringsgrad = lagringsgrad;
 this.Produsent = produsent;
 this.Grossist = grossist;
 this.Distributor = distributor;
 this.Emballasjetype = emballasjetype;
 this.Korktype = korktype;
 this.Vareurl = vareurl;
 wineList.add(this);
 }
 *
 * */
