package com.knowledgeisgyaan.hcvermavol1and2solutions.Models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import com.knowledgeisgyaan.hcvermavol1and2solutions.*;

public class ChapterAdapter extends ArrayAdapter<chapter> {
    private final Context context;
    private final ArrayList<chapter> values;

    public ChapterAdapter(Context context, ArrayList<chapter> list) {

        super(context, R.layout.list_item_layout, list);
        this.context = context;
        this.values = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowview = inflater.inflate(R.layout.list_item_layout, parent, false);

        TextView chapter = (TextView) rowview.findViewById(R.id.chptext);
        TextView icon = (TextView) rowview.findViewById(R.id.chpnum);

        chapter.setText(values.get(position).getChp());
        icon.setText(values.get(position).getNum());

        return rowview;
    }

}
