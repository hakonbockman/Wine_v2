package com.example.hkonsbockman.wine_v2.wine;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hkonsbckman.wine_v2.R;
import com.example.hkonsbockman.wine_v2.adapter.RecycleAdapterListener;
import com.example.hkonsbockman.wine_v2.adapter.WineRecycleAdapter;
import com.example.hkonsbockman.wine_v2.model.Wine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Håkon S. Bøckman on 15.11.2017.
 */

public class WineListFragment extends Fragment implements RecycleAdapterListener{

    private RecyclerView recyclerView;
    private OnWineFragmentInteractionListener listener;
    private WineRecycleAdapter adapter;

    private ArrayList<Wine> newList = new ArrayList<>();
    private List<Wine> wineList = new ArrayList<>();
    private List<Wine> wineListCopy = new ArrayList<>();


    public WineListFragment(){

        //wineList.addAll(Wine.getWineList());
        //wineListCopy.addAll(Wine.getWineList());
        /*
        wineList.addAll((Collection<? extends Wine>) Wine.getWineList().clone());

        for (Wine wine : Wine.getWineList()){
            wineList.add(Wine.getWineList().clone().getClass(Wine));
        }
        */
        // empty
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_collection, container, false);

        setUpRecycleView(view);

        wineList = cloneWineList(Wine.getWineList());
        wineListCopy = cloneWineList(Wine.getWineList());
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        try {
            listener = (OnWineFragmentInteractionListener) getActivity();
        }catch (ClassCastException e){
            throw new ClassCastException(getActivity().toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void setUpRecycleView(View view) {
        recyclerView = view.findViewById(R.id.wine_recycler_view);
        adapter = new WineRecycleAdapter(getContext(), Wine.getWineList(), this);
        recyclerView.setAdapter(adapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(gridLayoutManager);


    }

    public static List<Wine> cloneWineList(ArrayList<Wine> list){
        ArrayList<Wine> clone_list = new ArrayList<Wine>(list.size());
        for(Wine item : list) clone_list.add(new Wine(item));
        return clone_list;
    }

    @Override
    public void wineSelected(Wine wine) {
        Toast.makeText(getContext(), wine.getVarenavn() + " selected", Toast.LENGTH_SHORT).show();

        listener.onWineSelected(wine);
    }


    public void sortListDependingOnTheTextInput(String newText){
        newText = newText.toLowerCase();

        if(newText.trim().isEmpty()){
            adapter.setFilter(wineListCopy);
        }else{

            newList.clear();
            for(Wine wine : wineList){
                if(wine.getVarenavn().trim().contains(newText) ){
                    newList.add(wine);
                }
            }
            if(newList.isEmpty() && newText.trim().isEmpty()){
                adapter.setFilter(wineListCopy);
            }
        }
        adapter.setFilter(newList);
    }


    public interface OnWineFragmentInteractionListener {
        void onWineSelected(Wine wine);
    }



/**
 *  This section is for Searching on recycler view.
 */

/**
 * filtrer lista her fordi recycle view buker denne lista som er i adapteren
 */






}
