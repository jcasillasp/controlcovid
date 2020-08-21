package com.controlfacil.controlcovid.API.Services;

import com.controlfacil.controlcovid.Models.Tarea;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TareasService {
    @GET("tareas_usuario_detalle")
    Call<List<Tarea>> getTareasAll(@Query("campos") String cuales);
}
