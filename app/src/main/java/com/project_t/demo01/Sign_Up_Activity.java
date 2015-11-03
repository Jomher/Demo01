package com.project_t.demo01;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSpinner;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Sign_Up_Activity extends AppCompatActivity {
    protected Button btn;
    EditText txtedad, txtapellidos, txtdireccion;
    EditText txtnombres, txttelefono, txtcorreo, txtclave, txtclave2;
    Spinner spndepartamentos;
    String strclave;
    String xcorreo, xedad, xapellidos, xdireccion, xnombres, xtelefono, xclave, xclave2;
    GestionData gd;
    String opciones;
    ValidatorCorreo correoVal;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__up_);

        spndepartamentos = (Spinner) findViewById(R.id.municipios);
        spndepartamentos.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    Toast.makeText(getApplicationContext(),"seleccione un municipio",Toast.LENGTH_LONG).show();
                    v.setBackgroundResource(R.drawable.txtfocus_border_style);
                }else if (!hasFocus){
                    v.setBackgroundResource(R.drawable.focus_ok_border);
                }

            }
        });

        txtcorreo = (EditText) findViewById(R.id.correo);
        txtcorreo.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                xcorreo= txtcorreo.getText().toString();
                if(hasFocus){
                    v.setBackgroundResource(R.drawable.txtfocus_border_style);
                }
                else if (!hasFocus) {
                    if (!correoVal.validateEmail(xcorreo)){
                    txtcorreo.setError("correo no valido");
                        v.setBackgroundResource(R.drawable.wrong_border_style);
                    }else{
                        v.setBackgroundResource(R.drawable.focus_ok_border);
                    }


                }
            }
        });

        txtclave = (EditText) findViewById(R.id.contrasena);

        txtclave.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                xclave= txtclave.getText().toString();

                if(hasFocus){
                    v.setBackgroundResource(R.drawable.txtfocus_border_style);
                }
                    else if (!hasFocus) {
                        if (xclave.equals("")){
                            txtclave.setError("llena este campo");
                            v.setBackgroundResource(R.drawable.wrong_border_style);
                        }else{
                            v.setBackgroundResource(R.drawable.focus_ok_border);
                    }
                }
            }
        });

        txtclave2 = (EditText) findViewById(R.id.contrasena2);
        txtclave2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                xclave2= txtclave2.getText().toString();
                if(hasFocus){
                    v.setBackgroundResource(R.drawable.txtfocus_border_style);
                    if (!xclave2.equals(xclave)){
                        Toast.makeText(getApplicationContext(),"no coinciden",Toast.LENGTH_LONG).show();
                    }
                }
                else if (!hasFocus) {
                    if (xclave2.equals("")){
                        txtclave2.setError("llena este campo");
                        v.setBackgroundResource(R.drawable.wrong_border_style);
                    }
                    else if(!xclave2.equals(xclave)) {
                        txtclave2.setError("Claves no coinciden");
                        v.setBackgroundResource(R.drawable.wrong_border_style);
                    }
                    else{
                        v.setBackgroundResource(R.drawable.focus_ok_border);
                    }
                }
            }
        });

        /*txtclave2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                fijarFocus(v, hasFocus);
            }//fin de onFocusChange
        });//fin del metodo onFocusChangeListener*/

        /*txtcorreo=(EditText)findViewById(R.id.correo);
        txtcorreo.addTextChangedListener(new GenericTextWatcher(txtcorreo));
        txtcorreo.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                fijarFocus(v, hasFocus);
            }
        });*/

        txttelefono = (EditText) findViewById(R.id.telefono);
        txttelefono.addTextChangedListener(new GenericTextWatcher(txttelefono));
        txttelefono.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                xtelefono= txttelefono.getText().toString();
                if(hasFocus){
                    v.setBackgroundResource(R.drawable.txtfocus_border_style);
                }
                else if (!hasFocus) {
                    if (xtelefono.equals("")){
                        txtcorreo.setError("llena este campo");
                        v.setBackgroundResource(R.drawable.wrong_border_style);
                    }else{
                        v.setBackgroundResource(R.drawable.focus_ok_border);
                    }
                }
            }
        });

        txtedad = (EditText) findViewById(R.id.edad);
        txtedad.addTextChangedListener(new GenericTextWatcher(txtedad));
        txtedad.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                xedad= txtedad.getText().toString();
                if(hasFocus){
                    v.setBackgroundResource(R.drawable.txtfocus_border_style);
                }
                else if (!hasFocus) {
                    if (xedad.equals("")){
                        txtedad.setError("llena este campo");
                        v.setBackgroundResource(R.drawable.wrong_border_style);
                    }else{
                        v.setBackgroundResource(R.drawable.focus_ok_border);
                    }
                }
            }
        });

        txtdireccion = (EditText) findViewById(R.id.direccion);
        txtdireccion.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                xdireccion = txtdireccion.getText().toString();
                if(hasFocus){
                    v.setBackgroundResource(R.drawable.txtfocus_border_style);
                }
                else if (!hasFocus) {
                    if (xdireccion.equals("")){
                        txtdireccion.setError("llena este campo");
                        v.setBackgroundResource(R.drawable.wrong_border_style);
                    }else{
                        v.setBackgroundResource(R.drawable.focus_ok_border);
                    }
                }
            }
        });
        txtapellidos = (EditText) findViewById(R.id.apellido);
        txtapellidos.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                xapellidos = txtapellidos.getText().toString();
                if(hasFocus){
                    v.setBackgroundResource(R.drawable.txtfocus_border_style);
                }
                else if (!hasFocus) {
                    if (xapellidos.equals("")){
                        txtapellidos.setError("llena este campo");
                        v.setBackgroundResource(R.drawable.wrong_border_style);
                    }else{
                        v.setBackgroundResource(R.drawable.focus_ok_border);
                    }
                }
            }
        });

        txtnombres = (EditText) findViewById(R.id.nombre);
        txtnombres.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                xnombres= txtnombres.getText().toString();
                if(hasFocus){
                    v.setBackgroundResource(R.drawable.txtfocus_border_style);
                }
                else if (!hasFocus) {
                    if (xnombres.equals("")){
                        txtnombres.setError("llena este campo");
                        v.setBackgroundResource(R.drawable.wrong_border_style);
                    }else{
                        v.setBackgroundResource(R.drawable.focus_ok_border);
                    }
                }
            }
        });

        btn = (Button) findViewById(R.id.btnguardar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (xnombres.equals("") || xapellidos.equals("") || xdireccion.equals("") || xcorreo.equals("")
                        || xedad.equals("") || xtelefono.equals("") || xclave.equals("") || xclave2.equals("")){
                    Toast.makeText(getApplicationContext(), "POr favor, LLena los campos", Toast.LENGTH_LONG).show();
                }
                else{
                    ClientesCRUD repo = new ClientesCRUD(getApplicationContext());
                    Clientes cliente = new Clientes();

                    cliente.nombre= xnombres;
                    cliente.apellido= xapellidos;
                    cliente.telefono = xtelefono;
                    cliente.correo = xcorreo;
                    cliente.direccion = xdireccion;
                    cliente.clave = xclave;

                    repo.insertar(cliente);

                Toast.makeText(getApplicationContext(),"Usuario creado correctamente", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getBaseContext(),Ppal_Activity.class);
                    startActivity(i);
                }
            }
        });

        /*btn.setOnClickListener((v) {
            String xnombres = txtnombres.getText().toString();
            gd = new GestionData(getBaseContext());
            gd.abrirDB();
        long.bandera = gd.agregarDatos(xnombre, xapellidos,)
        }
     );}*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sign__up_, menu);
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

    public void fijarFocus(View v, Boolean hasFocus) {
        if (!hasFocus) {
            v.setBackgroundResource(R.drawable.txtlostfocus_border_style);
        } else {
            v.setBackgroundResource(R.drawable.txtfocus_border_style);
        }
    }

    private class GenericTextWatcher implements TextWatcher{

        private View view;
        private GenericTextWatcher(View view) { this.view = view;}

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

        public void afterTextChanged(Editable editable) {
            String text = editable.toString();
            switch(view.getId()){
                case R.id.contrasena2:
                    if (strclave.equals(text)){
                        Toast.makeText(getApplicationContext(),"Correcta",Toast.LENGTH_SHORT).show();
                        txtclave2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                            @Override
                            public void onFocusChange(View v, boolean hasFocus) {
                                v.setBackgroundResource(R.drawable.focus_ok_border);
                            }
                        });
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Las Contrasenas no Coinciden",Toast.LENGTH_SHORT).show();
                        txtclave2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                            @Override
                            public void onFocusChange(View v, boolean hasFocus) {
                                v.setBackgroundResource(R.drawable.wrong_border_style);
                            }
                        });
                    }
                    break;
                case R.id.edad:
                    try{
                        int xedad = Integer.parseInt(editable.toString());
                        if (xedad>70) {
                            editable.replace(0,editable.length(),"70");
                        }
                    }catch(NumberFormatException nfe){
                        Toast.makeText(getApplicationContext(),"El formato de la edad es incorrecto",Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.telefono:
                    try {
                        Integer.parseInt(text);
                    } catch (NumberFormatException nfe){
                        editable.replace(0, editable.length(),"");
                    }
                    break;
                case R.id.correo:
                    ValidatorCorreo email = new ValidatorCorreo();
                    if (!email.validateEmail(text)){
                        editable.replace(0, editable.length(), "");
                    }
                    break;
                }
                    }

            }
        }
