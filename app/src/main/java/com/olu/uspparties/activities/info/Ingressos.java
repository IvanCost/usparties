package com.olu.uspparties.activities.info;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.olu.uspparties.R;
import com.olu.uspparties.fragments.listviews.ListaFestas;
import com.olu.uspparties.fragments.listviews.ListaIngressosDisponiveis;

public class Ingressos extends AppCompatActivity {

    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingressos);

        Toolbar toolbar = findViewById(R.id.toolbar_principal);
        toolbar.setTitle("Ingressos Disponíveis");

        btnBack = findViewById(R.id.btn_back);
        btnBack.setVisibility(View.VISIBLE);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ingressos.super.onBackPressed();
            }
        });

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace( R.id.viewPagerIngressos, new ListaIngressosDisponiveis()).commit();
    }
}
