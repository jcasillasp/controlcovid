package com.controlfacil.controlcovid.Databases.DAO;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.controlfacil.controlcovid.Databases.Entities.TareaEntity;


import java.util.List;

@Dao
public interface TareaDao {
    @Insert
    void insert(TareaEntity tarea);

    @Update
    void update(TareaEntity tarea);

    @Query("DELETE FROM tareas")
    void deleteAll();

    @Query("DELETE FROM tareas WHERE id = :idTarea")
    void deleteById(int idTarea);

    @Query("SELECT * FROM tareas ORDER BY titulo ASC")
    LiveData<List<TareaEntity>> getAll();

    @Query("SELECT * FROM tareas WHERE favorita LIKE 'true'")
    LiveData<List<TareaEntity>> getAllFavoritas();
}
