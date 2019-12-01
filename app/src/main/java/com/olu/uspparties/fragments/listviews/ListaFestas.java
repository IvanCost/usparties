package com.olu.uspparties.fragments.listviews;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.olu.uspparties.R;
import com.olu.uspparties.activities.info.Ingressos;
import com.olu.uspparties.adapters.FestasAdapter;
import com.olu.uspparties.fragments.cardsDefault.CardFesta;
import com.olu.uspparties.models.Festas;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ArrayList;


public class ListaFestas extends Fragment {

    Festas cardFesta;
    Festas cardFestaDois;
    Festas cardFestaTres;
    Festas cardFestaQuatro;
    Festas cardFestaCinco;
    FestasAdapter adapter;
    ListView listViewFestas;
    private ArrayList<Festas> listaDeFestas = new ArrayList<>();
    Button btnBack;


    public ListaFestas() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_feed, container, false);

        Toolbar toolbar = getActivity().findViewById(R.id.toolbar_principal);
        toolbar.setTitle("Festas");
        toolbar.setVisibility(View.VISIBLE);

        btnBack = getActivity().findViewById(R.id.btn_back);

        btnBack.setBackgroundResource(R.drawable.drink);

        listViewFestas = view.findViewById(R.id.listViewFestas);

        cardFesta = new Festas();
        cardFesta.setCartazFesta(createBitmap("https://images-na.ssl-images-amazon.com/images/I/41RqKN7iblL.jpg"));
        cardFesta.setDataFesta("10 de abril");
        cardFesta.setNomeFesta("GLOW EACH");
        cardFesta.setHoraFesta("11 da noite");
        cardFesta.setEnderecoFesta("Via Matarazzo");
        cardFesta.setPrecoLote("R$ 50,00");
        listaDeFestas.add(cardFesta);

        cardFestaDois = new Festas();
        cardFestaDois.setCartazFesta(createBitmap("https://nit.pt/wp-content/uploads/2018/05/071fdedf699a82efd066299d3df03a64-754x394.jpg"));
        cardFestaDois.setDataFesta("20 de maio");
        cardFestaDois.setNomeFesta("Pancadasi - Tofu Edition");
        cardFestaDois.setHoraFesta("4 da tarde");
        cardFestaDois.setEnderecoFesta("Academicos do Tatuapé");
        cardFestaDois.setPrecoLote("R$ 15,00");
        listaDeFestas.add(cardFestaDois);

        cardFestaTres = new Festas();
        cardFestaTres.setCartazFesta(createBitmap("https://abrilvejario.files.wordpress.com/2018/08/shironosovistock.jpg"));
        cardFestaTres.setDataFesta("22 de junho");
        cardFestaTres.setNomeFesta("Kama Sutra");
        cardFestaTres.setHoraFesta("4 da noite");
        cardFestaTres.setEnderecoFesta("Panelas e Pratos");
        cardFestaTres.setPrecoLote("R$ 10,00");
        listaDeFestas.add(cardFestaTres);

        cardFestaQuatro = new Festas();
        cardFestaQuatro.setCartazFesta(createBitmap("https://img.thedailybeast.com/image/upload/v1510716835/171114-fallon-vice-lede_ntg4hi.jpg"));
        cardFestaQuatro.setDataFesta("30 de agosto");
        cardFestaQuatro.setNomeFesta("Lotus -  Rupals Edition");
        cardFestaQuatro.setHoraFesta("6 da tarde");
        cardFestaQuatro.setEnderecoFesta("Panelas e Prartos");
        cardFestaQuatro.setPrecoLote("R$ 12,00");
        listaDeFestas.add(cardFestaQuatro);

        cardFestaCinco = new Festas();
        cardFestaCinco.setCartazFesta(createBitmap("https://portaldeamericana.com/wp-content/uploads/2018/07/holi.jpg"));
        cardFestaCinco.setDataFesta("25 de setembro");
        cardFestaCinco.setNomeFesta("EACHECA");
        cardFestaCinco.setHoraFesta("11 da noite");
        cardFestaCinco.setEnderecoFesta("ECA - Butantã");
        cardFestaCinco.setPrecoLote("R$ 25,00");
        listaDeFestas.add(cardFestaCinco);

        adapter = new FestasAdapter(getContext(), R.layout.fragment_card_festa, listaDeFestas);
        listViewFestas.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        listViewFestas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });


        return view;
    }

    private Bitmap createBitmap (String urlFoto){

        Bitmap btm = null;
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        URL url = null;

        try {
            url = new URL(urlFoto);
            btm = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return btm;
    }
}