package com.nexis.sayitahminoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnbul;
    EditText tahmin;
    TextView yaklasım,klnhak,asilsayi;
    int  sayi,kalanhak = 5,fark;
    String gelenDeger;
    Random randNumara;
    boolean tahminDogrumu = false;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnbul=findViewById(R.id.btnBul);
        tahmin=findViewById(R.id.tahmin);
        yaklasım=findViewById(R.id.yaklasim);
        klnhak=findViewById(R.id.klnhakk);
        asilsayi=findViewById(R.id.asilsayi);

        randNumara = new Random();
        sayi = randNumara.nextInt(100);
        System.out.println("sayi : " + sayi);



        btnbul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gelenDeger=tahmin.getText().toString();
                if(!TextUtils.isEmpty(gelenDeger)){
                    if(kalanhak > 0){
                        if(Integer.parseInt(gelenDeger) > sayi){
                            fark = Integer.parseInt(gelenDeger) - sayi;
                        }else {
                            fark = sayi - Integer.parseInt(gelenDeger);
                        }
                        if(gelenDeger.equals(String.valueOf(sayi))) {
                            sonuc("Tebrikler Doğru Bildiniz");
                            asilsayi.setText("Tahmin Sayısı: " +String.valueOf(sayi));
                            kalanhak--;
                            tahmin.setText("");
                            tahminDogrumu = true;

                        }else if (fark >= 25 ) {
                            yaklasım.setText(  "Sayınız Çok Büyük");
                            tahmin.setText("");
                            kalanhak--;

                        }else if (fark < 25 && fark >=15 ) {
                            yaklasım.setText("Sayınız Büyük");
                            tahmin.setText("");
                            kalanhak--;
                        }else if(fark < 15 && fark >=5){
                            yaklasım.setText( "Yaklaştınız");
                            tahmin.setText("");
                            kalanhak--;
                        }else if(fark < 5){
                            yaklasım.setText("Çok Yaklaştınız");
                            tahmin.setText("");
                            kalanhak--;
                        }

                        klnhak.setText("Kalan Hak:" + kalanhak);

                        if(kalanhak == 0 && tahminDogrumu == false) {
                           sonuc("tahmin hakkınız bitti");
                            asilsayi.setText("Tahmin Sayısı: " +String.valueOf(sayi));
                        }


                    }else
                        yaklasım.setText("Oyun Bitti");
                }else
                    yaklasım.setText("Girilen Değer Boş Olamaz");

            }

            private void sonuc(String mesaj) {
                tahmin.setEnabled(false);
                yaklasım.setText(mesaj);

            }


        });


    }
}