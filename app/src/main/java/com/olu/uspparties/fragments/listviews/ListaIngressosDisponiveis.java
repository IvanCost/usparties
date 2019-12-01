package com.olu.uspparties.fragments.listviews;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.olu.uspparties.R;
import com.olu.uspparties.activities.info.DetalhesIngresso;
import com.olu.uspparties.adapters.FestasAdapter;
import com.olu.uspparties.adapters.IngressosDisponiveisAdapter;
import com.olu.uspparties.models.Festas;
import com.olu.uspparties.models.IngressosDisponiveis;

import java.util.ArrayList;

public class ListaIngressosDisponiveis extends Fragment {

    IngressosDisponiveisAdapter adapter;
    ListView listViewIngressos;
    private ArrayList<com.olu.uspparties.models.IngressosDisponiveis> listaDeIngressos = new ArrayList<>();
    IngressosDisponiveis cardIngressos;
    IngressosDisponiveis cardIngressosDois;
    IngressosDisponiveis cardIngressosTres;

    public ListaIngressosDisponiveis() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_ingressos_disponiveis, container, false);

        listViewIngressos = view.findViewById(R.id.listViewIngressosDisponiveis);

        cardIngressos = new IngressosDisponiveis();
        cardIngressos.setEnderecoVenda("Butantã - Campus FEA");
        cardIngressos.setValorVenda("R$ 50,00");
        cardIngressos.setQuantidadeDisponivel("2 ingressos disponíveis");
        listaDeIngressos.add(cardIngressos);

        cardIngressosDois = new IngressosDisponiveis();
        cardIngressosDois.setEnderecoVenda("USP Leste - EACH");
        cardIngressosDois.setValorVenda("R$ 40,00");
        cardIngressosDois.setQuantidadeDisponivel("1 ingresso disponível");
        listaDeIngressos.add(cardIngressosDois);

        cardIngressosTres = new IngressosDisponiveis();
        cardIngressosTres.setEnderecoVenda("Butantã - Campus IME");
        cardIngressosTres.setValorVenda("R$ 20,00");
        cardIngressosTres.setQuantidadeDisponivel("5 ingressos disponíveis");
        listaDeIngressos.add(cardIngressosTres);

        adapter = new IngressosDisponiveisAdapter(getContext(), R.layout.fragment_card_ingressos_disponiveis, listaDeIngressos);
        listViewIngressos.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        listViewIngressos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), DetalhesIngresso.class);
                startActivity(intent);
            }
        });

        return view;
    }
}