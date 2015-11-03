package com.project_t.demo01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Ppal_Activity extends Activity {
    private Button boton;
    private TextView vinculo;
    String xcorreo, xclave;
    EditText txtcorreo, txtclave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ppal_);

        txtcorreo = (EditText) findViewById(R.id.txtusuario);
        xcorreo = txtcorreo.getText().toString();
        txtclave = (EditText) findViewById(R.id.txtclave);
        xclave = txtclave.getText().toString();

        boton=(Button)findViewById(R.id.btnautenticar);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ClientesCRUD repo = new ClientesCRUD(getApplicationContext());
                String pass =  repo.leerClave(xcorreo);
                Toast.makeText(getApplicationContext(),pass,Toast.LENGTH_LONG).show();
               /*if (pass.equals(xclave)){
                    Toast.makeText(getApplicationContext(),"Bienvenido",Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getBaseContext(),Home_Activity.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Usuario o contraseña no valido",Toast.LENGTH_LONG).show();
                }*/
            }
        });

        vinculo = (TextView) findViewById(R.id.txtetiqueta);
        vinculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(),Sign_Up_Activity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ppal_, menu);
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
    }
}
