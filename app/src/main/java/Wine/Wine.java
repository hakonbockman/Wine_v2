package Wine;

import java.util.ArrayList;

/**
 * Created by Håkon S. Bøckman on 16.10.2017.
 */

public class Wine {
    private int ID;
    private String title;
    private int imageID;
    private String information;
    private String origin;
    private String grapeSort;

    private static ArrayList<Wine> wineList = new ArrayList<Wine>();


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getGrapeSort() {
        return grapeSort;
    }

    public void setGrapeSort(String grapeSort) {
        this.grapeSort = grapeSort;
    }

    public Wine(int ID, String title) {
        this.ID = ID;
        this.title = title;
    }

    public static ArrayList<Wine> getWineList() {
        return wineList;
    }

    public static void setWineList(ArrayList<Wine> wineList) {
        Wine.wineList = wineList;
    }

    public static void addWineToList(Wine wine){
        wineList.add(wine);
    }
}
