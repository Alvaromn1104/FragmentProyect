package com.alvaromn1104.misaficiones;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class SobreMiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_sobre_mi);

        SharedPreferences sharedPreferences = getSharedPreferences("MisAficionesPrefs", MODE_PRIVATE);
        String favoritos = sharedPreferences.getString("favoritos", "");
        ArrayList<String> listaFavoritos = new ArrayList<>();

        if (!favoritos.isEmpty()) {
            listaFavoritos = new ArrayList<>(Arrays.asList(favoritos.split(",")));
        }
        TextView textView = findViewById(R.id.text_favoritos);
        if (!listaFavoritos.isEmpty()) {
            textView.setText(String.join("\n", listaFavoritos));
        } else {
            textView.setText("No hay favoritos aún");
        }
    }
}