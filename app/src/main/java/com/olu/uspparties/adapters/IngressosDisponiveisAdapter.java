package com.olu.uspparties.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.olu.uspparties.R;
import com.olu.uspparties.models.Festas;
import com.olu.uspparties.models.IngressosDisponiveis;

import java.util.List;

public class IngressosDisponiveisAdapter extends ArrayAdapter<IngressosDisponiveis> {

    public IngressosDisponiveisAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<IngressosDisponiveis> objects) {
        super(context, resource, objects);
    }

    TextView precoVenda, enderecoVenda, quantidadeDisponivel;
    IngressosDisponiveis cardIngressosDisponiveis;


    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (convertView == null) {
            LayoutInflater inf = LayoutInflater.from(getContext());
            v = inf.inflate(R.layout.fragment_card_ingressos_disponiveis, parent, false);
        }

        cardIngressosDisponiveis = getItem(position);

        precoVenda = v.findViewById(R.id.precoVenda);
        enderecoVenda = v.findViewById(R.id.localVenda);
        quantidadeDisponivel = v.findViewById(R.id.quantidadeVenda);


        if (cardIngressosDisponiveis != null) {

           precoVenda.setText(cardIngressosDisponiveis.getValorVenda());
           enderecoVenda.setText(cardIngressosDisponiveis.getEnderecoVenda());
           quantidadeDisponivel.setText(cardIngressosDisponiveis.getQuantidadeDisponivel());
        }

        return v;
    }
}
