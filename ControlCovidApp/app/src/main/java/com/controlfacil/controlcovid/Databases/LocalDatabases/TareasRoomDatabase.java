package com.controlfacil.controlcovid.Databases.LocalDatabases;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.controlfacil.controlcovid.Databases.DAO.TareaDao;
import com.controlfacil.controlcovid.Databases.Entities.TareaEntity;

@Database(entities = {TareaEntity.class}, version = 1)
public abstract class TareasRoomDatabase extends RoomDatabase {
    public abstract TareaDao tareaDao();
    private static volatile TareasRoomDatabase INSTANCE;

    public static TareasRoomDatabase getDatabase(final Context context) {
        if(INSTANCE == null) {
            synchronized (TareasRoomDatabase.class) {
                if(INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            TareasRoomDatabase.class, "tareas_database")
                            .build();
                }
            }
        }

        return INSTANCE;
    }
}
