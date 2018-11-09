package com.example.felipesavaris.helpmeautoajuda.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.felipesavaris.helpmeautoajuda.Model.Professional;
import com.example.felipesavaris.helpmeautoajuda.Util.ConnectionFactory;
import com.example.felipesavaris.helpmeautoajuda.Util.ToastMakeText;

import java.util.ArrayList;
import java.util.List;

public class ProfessionalDAO {

    public List<Professional> selectProfessionals(Context context,
                                                  int id_categoria) {
        List professionals = new ArrayList<Professional>();
        //Lista dos Id's do profissional da categoria selecionada
        List idProfessionals = new ArrayList(idCategoriaProfessional(
                context,
                id_categoria
        ));

        try {

            final SQLiteDatabase conexao;
            conexao = ConnectionFactory.criarConexao(context);

            String columns[] = {
                    "id_professional",
                    "email",
                    "name",
                    "ficname",
                    "cpf",
                    "cnpj",
                    "address",
                    "fone"
            };

            String where = "";

            for(int i = 0; i < idProfessionals.size(); i++) {
                if(i != 0) {
                    where += " or ";
                }
                where += "id_professional = '" + idProfessionals.get(i) + "'";
            }

            Cursor cursor = conexao.query(
                    "professional",
                    columns,
                    where,
                    null,
                    null,
                    null,
                    null
            );

            while(cursor.moveToNext()) {
                Professional professional = new Professional();

                professional.setId_professional(cursor.getLong(0));
                professional.setEmail(cursor.getString(1));
                professional.setName(cursor.getString(2));
                professional.setFicName(cursor.getString(3));
                professional.setCpf(cursor.getString(4));
                professional.setCnpj(cursor.getString(5));
                professional.setAddress(cursor.getString(6));
                professional.setFone(cursor.getLong(7));

                professionals.add(professional);
            }

            //Fecha a conexão com o banco se aberta
            if(conexao.isOpen()) {
                conexao.close();
            }

            return professionals;

        } catch(SQLException ex) {
            ToastMakeText.makeText(
                    context,
                    "Houve um erro no banco de dados! - " + ex.getMessage()
            );
            return null;
        }
    }

    //Método responsável por retornar os ID's dos profissionais
    private List idCategoriaProfessional(Context context,
                                        int id_categoria) {
        List idProfessional = new ArrayList();

        try {

            final SQLiteDatabase conexao;
            conexao = ConnectionFactory.criarConexao(context);

            String columns[] = {
                    "id_professional"
            };

            String where = "id_categoria = '" + id_categoria + "'";

            Cursor cursor = conexao.query(
                    "categoria_professional",
                    columns,
                    where,
                    null,
                    null,
                    null,
                    null
            );

            while(cursor.moveToNext()) {
                long id = cursor.getLong(0);

                idProfessional.add(id);
            }

            //Fecha a conexão com o banco se aberta
            if(conexao.isOpen()) {
                conexao.close();
            }

            return idProfessional;

        } catch(SQLException ex) {
            ToastMakeText.makeText(
                    context,
                    "Houve um erro no banco de dados! - " + ex.getMessage()
            );
            return null;
        }
    }
}
