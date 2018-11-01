package com.example.felipesavaris.helpmeautoajuda.Adapter.CategoriesProfessional;

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
import com.example.felipesavaris.helpmeautoajuda.Util.ToastMakeText;

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
        final ViewHolder holder;

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

        //Configuração dos elementos que irá ao ListView
        CategoryDAO dao = new CategoryDAO();

        //SELECT
        final boolean vrfCheckBox = dao.vrfCheckBox(
                context,
                categoria.getId_categoria(),
                Professional.getProfessionalUnico().getId_professional());

        //Coloca as categorias já cadastradas pelo profissional como ativadas
        if(vrfCheckBox) {
            holder.cbCategoryCheck.setChecked(vrfCheckBox);
        } else {
            holder.cbCategoryCheck.setChecked(false);
        }

        //Insere no TextView o nome da Categoria
        holder.tvCategoryName.setText(categoria.getNome_categoria());

        //Classe responsável por interagir com as CheckBox em tempo real
        holder.cbCategoryCheck.setOnClickListener(new View.OnClickListener() {

            //Método Acionado no momento que clicar no CheckBox
            @Override
            public void onClick(View v) {

                    String message = "";

                    //Caso o CheckBox esteja Marcado
                    if(holder.cbCategoryCheck.isChecked()) {
                        CategoryDAO dao = new CategoryDAO();

                        //INSERT
                        if(dao.insertCategoriaProfessional(
                                context,
                                categoria.getId_categoria(),
                                Professional.getProfessionalUnico().getId_professional()) != -1) {

                            message = "Cadastrado na categoria " + categoria.getNome_categoria();

                        } else message = null;
                    }

                    //Caso o CheckBox seja Desmarcado
                    if(!holder.cbCategoryCheck.isChecked()) {
                        CategoryDAO dao = new CategoryDAO();

                        //DELETE
                        if(dao.deleteProfessionalCategoria(
                                context,
                                categoria.getId_categoria(),
                                Professional.getProfessionalUnico().getId_professional()) != - 1) {

                            message = "Retirado registro da categoria " + categoria.getNome_categoria();

                        } else message = null;
                    }

                    if(message != null) {
                        ToastMakeText.makeText(
                                context,
                                message
                        );
                    }
                //Faz a alteração no Adapter
                notifyDataSetChanged();
            }
        });

        return convertView;
    }
}
