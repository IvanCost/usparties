package com.olu.uspparties.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.olu.uspparties.R;
import com.olu.uspparties.activities.info.DetalhesFesta;
import com.olu.uspparties.activities.info.Ingressos;
import com.olu.uspparties.fragments.cardsDefault.CardFesta;
import com.olu.uspparties.models.Festas;

import java.util.List;

public class FestasAdapter extends ArrayAdapter<Festas> {

    public FestasAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Festas> objects) {
        super(context, resource, objects);
    }

    TextView data, hora, nomeDaFesta, endereco, precoLote;
    Festas cardFesta;
    ImageView cartazFesta;
    Button btnComprar, btnVender;


    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (convertView == null) {
            LayoutInflater inf = LayoutInflater.from(getContext());
            v = inf.inflate(R.layout.fragment_card_festa, parent, false);
        }

        cardFesta = getItem(position);

        data = v.findViewById(R.id.tviData);
        hora = v.findViewById(R.id.tviHora);
        endereco = v.findViewById(R.id.tviEndereco);
        precoLote = v.findViewById(R.id.tviPrecoLote);
        nomeDaFesta = v.findViewById(R.id.tviNomeFesta);
        cartazFesta = v.findViewById(R.id.cartazFesta);
        btnComprar = v.findViewById(R.id.btnComprar);
        btnVender = v.findViewById(R.id.btnVender);


        if (cardFesta != null) {

            data.setText(cardFesta.getDataFesta());
            hora.setText(cardFesta.getHoraFesta());
            endereco.setText(cardFesta.getEnderecoFesta());
            precoLote.setText(cardFesta.getPrecoLote());
            nomeDaFesta.setText(cardFesta.getNomeFesta());
            cartazFesta.setImageBitmap(cardFesta.getCartazFesta());
        }

        btnComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), DetalhesFesta.class);
                view.getContext().startActivity(i);
            }
        });

        return v;
    }
}
