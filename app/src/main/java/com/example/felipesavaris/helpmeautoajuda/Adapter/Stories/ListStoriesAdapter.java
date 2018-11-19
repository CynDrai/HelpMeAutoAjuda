package com.example.felipesavaris.helpmeautoajuda.Adapter.Stories;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.felipesavaris.helpmeautoajuda.CommentsActivity;
import com.example.felipesavaris.helpmeautoajuda.DAO.StoryDAO;
import com.example.felipesavaris.helpmeautoajuda.Model.Story;
import com.example.felipesavaris.helpmeautoajuda.R;

import java.util.ArrayList;
import java.util.List;

public class ListStoriesAdapter extends BaseAdapter {

    private LayoutInflater mLayoutInflater;
    private List<Story> stories;
    private Context context;
    private String name;

    public ListStoriesAdapter(Context context, List<Story> categories) {
        this.mLayoutInflater = mLayoutInflater.from(context);
        this.stories = new ArrayList<>(categories);
        this.context = context;
    }

    @Override
    public int getCount() {
        return stories.size();
    }

    @Override
    public Object getItem(int position) {
        return stories.get(position);
    }

    @Override
    public long getItemId(int position) {
        return stories.get(position).getId_story();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Elementos a serem implementados no ListView
        final ViewHolder HOLDER;

        //Instância do Story que será colocada no ListView
        final Story STORY = (Story) getItem(position);

        if(convertView == null) {

            //Inicialização do XML listview_stories
            convertView = mLayoutInflater.inflate(R.layout.listview_stories, null);
            HOLDER = new ViewHolder();

            //Inicialização dos elementos no XML
            HOLDER.tvNameUser = convertView.findViewById(R.id.tvNameUser);
            HOLDER.tvStory = convertView.findViewById(R.id.tvStory);

            convertView.setTag(HOLDER);
        } else {
            HOLDER = (ViewHolder) convertView.getTag();
        }

        StoryDAO dao = new StoryDAO();

        //SELECT Nome de Usuário da Story
        this.name = dao.selectStoryUser(
                context,
                STORY.getId_usuario()
        );

        //Insere no TextView o Nome do Usuário que fez o Relato
        HOLDER.tvNameUser.setText(this.name);

        //Insere no TextView o Relato feito pelo Usuário
        HOLDER.tvStory.setText(STORY.getStory());

        //Quando o Item do ListView for Selecionado
        convertView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent it = new Intent(
                        context,
                        CommentsActivity.class
                );

                it.putExtra("ID_STORY", STORY.getId_story());
                it.putExtra("ID_USUARIO", STORY.getId_usuario());
                it.putExtra("ID_CATEGORIA", STORY.getId_categoria());
                it.putExtra("STORY", STORY.getStory());
                it.putExtra("NAME_USER", name);
                context.startActivity(it);
            }
        });

        return convertView;
    }
}
