package com.example.myapplication.config.Models;

public class Personas {
    private Integer id;
    private String nombre;
    private String apelidos;
    private Integer edad;
    private String correo;

    public Personas(Integer id, String nombre, String apelidos, Integer edad, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.apelidos = apelidos;
        this.edad = edad;
        this.correo = correo;
    }

    public Personas() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApelidos() {
        return apelidos;
    }

    public void setApelidos(String apelidos) {
        this.apelidos = apelidos;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
