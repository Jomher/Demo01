package com.project_t.demo01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.logging.Handler;


public class Splash extends Activity {
    protected int Duracion_Splash = 10000;
    protected ProgressBar progreso;
    protected boolean active= true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        progreso = (ProgressBar) findViewById(R.id.progressBar);
        progreso.setMax(6);
        empezar();
    }
    public void empezar(){
        new CountDownTimer(8000,1000){
            @Override
            public void onTick(long millisUtilFinished){
                progreso.setProgress(asignar_progreso(millisUtilFinished));
            }
            @Override
            public void onFinish(){
                Intent i = new Intent(getBaseContext(), Ppal_Activity.class);
                startActivity(i);
                finish();
            }

        }.start();
    }

    public int asignar_progreso(long miliseconds){
        return(int) ((Duracion_Splash-miliseconds)/1000);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash, menu);
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
