package com.example.staticfragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

/**
 * Created by usuario on 16/11/17.
 */

public class FragmentA extends Fragment {

    private FragmentAListener mCallBack;

    // Obtener Views
    EditText edT_TextoAMostrar;
    Button btn_CambiarFontSize;
    SeekBar skB_fontSize;

    // Interfaz que será contrato entre Fragment y Activity
    public interface FragmentAListener {

        void onFragmentAEvent(String msg, int size);
    }


    //region Método sin usar, onAttach(context)
     /* Este método solo funciona con > API 23
     * No da error en APIs anteriores, PERO NO COMUNICA CON ACTIVITY
     *
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
    */
    //endregion

    /**onAttach
     * Aunque esté deprecado, lo usaremos por tener API mínima 21
     *
     * @param activity
     */
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mCallBack = (FragmentAListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement FragmentAListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragmenta, container, false);

        edT_TextoAMostrar = (EditText) view.findViewById(R.id.edT_Texto);
        btn_CambiarFontSize = (Button) view.findViewById(R.id.btn_CambiarSize);
        skB_fontSize = (SeekBar) view.findViewById(R.id.skB_fontSize);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btn_CambiarFontSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mCallBack.onFragmentAEvent(edT_TextoAMostrar.getText().toString(),
                        skB_fontSize.getProgress());
            }
        });
    }
}
