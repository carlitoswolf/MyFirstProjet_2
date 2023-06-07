package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.config.Models.Personas;
import com.example.myapplication.config.SQLiteConexion;
import com.example.myapplication.config.Transacciones;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    SQLiteConexion conexion;
    ListView listPeople;
    ArrayList<Personas> lista;
    ArrayList<String> ArrayPeople;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        conexion = new SQLiteConexion(this, Transacciones.NameDatabase, null, 1);
        listPeople = (ListView) findViewById(R.id.listPerson);

        ObtenerTable();

        ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ArrayPeople);
        listPeople.setAdapter(adp);

        listPeople.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);

                Toast.makeText(getApplicationContext(), "Seleccionaste: " + selectedItem, Toast.LENGTH_SHORT).show();
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