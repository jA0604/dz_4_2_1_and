package com.androidakbar.dz_4_2_1;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SampleAdapter extends BaseAdapter {
    private List<Sample> sampleItem;
    private LayoutInflater inflater;

    public SampleAdapter(Context context, List<Sample> sampleItem) {
        if (sampleItem == null) {
            this.sampleItem = new ArrayList<>();
        } else {
            this.sampleItem = sampleItem;
        }

        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return sampleItem.size();
    }

    @Override
    public Sample getItem(int position) {
        if (position < sampleItem.size()) {
            return sampleItem.get(position);
        } else {
            return null;
        }

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.list_item, viewGroup, false);
        }

        Sample itemSample = sampleItem.get(position);

        ImageView image = view.findViewById(R.id.img_item);
        TextView title = view.findViewById(R.id.txt_app_name);
        TextView category = view.findViewById(R.id.txt_category);
        CheckBox chkBox = view.findViewById(R.id.chk_box);

        image.setImageDrawable(itemSample.getImage());
        title.setText(itemSample.getTitle());
        category.setText(itemSample.getCategory());
        chkBox.setChecked(itemSample.isChecked());
        return view;
    }


}
