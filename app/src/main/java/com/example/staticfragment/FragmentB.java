package com.example.staticfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by usuario on 16/11/17.
 */

public class FragmentB extends Fragment {

    TextView txtV_textoACambiar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragmentb, container, false);

        // Obtener View para modificar
        txtV_textoACambiar = view.findViewById(R.id.txtV_TextoCambiado);

        return view;

    }

    public void changeTextSize(String text, int size) {

        txtV_textoACambiar.setText(text);
        txtV_textoACambiar.setTextSize(size);
    }
}
