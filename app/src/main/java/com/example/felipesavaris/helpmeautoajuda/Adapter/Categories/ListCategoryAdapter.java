package com.example.felipesavaris.helpmeautoajuda.Adapter.Categories;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.felipesavaris.helpmeautoajuda.DAO.CategoryDAO;
import com.example.felipesavaris.helpmeautoajuda.Model.Categoria;
import com.example.felipesavaris.helpmeautoajuda.Model.Professional;
import com.example.felipesavaris.helpmeautoajuda.R;

import java.util.ArrayList;
import java.util.List;

public class ListCategoryAdapter extends BaseAdapter {

    private LayoutInflater mLayoutInflater;
    private List<Categoria> categories;
    private Context context;

    public ListCategoryAdapter(Context context, List<Categoria> categories) {
        this.mLayoutInflater = mLayoutInflater.from(context);
        this.context = context;
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

        //Elementos a serem implementados no ListView
        ViewHolder holder;

        //Instância da categoria que será colocada no ListView
        final Categoria categoria = (Categoria) getItem(position);

        if(convertView == null) {

            //Inicialização do XML listview_categories
            convertView = mLayoutInflater.inflate(R.layout.listview_categories, null);
            holder = new ViewHolder();

            //Inicialização dos elementos do XML
            holder.cbCategoryCheck = (CheckBox) convertView.findViewById(R.id.cbCategoryCheck);
            holder.tvCategoryName = (TextView) convertView.findViewById(R.id.tvCategoryName);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        CategoryDAO dao = new CategoryDAO();

        //Configuração dos elementos que irá ao ListView
        boolean vrfCheckBox = dao.vrfCheckBox(
                context,
                categoria.getId_categoria(),
                Professional.getProfessionalUnico().getId_professional());

        if(vrfCheckBox) {
            holder.cbCategoryCheck.setChecked(vrfCheckBox);
        } else {
            holder.cbCategoryCheck.setChecked(false);
        }

        holder.tvCategoryName.setText(categoria.getNome_categoria());

        return convertView;
    }
}
