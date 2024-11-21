package com.alvaromn1104.misaficiones;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.alvaromn1104.misaficiones.databinding.ActivityAficionesBinding;
import com.alvaromn1104.misaficiones.ui.fragments.Paginador;

public class Aficiones extends AppCompatActivity {

    private ActivityAficionesBinding binding;
    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAficionesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedPreferences = getSharedPreferences("MisAficionesPrefs", MODE_PRIVATE);


        Paginador paginador = new Paginador(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(paginador);

    }

    @Override
    protected void onStop() {
        super.onStop();

        sharedPreferences.edit().clear().apply();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_about_me, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.favButton){
            int currentItem = binding.viewPager.getCurrentItem();
            String textAñadido="";

            if(currentItem == 0){
                textAñadido="Me gusta comer";
            }else if(currentItem==1){
                textAñadido="Me gusta dormir";
            }else if(currentItem==2){
                textAñadido="Me gusta Entrenar";
            }else if(currentItem==3){
                textAñadido="No me gusta estudiar";
            }

            String favoritos = sharedPreferences.getString("favoritos", "");
            if (!favoritos.isEmpty()) {
                favoritos += ",";
            }
            favoritos += textAñadido;

            sharedPreferences.edit().putString("favoritos", favoritos).apply();

            Toast.makeText(this, "Añadido a favoritos: " + textAñadido, Toast.LENGTH_SHORT).show();
            return true;
        }

        if(id == R.id.aboutMeButton){
            Intent intent = new Intent(Aficiones.this, SobreMiActivity.class);
            startActivity(intent);
            return true;
        }
        if(id == R.id.myCodeButton){
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://github.com/Alvaromn1104"));
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}