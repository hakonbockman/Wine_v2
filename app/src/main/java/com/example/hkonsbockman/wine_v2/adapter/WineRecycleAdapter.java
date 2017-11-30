package com.example.hkonsbockman.wine_v2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hkonsbckman.wine_v2.R;
import com.example.hkonsbockman.wine_v2.model.Wine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Håkon S. Bøckman on 13.10.2017.
 */

public class WineRecycleAdapter extends RecyclerView.Adapter<WineViewHolder>{
    private List<Wine> wineList = new ArrayList<>();
    private List<Wine> wineListCopy = new ArrayList<>();
    private LayoutInflater inflater;
    private OnWineSelectedListener onWineSelectedListener;
    private RecycleAdapterListener recycleAdapterListener;


    public WineRecycleAdapter(Context context, List<Wine> data, RecycleAdapterListener extRecycleAdapterListener){
        this.wineList = data;
        this.inflater = LayoutInflater.from(context);
        this.recycleAdapterListener = extRecycleAdapterListener;

        onWineSelectedListener = new OnWineSelectedListener() {
            @Override
            public void wineSelected(int position) {
                Wine wine = wineList.get(position);
                recycleAdapterListener.wineSelected(wine);
            }
        };
        // proper copy of the wine class's static list
        wineListCopy = cloneWineList(data);
    }

    /**
     *  Takes in a ArrayList<Wine> and returns a copy of that list, as List<Wine>
     *  Uses its own constructor of Wine: Wine( Wine wine), hence since wine.clone()
     *  was not possible to implement because of protection of the method. Honestly
     *  I don't get the protection and a proper work around.
     * @param list
     * @return
     */
    private static List<Wine> cloneWineList(List<Wine> list){
        ArrayList<Wine> clone_list = new ArrayList<Wine>(list.size());
        for(Wine item : list) clone_list.add(new Wine(item));
        return clone_list;
    }

    @Override
    public WineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.wine_list_item, parent, false);

        WineViewHolder holder = new WineViewHolder(view);
        view.setOnClickListener(holder);

        return holder;
    }

    @Override
    public void onBindViewHolder(WineViewHolder holder, int position) {
        Wine currentObj = wineList.get(position);
        holder.bind(currentObj, onWineSelectedListener);
    }

    @Override
    public int getItemCount() {
        return wineList.size();
    }

    /**
     * Adding the elements from the list, to the current recycleView's list. Expects a list<Wine>
     * This method is used only within WineListFragment.sortListDependingOnTheTextInput, and that
     * method is called from WineActivity.onQueryTextChange and onQueryTextSubmit. Unsure if Submit
     * works properly.
     * TODO: Find out why the resulting recycle view generate a extra copy of chosen object
     * TODO: After you go back from WineInfoActivity and WineInfoFragment it should generate
     * TODO: The whole list.
     * @param newList
     */
    public void setFilter(List<Wine> newList){
            wineList.clear();
            wineList.addAll(newList);
        notifyDataSetChanged();
    }
}
