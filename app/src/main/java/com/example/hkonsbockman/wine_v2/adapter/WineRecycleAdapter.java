import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by Håkon S. Bøckman on 18.10.2017.
 */

public class WineRecycleAdapter extends RecyclerView.Adapter<WineRecycleAdapter.MyViewHolder>{

    private static final String TAG = RecyclerAdapter.class.getSimpleName();


    @Override
    public WineRecycleAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(WineRecycleAdapter.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
