package com.project_t.demo01;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;

/**
 * Created by isai on 10-13-15.
 */
public class GestionData {
    public static final String XNOMBRES = "txtnombres";
    public static final String XAPELLIDOS = "txtapellidos";
    public static final String XEDAD = "txtedad";
    public static final String TABLA = "usuarios";
    public static final String BASEDATOS = "biblioteca";
    public static final int BASEDATOS_VER = 1 ;
    public static final String USUARIOS_CREATE = "CREATE TABLE usuarios" +
            "(codusu integer not null autoincrement, apeusu text not null, " +
            "nomusu text not null, edausu text, corusu text, clausu text);";

    DataHelper dh;
    Context ctx;
    SQLiteDatabase bd;

    public GestionData (Context ctx){
        this.ctx = ctx;
        dh = new DataHelper(ctx);
    }

    private static class DataHelper extends  SQLiteOpenHelper{

        public DataHelper(Context ctx){
            super(ctx, BASEDATOS, null, BASEDATOS_VER);
        }// fin del constructor
        @Override
        public void onCreate(SQLiteDatabase db) {
            try{
                db.execSQL(USUARIOS_CREATE);
            }catch (Exception e){
                e.printStackTrace();
            }
        }//fin del onCreate

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE ID EXISTS usuarios");
            onCreate(db);
        }//fin del onUpgrade
    }// fin del DataHelper

    //METODO QUE ABRE LA CONEXION A LA BASE DE DATOS
        public GestionData abrirDB(){
            bd = dh.getWritableDatabase();
            return this;
        }

    //METODO QUE CIERRE LA CONEXION A LA BASE DE DATOS
        public void cerrarDB(){
            dh.close();}

    //METODO PARA AGREGAR DATOS A LA BASE DE DATOS
        public long agregarDatos(String xnombres, String xapellidos, String xedad){
            ContentValues content = new ContentValues();
            content.put(XNOMBRES, xnombres);
            content.put(XAPELLIDOS, xapellidos);
            content.put(XEDAD, xedad);
            return bd.insertOrThrow(TABLA, null, content);
        }

    //METODO CONSULTAR DATOS A LA BASE DE DATOS
        public Cursor consultarDatos(){
            return bd.query(TABLA, new String[]{
                    XNOMBRES, XAPELLIDOS, XEDAD }, null, null, null, null, null);
        }
    }// Fin de la Clase GestionData

