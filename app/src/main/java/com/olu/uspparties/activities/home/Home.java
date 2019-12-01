package com.olu.uspparties.activities.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.olu.uspparties.R;
import com.olu.uspparties.fragments.listviews.ListaFestas;
import com.olu.uspparties.fragments.listviews.ListaMinhasVendas;
import com.olu.uspparties.fragments.onBoarding.LoginVendedor;

public class Home extends AppCompatActivity {
    Button btnBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnBack = findViewById(R.id.btn_back);

        Toolbar toolbar = findViewById(R.id.toolbar_principal);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace( R.id.homeViewPager, new ListaFestas()).commit();

        configuraButtomNav();

    }

    private void configuraButtomNav (){

        BottomNavigationView bottomNavigationView = findViewById( R.id.bottom_navigation_feed );

        habilitarNavegacao( bottomNavigationView );
    }

    private void habilitarNavegacao(BottomNavigationView view){
        view.setOnNavigationItemSelectedListener( new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                switch (item.getItemId()){
                    case R.id.icon_novos:
                        fragmentTransaction.replace( R.id.homeViewPager, new ListaFestas()).commit();
                        return true;

                    case R.id.icon_aceitos:
                        fragmentTransaction.replace( R.id.homeViewPager, new ListaMinhasVendas()).commit();
                        return true;

                    case R.id.icon_realizados:
                        fragmentTransaction.replace( R.id.homeViewPager, new LoginVendedor()).commit();
                        return true;
                }

                return false;
            }
        } );
    }
}
