package com.josejavier.calcular_figuras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText eAncho, eAlto;
    private String ancho, alto, figura, prueba="";
    private double perimetro, area, volumen, anchod, altod;
    private TextView tInforma;
    private Button bCalcular;
    private RadioButton rtriangulo, rcuadrado, rcirculo, rcubo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eAncho = (EditText) findViewById(R.id.eAncho);
        eAlto = (EditText) findViewById(R.id.eAlto);
        tInforma = (TextView) findViewById(R.id.tInforma);
        bCalcular = (Button) findViewById(R.id.bCalcular);
        rtriangulo = (RadioButton) findViewById(R.id.rtriangulo);
        rcuadrado = (RadioButton) findViewById(R.id.rcuadrado);
        rcirculo = (RadioButton) findViewById(R.id.rcirculo);
        rcubo = (RadioButton) findViewById(R.id.rcubo);
    }

    public void onRadioButtonClicked(View view) {
        int id = view.getId();

        if (id == R.id.rtriangulo){
            figura = "triangulo";
            eAlto.setEnabled(true);
        }
        if (id == R.id.rcuadrado){
            figura = "cuadrado";
            eAlto.setEnabled(false);
        }
        if (id == R.id.rcirculo){
            figura = "circulo";
            eAlto.setEnabled(false);
        }
        if (id == R.id.rcubo){
            figura = "cubo";
            eAlto.setEnabled(false);
        }
    }

    public void Calcular(View view) {

       // anchod = Double.parseDouble(eAncho.getText().toString());
       // altod = Double.parseDouble(eAlto.getText().toString());

        //anchod = 0;
        //altod = 0;

        ancho = eAncho.getText().toString();
        alto = eAlto.getText().toString();

        //Double temp = Double.valueOf(ancho);
        //anchod = temp.doubleValue();
        //Double tempo = Double.valueOf(alto);
        //altod = tempo.doubleValue();

        try {
            anchod = Double.parseDouble(ancho);
            altod = Double.parseDouble(alto);
            prueba = "error";
        }
        catch (Exception excepcion){
            prueba = "too bn";
        }


        //anchod = Double.parseDouble(eAncho.getText().toString());
        //altod = Double.parseDouble(eAlto.getText().toString());

        if (figura == "triangulo"){
            perimetro = Math.sqrt((anchod*anchod)+(altod*altod))+anchod+altod;
            area = (anchod*altod)/2;
            volumen = 0;
        }
        if (figura == "cuadrado"){
            perimetro = 4*anchod;
            area = anchod*anchod;
            volumen = 0;
        }
        if (figura == "circulo"){
            perimetro = 2*Math.PI*(anchod/2);
            area = Math.PI*(anchod/2)*(anchod/2);
            volumen = 0;
        }
        if (figura == "cubo"){
            perimetro = 12*anchod;
            area = 6*anchod*anchod;
            volumen = anchod*anchod*anchod;
        }

        tInforma.setText("Perimetro: "+perimetro+"\nArea o area superficial: "+area+"\nVolumen: "+volumen);
       /* tInforma.setText("Perimetro: "+perimetro+"\nArea: "+area+"\nVolumen: "+volumen+"\nprueba: "+ancho+"--"+alto+"--"+anchod+"--"+altod+
                "\n"+prueba);  */
    }

}
