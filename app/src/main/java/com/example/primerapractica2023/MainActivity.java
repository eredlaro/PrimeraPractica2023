package com.example.primerapractica2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button next;
    private EditText captura;
    private SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        next = (Button) findViewById(R.id.next);
        captura = (EditText)findViewById(R.id.captura);
        preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);



        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Hiciste Click",Toast.LENGTH_SHORT).show();
                Log.i("INFO:","Pasaste a la segunda pantalla");
                String cadena = captura.getText().toString();
                SaveCred(cadena);
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("informacion",cadena);
                startActivity(intent);
            }
        });
    }

    private void SaveCred(String cadena) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("informacion", cadena);
        editor.commit();
    }
}