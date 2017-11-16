package com.example.hkonsbockman.wine_v2.WineActivitiesANDFragments;

        import android.app.Fragment;
        import android.os.Build;
        import android.os.Bundle;
        import android.support.annotation.RequiresApi;
        import android.support.v7.widget.GridLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Toast;

        import com.example.hkonsbckman.wine_v2.R;
        import com.example.hkonsbockman.wine_v2.adapter.OnWineSelectedListener;
        import com.example.hkonsbockman.wine_v2.adapter.RecycleAdapterListener;
        import com.example.hkonsbockman.wine_v2.adapter.WineRecycleAdapter;
        import com.example.hkonsbockman.wine_v2.model.Wine;

/**
 * Created by Håkon S. Bøckman on 15.11.2017.
 */

public class WineListFragment extends Fragment implements RecycleAdapterListener {

    private RecyclerView recyclerView;
    private OnWineFragmentInteractionListener listener;

    public WineListFragment(){
        // empty
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.wine_list_item, container, false);

        setUpRecycleView(view);

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
        WineRecycleAdapter adapter = new WineRecycleAdapter(getContext(), Wine.getWineList(), this);
        recyclerView.setAdapter(adapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    @Override
    public void wineSelected(Wine wine) {
        Toast.makeText(getContext(), wine.getVarenavn() + " selected", Toast.LENGTH_SHORT).show();
        listener.onWineSelected(wine);
    }

    public interface OnWineFragmentInteractionListener {
        void onWineSelected(Wine wine);
    }

}
