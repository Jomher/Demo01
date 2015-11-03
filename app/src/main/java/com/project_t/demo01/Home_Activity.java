package com.project_t.demo01;

import android.app.ListActivity;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.database.MatrixCursor;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;

public class Home_Activity extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] columnasBD = new String[]{"_id", "imagen", "textoSuperior", "textoInferior"};
        MatrixCursor cursor = new MatrixCursor(columnasBD);
        cursor.addRow(new Object[]{"0", R.drawable.software, "Software", "Desarrolla tu Sistema"});
        cursor.addRow(new Object[]{"1", R.drawable.hardware, "Hardware", "Repara tu Equipo"});
        cursor.addRow(new Object[]{"2", R.drawable.redes, "Redes", "Implementa tu Red"});
        cursor.addRow(new Object[]{"3", R.drawable.ic_launcher, "Acerca de...", "Contactanos"});

        //Añadimos los datos al Adapter y le indicamos donde dibujar cada dato en la fila del Layout
        String[] desdeEstasColumnas = {"imagen", "textoSuperior", "textoInferior"};
        int[] aEstasViews = {R.id.imageView_imagen, R.id.textView_superior, R.id.textView_inferior};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.activity_home_, cursor, desdeEstasColumnas, aEstasViews, 0);
        ListView listado = getListView();
        listado.setAdapter(adapter);
    }

    @Override
    public void onListItemClick (ListView lista, View view, int posicion, long id) {
        // Hacer algo cuando un elemento de la lista es seleccionado
        TextView textoTitulo = (TextView) view.findViewById(R.id.textView_superior);

        CharSequence texto = "Seleccionado: " + textoTitulo.getText();
        Toast.makeText(getApplicationContext(), texto, Toast.LENGTH_LONG).show();
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/
}

