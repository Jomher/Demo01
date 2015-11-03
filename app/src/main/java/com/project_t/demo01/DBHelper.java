package com.project_t.demo01;

/**
 * Created by Jonathan on 02/11/2015.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

    public class DBHelper  extends SQLiteOpenHelper {
        //version number to upgrade database version
        //each time if you Add, Edit table, you need to change the
        //version number.
        private static final int DATABASE_VERSION = 1 ;

        // nombre de la base de datos
        private static final String DATABASE_NAME = "projectT.db";

        public DBHelper(Context context ) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            //creando las tablas

            String CREATE_TABLE_CLIENTES = "CREATE TABLE " + Clientes.TABLA  + "("
                    +Clientes.ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                    +Clientes.NOMBRE  + " TEXT, "
                    +Clientes.APELLIDO  + " TEXT, "
                    +Clientes.TELEFONO  + " TEXT, "
                    +Clientes.CORREO  + " TEXT, "
                    +Clientes.DIRECCION  + " TEXT, "
                    + Clientes.CLAVE + " TEXT )";

            db.execSQL(CREATE_TABLE_CLIENTES);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // Drop older table if existed, all data will be gone!!!
            db.execSQL("DROP TABLE IF EXISTS " + Clientes.TABLA);

            // Create tables again
            onCreate(db);

        }
    }

