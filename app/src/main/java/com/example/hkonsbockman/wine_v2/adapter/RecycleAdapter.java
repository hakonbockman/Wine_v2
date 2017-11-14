package com.example.hkonsbockman.wine_v2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hkonsbckman.wine_v2.R;
import com.example.hkonsbockman.wine_v2.model.Wine;

import java.util.List;

/**
 * Created by Håkon S. Bøckman on 13.10.2017.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder> {

    private static final String TAG = RecycleAdapter.class.getSimpleName();

    List<Wine> _wineList;
    private LayoutInflater inflater;

    public RecycleAdapter(Context context ,List<Wine> _wineList) {
        this._wineList = _wineList;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecycleAdapter.MyViewHolder holder, int position) {

        Wine current = _wineList.get(position);
        holder.setData(current, position);
        holder.setListeners();
    }

    public void removeItem(int position) {
        _wineList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, _wineList.size());
    }

    public void addItem(int position, Wine landscape) {
        _wineList.add(position, landscape);
        notifyItemInserted(position);
        notifyItemRangeChanged(position, _wineList.size());
    }

    @Override
    public int getItemCount() {
        return _wineList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        ImageView imgThumb, imgDelete, imgAdd;
        int position;
        Wine current;

        public MyViewHolder(View itemView) {
            super(itemView);
            title       = itemView.findViewById(R.id.tvTitle);
            try {
                imgThumb    = itemView.findViewById(R.id.img_row);
            }finally {
                imgThumb = itemView.findViewById(this.imgThumb.getId());
            }
            imgDelete   = itemView.findViewById(R.id.img_row_delete);
            //imgAdd      = itemView.findViewById(R.id.img_row_add);
        }
        public void setData(Wine wine, int position) {
            this.title.setText(wine.getTitle());
            imgThumb.setImageResource(wine.getImageID());
            this.position = position;
            this.current = wine;
        }

        public void setListeners() {
            imgDelete.setOnClickListener(MyViewHolder.this);
         //   imgAdd.setOnClickListener(MyViewHolder.this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.img_row_delete:
                    removeItem(position);
                    break;
                /*
                case R.id.img_row_add:
                    addItem(position, current);
                    break;
                */
            }
        }
    }
}
