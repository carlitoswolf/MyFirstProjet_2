package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.text.TextRunShaper;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.myapplication.config.Models.Personas;
import com.example.myapplication.config.SQLiteConexion;
import com.example.myapplication.config.Transacciones;

import java.util.ArrayList;

public class ComboActivity extends AppCompatActivity {


    SQLiteConexion conexion;
    Spinner comboPersona;
    EditText nombres, apellidos, correo;

    ArrayList<String> ArrayPeople;
    ArrayList<Personas> lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combo);
        conexion = new SQLiteConexion(this, Transacciones.NameDatabase, null, 1);
        comboPersona = (Spinner) findViewById(R.id.spinner);
        nombres = (EditText) findViewById(R.id.cbnombre);
        apellidos = (EditText) findViewById(R.id.cbapellido);
        correo = (EditText) findViewById(R.id.cbcorreo);

        ObtenerTable();

        ArrayAdapter<CharSequence> adp = new ArrayAdapter(this, android.R.layout.simple_spinner_item, ArrayPeople);
        comboPersona.setAdapter(adp);

        comboPersona.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                try {
                    nombres.setText(lista.get(i).getNombre());
                    apellidos.setText(lista.get(i).getApelidos());
                    correo.setText(lista.get(i).getCorreo());
                }
                catch (Exception ex){
                    ex.toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void ObtenerTable() {
        SQLiteDatabase db = conexion.getReadableDatabase();
        Personas person = null;
        lista = new ArrayList<Personas>();

        Cursor cursor = db.rawQuery(Transacciones.SelectTablePeople, null);

        while (cursor.moveToNext()){
            person = new Personas();

            person.setId(cursor.getInt(0));
            person.setNombre(cursor.getString(1));
            person.setApelidos(cursor.getString(2));
            person.setEdad(cursor.getInt(3));
            person.setCorreo(cursor.getString(4));

            lista.add(person);
        }

        cursor.close();

        fillList();
    }

    private void fillList() {
        ArrayPeople = new ArrayList<String>();

        for (int i=0; i < lista.size(); i++){
            ArrayPeople.add(lista.get(i).getId() + " - "+lista.get(i).getNombre() + " - "
                    +lista.get(i).getApelidos());
        }
    }
}