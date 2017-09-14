package com.josejavier.micalculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button bUno, bDos, bTres, bCuatro, bCinco, bSeis, bSiete, bOcho, bNueve, bCero, bMas, bMenos, bPor, bEnter, bIgual, bPunto;
    private EditText eDisplay, econcatenar;
    private String operador="", comprobar;
    private double operando1=0, operando2=0, resultado=0, verificar;
    private boolean decimal=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bUno = (Button) findViewById(R.id.bUno);
        bDos = (Button) findViewById(R.id.bDos);
        bTres = (Button) findViewById(R.id.bTres);
        bCuatro = (Button) findViewById(R.id.bCuatro);
        bCinco = (Button) findViewById(R.id.bCinco);
        bSeis = (Button) findViewById(R.id.bSeis);
        bSiete = (Button) findViewById(R.id.bSiete);
        bOcho = (Button) findViewById(R.id.bOcho);
        bNueve = (Button) findViewById(R.id.bNueve);
        bCero = (Button) findViewById(R.id.bCero);
        bMas = (Button) findViewById(R.id.bMas);
        bMenos = (Button) findViewById(R.id.bMenos);
        bPor = (Button) findViewById(R.id.bPor);
        bEnter = (Button) findViewById(R.id.bEnter);
        bIgual = (Button) findViewById(R.id.bIgual);
        bPunto = (Button) findViewById(R.id.bPunto);
        eDisplay = (EditText) findViewById(R.id.eDisplay);

        eDisplay.setEnabled(false);
    }

    public void uno(View view) {
        //comprobar = bUno.getText().toString();
        //eDisplay = (EditText) findViewById(R.id.eDisplay);
            eDisplay.setText(eDisplay.getText().toString()+"1");
    }

    public void dos(View view) {
            eDisplay.setText(eDisplay.getText().toString()+"2");
    }

    public void tres(View view) {
            eDisplay.setText(eDisplay.getText().toString()+"3");
    }

    public void cuatro(View view) {
        eDisplay.setText(eDisplay.getText().toString()+"4");
    }

    public void cinco(View view) {
        eDisplay.setText(eDisplay.getText().toString()+"5");
    }

    public void seis(View view) {
        eDisplay.setText(eDisplay.getText().toString()+"6");
    }

    public void siete(View view) {
        eDisplay.setText(eDisplay.getText().toString()+"7");
    }

    public void ocho(View view) {
        eDisplay.setText(eDisplay.getText().toString()+"8");
    }

    public void nueve(View view) {
        eDisplay.setText(eDisplay.getText().toString()+"9");
    }

    public void cero(View view) {
        //eDisplay = (EditText) findViewById(R.id.eDisplay);
        eDisplay.setText(eDisplay.getText().toString()+"0");
    }

    public void punto(View view) {
        comprobar = eDisplay.getText().toString();
        verificar = Double.parseDouble(comprobar);

        //bPunto.setEnabled(false);
        if (decimal == false){
            eDisplay.setText(eDisplay.getText().toString()+".");
            decimal = true;
        }
        else {
            return;
        }
    }

    public void mas(View view) {
        operador = "+";
        operando1 = Double.parseDouble(eDisplay.getText().toString());
        eDisplay.setText("");
        bMas.setEnabled(false);
        bMenos.setEnabled(false);
        bPor.setEnabled(false);
        bEnter.setEnabled(false);
        //bPunto.setEnabled(true);
        decimal=false;
    }

    public void menos(View view) {
        operador = "-";
        operando1 = Double.parseDouble(eDisplay.getText().toString());
        eDisplay.setText("");
        bMas.setEnabled(false);
        bMenos.setEnabled(false);
        bPor.setEnabled(false);
        bEnter.setEnabled(false);
        //bPunto.setEnabled(true);
        decimal=false;
    }

    public void por(View view) {
        operador = "*";
        operando1 = Double.parseDouble(eDisplay.getText().toString());
        eDisplay.setText("");
        bMas.setEnabled(false);
        bMenos.setEnabled(false);
        bPor.setEnabled(false);
        bEnter.setEnabled(false);
        //bPunto.setEnabled(true);
        decimal=false;
    }

    public void enter(View view) {
        operador = "/";
        operando1 = Double.parseDouble(eDisplay.getText().toString());
        eDisplay.setText("");
        bMas.setEnabled(false);
        bMenos.setEnabled(false);
        bPor.setEnabled(false);
        bEnter.setEnabled(false);
        //bPunto.setEnabled(true);
        decimal=false;
    }

    public void igual(View view) {
        operando2 = Double.parseDouble(eDisplay.getText().toString());

        if (operador == "+") {
            eDisplay.setText("");
            resultado = operando1 + operando2;
        }
        if (operador == "-") {
            eDisplay.setText("");
            resultado = operando1 - operando2;
        }
        if (operador == "*") {
            eDisplay.setText("");
            resultado = operando1 * operando2;
        }
        if (operador == "/") {
            eDisplay.setText("");
            if (operando2 != 0) {
                resultado = operando1 / operando2;
            } else {
                eDisplay.setText("OO");
            }
        }
        if (operador == "") {
            eDisplay.setText(String.valueOf(resultado));
        }

        if ((operador == "/") && (operando2 == 0)){
            eDisplay.setText("OO");
        }
        else {
            eDisplay.setText(String.valueOf(resultado));
        }

        decimal=false;
        bMas.setEnabled(true);
        bMenos.setEnabled(true);
        bPor.setEnabled(true);
        bEnter.setEnabled(true);
        operador = "";
    }

    public void limpiar(View view) {
        operando1 = 0;
        operando2 = 0;
        operador = "";
        resultado = 0;
        eDisplay.setText("");
        bMas.setEnabled(true);
        bMenos.setEnabled(true);
        bPor.setEnabled(true);
        bEnter.setEnabled(true);
    }

}
