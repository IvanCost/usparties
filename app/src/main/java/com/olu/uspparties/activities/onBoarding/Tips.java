package com.olu.uspparties.activities.onBoarding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.olu.uspparties.R;
import com.olu.uspparties.activities.home.Home;
import com.olu.uspparties.adapters.ViewPagerAdapter;

public class Tips extends AppCompatActivity {

    public Button btn_tipsBack;
    public Button btn_TipsGo;
    public ImageView ballone;
    public ImageView balltwo;
    public ImageView ballthree;
    public TextView btn_pular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btn_tipsBack = findViewById(R.id.btn_backTips);
        btn_TipsGo = findViewById(R.id.btn_GoTips);

        ballone = findViewById(R.id.ballone);
        balltwo = findViewById(R.id.balltwo);
        ballthree = findViewById(R.id.ballthree);

        btn_pular = findViewById(R.id.btn_pular);

        FragmentManager fragmentManager = getSupportFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //fragmentTransaction.replace(R.id.viewPager_Cards, new Card_one()).commit();

        final ViewPager viewPager = findViewById(R.id.viewPager_Cards);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));

        viewPager.setPageMargin(100);


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

                if (viewPager.getCurrentItem() == 0) {
                    ballone.setImageResource(R.drawable.ballred);
                    balltwo.setImageResource(R.drawable.ballgrey);
                    ballthree.setImageResource(R.drawable.ballgrey);
                    btn_tipsBack.setVisibility(View.INVISIBLE);
                    btn_TipsGo.setText("Próximo");

                    btn_TipsGo.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            viewPager.setCurrentItem(1);
                        }
                    });
                }

                if (viewPager.getCurrentItem() == 1) {
                    ballone.setImageResource(R.drawable.ballgrey);
                    balltwo.setImageResource(R.drawable.ballred);
                    ballthree.setImageResource(R.drawable.ballgrey);
                    btn_tipsBack.setVisibility(View.VISIBLE);
                    btn_TipsGo.setText("Próximo");

                    btn_tipsBack.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            viewPager.setCurrentItem(0);
                        }
                    });

                    btn_TipsGo.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            viewPager.setCurrentItem(2);
                        }
                    });
                }

                if (viewPager.getCurrentItem() == 2) {
                    ballone.setImageResource(R.drawable.ballgrey);
                    balltwo.setImageResource(R.drawable.ballgrey);
                    ballthree.setImageResource(R.drawable.ballred);
                    btn_TipsGo.setText("Finalizar");

                    btn_tipsBack.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            viewPager.setCurrentItem(1);
                        }
                    });

                    btn_TipsGo.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i = new Intent (getApplicationContext(), Home.class);
                            startActivity(i);
                            finish();
                        }
                    });
                }

            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        btn_pular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (getApplicationContext(), Home.class);
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    public void finish() {
        Intent i = new Intent (getApplicationContext(), Home.class);
        startActivity(i);
        super.finish();
    }

}
