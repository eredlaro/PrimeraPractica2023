package com.example.primerapractica2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    private Button back;
    private TextView mensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        back = (Button) findViewById(R.id.back);
        mensaje = (TextView) findViewById(R.id.mensaje);
        GetMensaje();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Presionaste el boton",Toast.LENGTH_SHORT).show();
                Log.i("INFO:","Regresaste a la primera pantalla");

                Intent intent = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void GetMensaje() {
        Bundle extras=getIntent().getExtras();
      mensaje.setText(extras.get("informacion").toString());
    }
}