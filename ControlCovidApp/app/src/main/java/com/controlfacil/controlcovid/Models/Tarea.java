package com.controlfacil.controlcovid.Models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Tarea {
    @SerializedName("ID_TAREA")
    private int     idTarea;
    @SerializedName("NOMBRE_REGLA")
    private String  nombreTarea;
    @SerializedName("NOMBRE_REGLA_LARGO")
    private String  descripcionTarea;
    @SerializedName("TIEMPO")
    private String  tiempoTarea;
    @SerializedName("COLOR")
    private int     tareaColor;
    @SerializedName("JSON_AUX")
    private List<String> tareaLinks;
    @SerializedName("STATUS")
    private String  tareaStatus;
    @SerializedName("ID_CONTROL")
    private String tareaIdControl;
    @SerializedName("ID_PERSONA")
    private int     idPersona;
    @SerializedName("NOM_PERSONA")
    private String  nomPersona;
    @SerializedName("CORREO")
    private String  emailPersona;
    @SerializedName("ID_EMPRESA")
    private String  nombreEmpresa;
    @SerializedName("ID_ROLE")
    private int     idRole;
    @SerializedName("NOMBRE_ROLE")
    private String  nombreRole;

    public Tarea() {
    }

    public Tarea(int idTarea, String nombreTarea, String descripcionTarea, String tiempoTarea,
                 int tareaColor, List<String> tareaLinks, String tareaStatus, String tareaIdControl,
                 int idPersona, String nomPersona, String emailPersona, String nombreEmpresa, int idRole, String nombreRole)
    {
        this.idTarea = idTarea;
        this.nombreTarea = nombreTarea;
        this.descripcionTarea = descripcionTarea;
        this.tiempoTarea = tiempoTarea;
        this.tareaColor = tareaColor;
        this.tareaLinks = tareaLinks;
        this.tareaStatus = tareaStatus;
        this.tareaIdControl = tareaIdControl;
        this.idPersona = idPersona;
        this.nomPersona = nomPersona;
        this.emailPersona = emailPersona;
        this.nombreEmpresa = nombreEmpresa;
        this.idRole = idRole;
        this.nombreRole = nombreRole;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public String getNombreTarea() {
        return nombreTarea;
    }

    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }

    public String getDescripcionTarea() {
        return descripcionTarea;
    }

    public void setDescripcionTarea(String descripcionTarea) {
        this.descripcionTarea = descripcionTarea;
    }

    public String getTiempoTarea() {
        return tiempoTarea;
    }

    public void setTiempoTarea(String tiempoTarea) {
        this.tiempoTarea = tiempoTarea;
    }

    public int getTareaColor() {
        return tareaColor;
    }

    public void setTareaColor(int tareaColor) {
        this.tareaColor = tareaColor;
    }

    public List<String> getTareaLinks() {
        return tareaLinks;
    }

    public void setTareaLinks(List<String> tareaLinks) {
        this.tareaLinks = tareaLinks;
    }

    public String getTareaStatus() {
        return tareaStatus;
    }

    public void setTareaStatus(String tareaStatus) {
        this.tareaStatus = tareaStatus;
    }

    public String getTareaIdControl() {
        return tareaIdControl;
    }

    public void setTareaIdControl(String tareaIdControl) {
        this.tareaIdControl = tareaIdControl;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNomPersona() {
        return nomPersona;
    }

    public void setNomPersona(String nomPersona) {
        this.nomPersona = nomPersona;
    }

    public String getEmailPersona() {
        return emailPersona;
    }

    public void setEmailPersona(String emailPersona) {
        this.emailPersona = emailPersona;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getNombreRole() {
        return nombreRole;
    }

    public void setNombreRole(String nombreRole) {
        this.nombreRole = nombreRole;
    }

    public void cargaJasonTest () {
        String jsonExample = null;
        // jsonExample= getTareas();

        Gson gson = new GsonBuilder().create();
        Tarea miTarea = gson.fromJson(jsonExample, Tarea.class);
    }
  }

