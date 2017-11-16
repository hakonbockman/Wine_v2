package com.example.hkonsbockman.wine_v2.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hkonsbckman.wine_v2.R;
import com.example.hkonsbockman.wine_v2.model.Wine;

/**
 * Created by Håkon S. Bøckman on 15.11.2017.
 */

public class WineViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView title;
    ImageView poster;
    OnWineSelectedListener onWineSelectedListener;

    public WineViewHolder(View itemView){
        super(itemView);
        title = itemView.findViewById(R.id.wine_list_item_textView);
        poster = itemView.findViewById(R.id.wine_list_item_image);
    }

    public void bind(Wine wine, OnWineSelectedListener listener){
        this.title.setText(wine.getVarenavn());
        this.poster.setImageResource(wine.getImageID());
        this.onWineSelectedListener = listener;
    }

    @Override
    public void onClick(View view) {
        onWineSelectedListener.wineSelected(getAdapterPosition());
    }
}
