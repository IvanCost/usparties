package com.olu.uspparties.fragments.onBoarding;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.olu.uspparties.R;
import com.olu.uspparties.activities.onBoarding.CadastroVendedor;

import org.w3c.dom.Text;

public class LoginVendedor extends Fragment {

    private TextView tviCadastrar;


    public LoginVendedor() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login_vendedor, container, false);

        Toolbar toolbar = getActivity().findViewById(R.id.toolbar_principal);
        toolbar.setVisibility(View.GONE);

        tviCadastrar = view.findViewById(R.id.naoTemConta);

        tviCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getActivity(), CadastroVendedor.class);
                startActivity(i);
            }
        });

        return view;
    }

}