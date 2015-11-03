package com.project_t.demo01;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Jonathan on 02/11/2015.
 */
public class ClientesCRUD {
    private DBHelper dbHelper;

    public ClientesCRUD(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void insertar (Clientes cliente) {

        //Open connection to write data
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( Clientes.NOMBRE, cliente.nombre);
        values.put(Clientes.APELLIDO,cliente.apellido);
        values.put(Clientes.TELEFONO, cliente.telefono);
        values.put(Clientes.CORREO, cliente.correo);
        values.put(Clientes.DIRECCION, cliente.direccion);
        values.put(Clientes.CLAVE, cliente.clave);

        db.insert(Clientes.TABLA, null, values);
        db.close(); // Closing database connection
    }

    public String leerClave (String correo){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String Query = "select "+Clientes.NOMBRE+","+Clientes.CORREO+", "+Clientes.CLAVE+" from "+Clientes.TABLA;
        Cursor cursor = db.rawQuery(Query,null);
        String a,b,c;
        c="no existe";
        if (cursor.moveToFirst()){
            do{
                a = cursor.getString(0);
                b = cursor.getString(1);
                if (b.equals(correo)){
                    c= cursor.getString(2);
                }

            }while(cursor.moveToNext());
        }
        return c;
    }

    public ArrayList<HashMap<String, String>> getListaClientes() {
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Clientes.ID + "," +
                Clientes.NOMBRE + "," +
                Clientes.CORREO + "," +
                Clientes.CLAVE +
                " FROM " + Clientes.TABLA;

        //Student student = new Student();
        ArrayList<HashMap<String, String>> studentList = new ArrayList<HashMap<String, String>>();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> student = new HashMap<String, String>();
                student.put("id", cursor.getString(cursor.getColumnIndex(Clientes.ID)));
                student.put("name", cursor.getString(cursor.getColumnIndex(Clientes.NOMBRE)));
                studentList.add(student);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return studentList;

    }
}
