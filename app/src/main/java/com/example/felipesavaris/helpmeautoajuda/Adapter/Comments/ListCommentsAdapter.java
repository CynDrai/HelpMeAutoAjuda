package com.example.felipesavaris.helpmeautoajuda.Adapter.Comments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.felipesavaris.helpmeautoajuda.DAO.CommentDAO;
import com.example.felipesavaris.helpmeautoajuda.Model.Comment;
import com.example.felipesavaris.helpmeautoajuda.R;

import java.util.List;

public class ListCommentsAdapter extends BaseAdapter {

    private LayoutInflater mLayoutInflater;
    private List<Comment> comments;
    private Context context;

    public ListCommentsAdapter(Context context, List<Comment> comments) {
        this.mLayoutInflater = mLayoutInflater.from(context);
        this.comments = comments;
        this.context = context;
    }

    @Override
    public int getCount() {
        return comments.size();
    }

    @Override
    public Object getItem(int position) {
        return comments.get(position);
    }

    @Override
    public long getItemId(int position) {
        return comments.get(position).getId_comment();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Elementos que serão Implementados no ListView
        final ViewHolder HOLDER;

        //Instância do Comment que será colocada no ListView
        final Comment COMMENT = (Comment) getItem(position);

        if(convertView == null) {

            //Inicialização do XML listview_comments
            convertView = this.mLayoutInflater.inflate(R.layout.listview_comments, null);
            HOLDER = new ViewHolder();

            //Inicialização dos elementos no XML
            HOLDER.tvUserComment = convertView.findViewById(R.id.tvUserComment);
            HOLDER.tvComment = convertView.findViewById(R.id.tvComment);

            convertView.setTag(HOLDER);
        } else {
            HOLDER = (ViewHolder) convertView.getTag();
        }

        CommentDAO dao = new CommentDAO();

        String name = dao.selectCommentUser(
                context,
                COMMENT.getId_usuario()
        );

        //Insere no TextView o Usuário que fez o Comentário
        HOLDER.tvUserComment.setText(name);

        //Insere no TextView o comentário do Usuário
        HOLDER.tvComment.setText(COMMENT.getComment());

        return convertView;
    }
}
