package com.olu.uspparties.models;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.olu.uspparties.R;

public class IngressosDisponiveis extends Fragment {

    private String enderecoVenda;
    private String valorVenda;
    private String quantidadeDisponivel;

    public String getEnderecoVenda() {
        return enderecoVenda;
    }

    public void setEnderecoVenda(String enderecoVenda) {
        this.enderecoVenda = enderecoVenda;
    }

    public String getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(String valorVenda) {
        this.valorVenda = valorVenda;
    }

    public String getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(String quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_card_ingressos_disponiveis, container, false);

        return view;
    }

}