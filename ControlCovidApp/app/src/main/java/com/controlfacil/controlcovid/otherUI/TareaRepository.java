package com.controlfacil.controlcovid.otherUI;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.controlfacil.controlcovid.db.dao.TareaDao;
import com.controlfacil.controlcovid.db.database.TareasRoomDatabase;
import com.controlfacil.controlcovid.db.entities.TareaEntity;

import java.util.List;

public class TareaRepository {
    private TareaDao tareaDao;
    private LiveData<List<TareaEntity>> allNotas;
    private LiveData<List<TareaEntity>> allNotasFavoritas;

    public TareaRepository(Application application) {
        TareasRoomDatabase db = TareasRoomDatabase.getDatabase(application);
        tareaDao = db.tareaDao();
        allNotas = tareaDao.getAll();
        allNotasFavoritas = tareaDao.getAllFavoritas();
    }

    public LiveData<List<TareaEntity>> getAll() { return allNotas; }

    public LiveData<List<TareaEntity>> getAllFavs() { return allNotasFavoritas; }

    public void insert (TareaEntity nota) {
        new insertAsyncTask(tareaDao).execute(nota);
    }

    private static class insertAsyncTask extends AsyncTask<TareaEntity, Void, Void> {
        private TareaDao notaDatoAsyncTask;

        insertAsyncTask(TareaDao dao) {
            notaDatoAsyncTask = dao;
        }

        @Override
        protected Void doInBackground(TareaEntity... notaEntities) {
            notaDatoAsyncTask.insert(notaEntities[0]);
            return null;
        }
    }

    public void update (TareaEntity nota) {
        new updateAsyncTask(tareaDao).execute(nota);
    }

    private static class updateAsyncTask extends AsyncTask<TareaEntity, Void, Void> {
        private TareaDao notaDatoAsyncTask;

        updateAsyncTask(TareaDao dao) {
            notaDatoAsyncTask = dao;
        }

        @Override
        protected Void doInBackground(TareaEntity... notaEntities) {
            notaDatoAsyncTask.update(notaEntities[0]);
            return null;
        }
    }
}
