package com.example.felipesavaris.helpmeautoajuda.Adapter.Categories;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.felipesavaris.helpmeautoajuda.Model.Categoria;
import com.example.felipesavaris.helpmeautoajuda.R;

import java.util.ArrayList;
import java.util.List;

public class ListCategoryAdapter extends BaseAdapter {

    private LayoutInflater mLayoutInflater;
    private List<Categoria> categories;

    public ListCategoryAdapter(Context context, List<Categoria> categories) {
        this.mLayoutInflater = mLayoutInflater.from(context);

        this.categories = new ArrayList<>(categories);
    }

    @Override
    public int getCount() {
        return categories.size();
    }

    @Override
    public Object getItem(int position) {
        return categories.get(position);
    }

    @Override
    public long getItemId(int position) {
        return categories.get(position).getId_categoria();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if(convertView == null) {

            convertView = mLayoutInflater.inflate(R.layout.listview_categories, null);
            holder = new ViewHolder();

            holder.cbCategoryCheck = (CheckBox) convertView.findViewById(R.id.cbCategoryCheck);
            holder.tvCategoryName = (TextView) convertView.findViewById(R.id.tvCategoryName);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.cbCategoryCheck.setChecked(true);
        holder.tvCategoryName.setText("Depressão");

        return convertView;
    }
}
