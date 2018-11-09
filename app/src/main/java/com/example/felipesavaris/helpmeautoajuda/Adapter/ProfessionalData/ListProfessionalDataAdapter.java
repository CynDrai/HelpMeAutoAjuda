package com.example.felipesavaris.helpmeautoajuda.Adapter.ProfessionalData;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.felipesavaris.helpmeautoajuda.Model.Professional;
import com.example.felipesavaris.helpmeautoajuda.R;

import java.util.List;

public class ListProfessionalDataAdapter extends BaseAdapter {

    private LayoutInflater mLayoutInflater;
    private List<Professional> professionaLst;

    public ListProfessionalDataAdapter(Context context, List<Professional> professionalLst) {
        this.mLayoutInflater = mLayoutInflater.from(context);
        this.professionaLst = professionalLst;
    }

    @Override
    public int getCount() {
        return this.professionaLst.size();
    }

    @Override
    public Object getItem(int position) {
        return this.professionaLst.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.professionaLst.get(position).getId_professional();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Elementos que serão implementados no ListView
        final ViewHolder HOLDER;

        //Instância do Professional que será colocada no ListView
        final Professional PROFESSIONAL = (Professional) getItem(position);

        if(convertView == null) {

            //Inicialização do XML listview_professional_data
            convertView = this.mLayoutInflater.inflate(R.layout.listview_professional_data, null);
            HOLDER = new ViewHolder();

            //Inicialização dos elementos no XML
            //Nome do Profissional
            HOLDER.tvNameLabel = convertView.findViewById(R.id.tvNameLabel);
            HOLDER.tvNameProfessional = convertView.findViewById(R.id.tvNameProfessional);

            //Nome Fícticio do Profissional
            HOLDER.tvNameFicLabel = convertView.findViewById(R.id.tvNameFicLabel);
            HOLDER.tvNameFictional = convertView.findViewById(R.id.tvNameFictional);

            //E-mail do Profissional
            HOLDER.tvEmailLabel = convertView.findViewById(R.id.tvEmailLabel);
            HOLDER.tvEmailProfessional = convertView.findViewById(R.id.tvEmailProfessional);

            //Cpf do Profissional
            HOLDER.tvCpfLabel = convertView.findViewById(R.id.tvCpfLabel);
            HOLDER.tvCpfProfessional = convertView.findViewById(R.id.tvCpfProfessional);

            //Cnpj do Profissional
            HOLDER.tvCnpjLabel = convertView.findViewById(R.id.tvCnpjLabel);
            HOLDER.tvCnpjProfessional = convertView.findViewById(R.id.tvCnpjProfessional);

            //Endereço do Profissional
            HOLDER.tvAddressLabel = convertView.findViewById(R.id.tvAddressLabel);
            HOLDER.tvAddressProfessional = convertView.findViewById(R.id.tvAddressProfessional);

            //Telefone do Profissional
            HOLDER.tvFoneLabel = convertView.findViewById(R.id.tvFoneLabel);
            HOLDER.tvFoneProfessional = convertView.findViewById(R.id.tvFoneProfessional);

            convertView.setTag(HOLDER);
        } else {
            HOLDER = (ViewHolder) convertView.getTag();
        }

        //Set nome do profissional
        HOLDER.tvNameLabel.setText("Nome: ");
        HOLDER.tvNameProfessional.setText(PROFESSIONAL.getName());

        //Set nome Fícticio do profissional
        HOLDER.tvNameFicLabel.setText("Nome Fantasia: ");
        HOLDER.tvNameFictional.setText(PROFESSIONAL.getFicName());

        //Set E-mail do profissional
        HOLDER.tvEmailLabel.setText("E-mail: ");
        HOLDER.tvEmailProfessional.setText(PROFESSIONAL.getEmail());

        //Set Cpf do profissional
        HOLDER.tvCpfLabel.setText("CPF: ");
        HOLDER.tvCpfProfessional.setText(PROFESSIONAL.getCpf());

        //Set CNPJ do profissional
        HOLDER.tvCnpjLabel.setText("CNPJ: ");
        if(PROFESSIONAL.getCnpj().isEmpty() || PROFESSIONAL.getCnpj() == null) {
            HOLDER.tvCnpjProfessional.setText("Não existe CNPJ para este Profissional");
        } else {
            HOLDER.tvCnpjProfessional.setText(PROFESSIONAL.getCnpj());
        }

        //Set Endereço do Profissional
        HOLDER.tvAddressLabel.setText("Endereço: ");
        HOLDER.tvAddressProfessional.setText(PROFESSIONAL.getAddress());

        //Set Fone do Profissional
        String fone = PROFESSIONAL.getFone() + "";
        HOLDER.tvFoneLabel.setText("Telefone: ");
        HOLDER.tvFoneProfessional.setText(fone);

        return convertView;
    }
}
