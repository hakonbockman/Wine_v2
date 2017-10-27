import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by Håkon S. Bøckman on 18.10.2017.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder> {

    private static final String TAG = RecycleAdapter.class.getSimpleName();

    @Override
    public RecycleAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecycleAdapter.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
