package com.josejavier.practica1_interfacesdeusuario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText eAncho, eAlto, eLargo;
    private String ancho, alto, largo, figura;
    private double perimetro, area, volumen, anchod, altod, largod;
    private TextView tInforma;
    private Button bCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eAncho = (EditText) findViewById(R.id.eAncho);
        eAlto = (EditText) findViewById(R.id.eAlto);
        eLargo = (EditText) findViewById(R.id.eLargo);
        tInforma = (TextView) findViewById(R.id.tInforma);
        bCalcular = (Button) findViewById(R.id.bCalcular);
    }

    public void Calcular(View view) {
        ancho = eAncho.getText().toString();
        alto = eAlto.getText().toString();
        largo = eLargo.getText().toString();

        anchod = Double.parseDouble(ancho);
        altod = Double.parseDouble(alto);

        if (figura == "triangulo"){
            perimetro = Math.sqrt((anchod*anchod)+(altod*altod))+anchod+altod;
            area = (anchod*altod)/2;
        }
        if (figura == "cuadrado"){
            perimetro = 4*anchod;
            area = anchod*anchod;
        }
        if (figura == "circulo"){
            perimetro = 2*Math.PI*(anchod/2);
            area = Math.PI*(anchod/2)*(anchod/2);
        }
        if (figura == "cubo"){
            perimetro = 12*anchod;
            area = 6*anchod*anchod;
            volumen = anchod*anchod*anchod;
        }


        tInforma.setText("Perimetro: "+perimetro+"\nArea: "+area+"\nVolumen: "+volumen);
    }

    public void onRadioButtonClicked(View view) {
        int id = view.getId();

        if (id == R.id.rtriangulo){
            figura = "triangulo";
        }
        if (id == R.id.rcuadrado){
            figura = "cuadrado";
        }
        if (id == R.id.rcirculo){
            figura = "circulo";
        }
        if (id == R.id.rcubo){
            figura = "cubo";
        }
    }

}
