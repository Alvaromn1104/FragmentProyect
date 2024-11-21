package com.alvaromn1104.misaficiones.ui.fragments;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.alvaromn1104.misaficiones.fr.aficones.Comer;
import com.alvaromn1104.misaficiones.fr.aficones.Dormir;
import com.alvaromn1104.misaficiones.fr.aficones.Entrenar;
import com.alvaromn1104.misaficiones.fr.aficones.Estudiar;

public class Paginador extends FragmentPagerAdapter {

    private final Context mContext;

    public Paginador(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){

            case 0:
                return new Comer();
            case 1:
                return new Dormir();
            case 2:
                return new Entrenar();
            case 3:
                return new Estudiar();
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
