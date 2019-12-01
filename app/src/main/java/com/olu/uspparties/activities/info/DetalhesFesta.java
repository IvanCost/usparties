package com.olu.uspparties.activities.info;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.olu.uspparties.R;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class DetalhesFesta extends AppCompatActivity {

    Button btnBack;
    Button btnComprar, btnVender;
    ImageView fotoDaFesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_festa);

        Toolbar toolbar = findViewById(R.id.toolbar_principal);
        toolbar.setTitle("Detalhes da Festa");

        btnBack = findViewById(R.id.btn_back);
        btnBack.setVisibility(View.VISIBLE);
        btnComprar = findViewById(R.id.btnComprar);
        btnVender = findViewById(R.id.btnVender);
        fotoDaFesta = findViewById(R.id.fotoDaFesta);

        fotoDaFesta.setImageBitmap(createBitmap("https://images-na.ssl-images-amazon.com/images/I/41RqKN7iblL.jpg"));

        btnComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Ingressos.class);
                view.getContext().startActivity(i);
            }
        });

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
