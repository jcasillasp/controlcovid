package com.controlfacil.controlcovid.UI;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.controlfacil.controlcovid.Databases.LocalDatabases.TareaRepository;
import com.controlfacil.controlcovid.Databases.Entities.TareaEntity;

import java.util.List;

public class NuevaTareaDialogViewModel extends AndroidViewModel {
    private LiveData<List<TareaEntity>> allNotas;
    private TareaRepository tareaRepository;

    public NuevaTareaDialogViewModel(Application application) {
        super(application);

        tareaRepository = new TareaRepository(application);
        allNotas = tareaRepository.getAll();
    }

    // El fragment que necesita recibir la nueva lista de datos
    public LiveData<List<TareaEntity>> getAllNotas() { return allNotas; }

    // El fragment que inserte una nueva nota, deberá comunicarlo a este ViewModel
    public void insertarNota(TareaEntity nuevaTareaEntity) { tareaRepository.insert(nuevaTareaEntity); }

    public void updateNota(TareaEntity tareaEntity) { tareaRepository.update(tareaEntity); }
}
