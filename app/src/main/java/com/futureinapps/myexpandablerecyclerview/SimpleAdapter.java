package com.futureinapps.myexpandablerecyclerview;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by fappsilya on 30.07.15.
 */
public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.SimpleViewHolder> {

    private final Context mContext;
    private List<String> mData;
    private HashMap<String, Boolean> map;


    public static class SimpleViewHolder extends RecyclerView.ViewHolder{

        public final TextView title;
        public final MyRelativeLayout item;

        public SimpleViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.simple_text);

            item = (MyRelativeLayout) view.findViewById(R.id.relaetive_item);
        }
    }

    public SimpleAdapter(Context context, List<String> data) {
        mContext = context;
        if (data != null)
            mData = data;
        else mData = new ArrayList<>();
        map = new HashMap<>();

    }

    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(mContext).inflate(R.layout.simple_item, parent, false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final SimpleViewHolder holder, final int position) {

        holder.title.setText(mData.get(position));
        holder.item.setChecked(map.containsKey(mData.get(position)));
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!map.containsKey(mData.get(position))){
                    holder.item.setChecked(true);
                    map.put(mData.get(position), true);
                    Snackbar.make(((OrderActivity) mContext).findViewById(R.id.coordinatorLayout),
                            "Услуга добавлена в корзину, всего " + getContents().size(), Snackbar.LENGTH_SHORT).show();
                } else {
                    holder.item.setChecked(false);

                    map.remove(mData.get(position));
                    Snackbar.make(((OrderActivity) mContext).findViewById(R.id.coordinatorLayout),
                            "Услуга удалена из корзины, всего " + getContents().size(), Snackbar.LENGTH_SHORT).show();
                }
                Log.d("aert", "count" + getContents().size());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public List<String> getContents(){
        List<String> list = new ArrayList<>();
            for(int i = 0; i<mData.size(); i++) {
                if (map.containsKey(mData.get(i))) {
                    list.add(mData.get(i));
                }
            }
        return list;
    }
}