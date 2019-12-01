package com.olu.uspparties.fragments.cardsDefault;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.olu.uspparties.R;
import com.olu.uspparties.adapters.FestasAdapter;
import com.olu.uspparties.adapters.IngressosDisponiveisAdapter;
import com.olu.uspparties.models.Festas;
import com.olu.uspparties.models.IngressosDisponiveis;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class CardIngressosDisponiveis extends Fragment {

    IngressosDisponiveisAdapter adapter;
    ListView listViewIngressos;
    private ArrayList<IngressosDisponiveis> listaDeIngressos = new ArrayList<>();
    IngressosDisponiveis cardIngressos;


    public CardIngressosDisponiveis() {

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





        adapter = new IngressosDisponiveisAdapter(getContext(), R.layout.fragment_card_ingressos_disponiveis, listaDeIngressos);
        listViewIngressos.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        return view;
    }
}