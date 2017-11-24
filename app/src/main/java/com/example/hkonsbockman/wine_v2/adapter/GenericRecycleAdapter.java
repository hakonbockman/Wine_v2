package com.example.hkonsbockman.wine_v2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.Filter;
import android.widget.Filterable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Håkon S. Bøckman on 17.11.2017.
 */

public abstract class GenericRecycleAdapter<E> extends RecyclerView.Adapter implements Filterable{

    protected List<E> list;
    protected List<E> originalList;
    protected Context context;

    public GenericRecycleAdapter(Context context, List<E> list){
        this.originalList = list;
        this.list = list;
        this.context = context;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                list = (List<E>) results.values;
                GenericRecycleAdapter.this.notifyDataSetChanged();
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                List<E> filteredResults = null;
                if(constraint.length() == 0){
                    filteredResults = originalList;
                }else {
                    filteredResults = getFilteredResults(constraint.toString().toLowerCase());
                }
                FilterResults results = new FilterResults();
                results.values = filteredResults;

                return results;
            }

        };

    }

    protected List<E> getFilteredResults(String constraint){
        List<E> results = new ArrayList<>();
        /**
         * TODO: Need to fix: item.getClass().getName()
         *
         */
        for(E item : originalList){
            if(item.getClass().getName().toLowerCase().contains(constraint)){
                results.add(item);
            }
        }
        return results;
    }
}
