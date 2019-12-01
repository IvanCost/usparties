package com.olu.uspparties.activities.info;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.olu.uspparties.R;

public class DetalhesIngresso extends AppCompatActivity {

    Button btnBack;
    TextView localVenda, valorVenda, quantidadeIngressos, emailVendedor, whatsappVendedor, detalhesAdicionais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_ingresso);

        Toolbar toolbar = findViewById(R.id.toolbar_principal);
        toolbar.setTitle("Detalhes da Venda");

        btnBack = findViewById(R.id.btn_back);
        btnBack.setVisibility(View.VISIBLE);

        localVenda = findViewById(R.id.localVenda);
        valorVenda = findViewById(R.id.precoVenda);
        quantidadeIngressos = findViewById(R.id.quantidadeVenda);
        emailVendedor = findViewById(R.id.emailVendedor);
        whatsappVendedor = findViewById(R.id.telefoneVendedor);
        detalhesAdicionais = findViewById(R.id.editDetalhesAdicionais);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DetalhesIngresso.super.onBackPressed();
            }
        });

        preencheDadosIngresso();

        whatsappVendedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWhatsapp(whatsappVendedor.getText().toString());
            }
        });

        emailVendedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEmail(emailVendedor.getText().toString());
            }
        });
    }

    private void preencheDadosIngresso(){
        localVenda.setText("Butantã - Campus FEA");
        valorVenda.setText("R$ 50,00");
        quantidadeIngressos.setText("2 ingressos disponívels");
        emailVendedor.setText("ivancosta@usp.br");
        whatsappVendedor.setText("11 989535999");
        detalhesAdicionais.setText("Nesse campo o usuário poderá colocar detalhes da venda, como local de entrega de ingresso, formas de pagamento e etc");
    }

    private void openWhatsapp (String contato){

        String contatoCompleto = "+55"+contato;

        String url = "https://api.whatsapp.com/send?phone=" + contatoCompleto;
        try {
            PackageManager pm = getApplicationContext().getPackageManager();
            pm.getPackageInfo("com.whatsapp", PackageManager.GET_ACTIVITIES);
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        } catch (PackageManager.NameNotFoundException e) {
            Toast.makeText(getApplicationContext(), "Você não tem o whatsapp instalado no seu celular", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    private void openEmail (String emailToSend){

        Intent email = new Intent(Intent.ACTION_SENDTO);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{ emailToSend});
        startActivity(Intent.createChooser(email, "Escolha um aplicativo para enviar e-mails:"));
    }
}
