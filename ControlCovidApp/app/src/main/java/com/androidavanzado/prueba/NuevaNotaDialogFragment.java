package com.androidavanzado.prueba;

import android.app.Dialog;
import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;

import com.androidavanzado.prueba.db.entity.NotaEntity;

public class NuevaNotaDialogFragment extends DialogFragment {

    public static NuevaNotaDialogFragment newInstance() {
        return new NuevaNotaDialogFragment();
    }
    private View view;
    private EditText etTitulo, etContenido;
    private RadioGroup rgColor;
    private Switch swNotaFavorita;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Nueva Tarea");
        builder.setMessage("Descripción")
                .setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        String titulo = etTitulo.getText().toString();
                        String contenido = etContenido.getText().toString();
                        String color = "azul";
                        switch (rgColor.getCheckedRadioButtonId()) {
                            case R.id.radioButtonColorRojo:
                                color = "rojo"; break;
                            case R.id.radioButtonColorVerde:
                                color = "verde"; break;
                        }

                        boolean esFavorita = swNotaFavorita.isChecked();

                        // Comunicar al ViewModel el nuevo dato.
                        NuevaNotaDialogViewModel mViewModel = ViewModelProviders.of(getActivity()).get(NuevaNotaDialogViewModel.class);
                        mViewModel.insertarNota(new NotaEntity(titulo, contenido, esFavorita, color));
                        dialog.dismiss();

                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });

        LayoutInflater inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.nueva_nota_dialog_fragment, null);

        etTitulo = view.findViewById(R.id.editTextTitulo);
        etContenido = view.findViewById(R.id.editTextContenido);
        rgColor = view.findViewById(R.id.radioGroupColor);
        swNotaFavorita = view.findViewById(R.id.switchNotaFavorita);

        builder.setView(view);

        // Create the AlertDialog object and return it
        return builder.create();
    }

}
