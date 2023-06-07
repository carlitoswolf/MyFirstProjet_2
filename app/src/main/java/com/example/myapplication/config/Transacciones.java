package com.example.myapplication.config;

public class Transacciones {
    //Name DB
    public static final String NameDatabase = "PM01DB";

    //Table
    public static final String tablePeople = "Personas";

    //Table fields
    public static final String id = "id";
    public static final String nombres = "nombres";
    public static final String apellidos = "apellidos";
    public static final String edad = "edad";
    public static final String correo = "correo";

    //DDL Create and Drop

    public static final String CreateTablePeople = "CREATE TABLE PERSONAS" +
            "( id INTEGER PRIMARY KEY AUTOINCREMENT, nombres TEXT, apellidos TEXT, edad INTEGER, correo TEXT)";

    public static final String DropTablePeople = "DROP TABLE IF EXISTS personas";

    public static final String SelectTablePeople = "SELECT * FROM " + Transacciones.tablePeople;
}
