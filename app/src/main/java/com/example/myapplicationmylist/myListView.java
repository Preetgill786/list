package com.example.myapplicationmylist;


import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class myListView extends BaseAdapter implements View.OnClickListener {
    private Activity activity;
    private List<listItem> data = new ArrayList<listItem>();
    private static LayoutInflater inflater = null;
    public Resources res;
    listItem item = null;
    int i = 0;


    public myListView(Activity a, ArrayList d, Resources r) {
        activity = a;
        data = d;
        res = r;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        if (data.size() <= 0)
            return 1;
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public void onClick(View view) {
        Log.v("customAdapter", "row button is clicked");
    }

    public static class ViewHolder {
        public TextView text;
        public ImageView img;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View vi = view;
        ViewHolder holder;
        if (view == null) {
            vi = inflater.inflate(R.layout.mylist, null);
            holder = new ViewHolder();
            holder.text = vi.findViewById(R.id.textItem);
            holder.img = vi.findViewById(R.id.imageView);
            vi.setTag(holder);
        } else
            holder = (ViewHolder) vi.getTag();
        if (data.size() <= 0) {
            holder.text.setText("No data");
        } else {
            item = null;
            item = (listItem) data.get(i);

            holder.text.setText(item.getItemName());
            holder.img.setImageResource(res.getIdentifier("com.example.myapplicationmylist:drawable/"+ item.getItemImage(),null,"com.example.myapplicationmylist"));
            //holder.img.setImageResource(res.getIdentifier("com.example.listview:drawable/" + item.getItemImage(),null));
            vi.setOnClickListener(new OnItemClickListener(i));

        }

        return vi;
    }

    private class OnItemClickListener implements View.OnClickListener {
        private int i;

        OnItemClickListener(int i) {

            this.i = i;
        }
        public void onClick(View v){
            MainActivity m = (MainActivity)activity;
            m.onItemClick(i);
        }
    }
}


