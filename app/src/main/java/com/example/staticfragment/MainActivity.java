package com.example.staticfragment;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends Activity implements FragmentA.FragmentAListener {

    // Generico, Fragment (support)
    private android.app.Fragment frag_B;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frag_B = getFragmentManager().findFragmentById(R.id.frag_FB);
    }


    // Comunicacion entre Fragments: Transacciones
    // FragmentManager gestiona de transacciones

    // Ejemplo con Fragment estático
    @Override
    public void onFragmentAEvent(String msg, int size) {

        // Al ser genérica la instancia, necesita casteo a Fragment B y así llamar
        // al método que cambia contenido y tamaño
        ((FragmentB)frag_B).changeTextSize(msg, size);
    }
}
