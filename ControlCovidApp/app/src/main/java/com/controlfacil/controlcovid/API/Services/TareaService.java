package com.controlfacil.controlcovid.API.Services;

import com.controlfacil.controlcovid.Models.Tarea;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TareaService {
    @GET("tareas_usuario_detalle")
    Call<List<Tarea>> listRepos(@Path("id_persona") String user);
}
