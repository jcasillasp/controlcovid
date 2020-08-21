package com.controlfacil.controlcovid.API;

import com.controlfacil.controlcovid.API.Deserializers.TareaDeserializer;
import com.controlfacil.controlcovid.Models.Tarea;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Jesus Casillas on 20/08/20.
 */

public class TareasAPI {

    public static final String BASE_URL = "http://server.controlcovid.com.mx:8082/rest_userAdmin/tareas_usuario_detalle";
    private static Retrofit retrofit = null;

    public static Retrofit getApi(){
        if (retrofit == null) {

            GsonBuilder builder = new GsonBuilder();
            builder.registerTypeAdapter(Tarea.class, new TareaDeserializer());

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(builder.create()))
                    .build();
        }
        return retrofit;
    }
}