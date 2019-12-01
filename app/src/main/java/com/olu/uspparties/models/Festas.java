package com.olu.uspparties.models;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.olu.uspparties.R;

public class Festas extends Fragment {

    private String nomeFesta;
    private String dataFesta;
    private String horaFesta;
    private String enderecoFesta;
    private String precoLote;
    private Bitmap cartazFesta;

    public Bitmap getCartazFesta() {
        return cartazFesta;
    }

    public void setCartazFesta(Bitmap cartazFesta) {
        this.cartazFesta = cartazFesta;
    }

    public String getNomeFesta() {
        return nomeFesta;
    }

    public void setNomeFesta(String nomeFesta) {
        this.nomeFesta = nomeFesta;
    }

    public String getDataFesta() {
        return dataFesta;
    }

    public void setDataFesta(String dataFesta) {
        this.dataFesta = dataFesta;
    }

    public String getHoraFesta() {
        return horaFesta;
    }

    public void setHoraFesta(String horaFesta) {
        this.horaFesta = horaFesta;
    }

    public String getEnderecoFesta() {
        return enderecoFesta;
    }

    public void setEnderecoFesta(String enderecoFesta) {
        this.enderecoFesta = enderecoFesta;
    }

    public String getPrecoLote() {
        return precoLote;
    }

    public void setPrecoLote(String precoLote) {
        this.precoLote = precoLote;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_card_festa, container, false);

        return view;
    }

}