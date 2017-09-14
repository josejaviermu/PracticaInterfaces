package com.josejavier.calcula_resistencia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner sBanda1, sBanda2,sBandaMultiplicador,sBandaTolerancia;
    private String banda1s,banda2s,bandamultiplicadoras,bandatolerancias,simbolo;
    private int banda1,banda2,bandamul,bandatole;
    private double resistencia,tolerancia,prueba;
    private TextView tValoresistencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sBanda1 = (Spinner) findViewById(R.id.sBanda1);
        sBanda2 = (Spinner) findViewById(R.id.sBanda2);
        sBandaMultiplicador = (Spinner) findViewById(R.id.sBandaMultiplicador);
        sBandaTolerancia = (Spinner) findViewById(R.id.sBandaTolerancia);
        tValoresistencia = (TextView) findViewById(R.id.tValoresistencia);

        //Bandas 1 y 2
        //  Spinner spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.cifra_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        sBanda1.setAdapter(adapter);
        sBanda2.setAdapter(adapter);

        sBanda1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                banda1s = adapterView.getItemAtPosition(i).toString();
                banda1 = adapterView.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        sBanda2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                banda2s = adapterView.getItemAtPosition(i).toString();
                banda2 = adapterView.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //Banda multiplicadora
        final ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this,
                R.array.multiplicador_array, android.R.layout.simple_spinner_item);

        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sBandaMultiplicador.setAdapter(adaptador);

        sBandaMultiplicador.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                bandamultiplicadoras = adapterView.getItemAtPosition(i).toString();
                bandamul = adapterView.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //Banda tolerancia
        final ArrayAdapter<CharSequence> adapta = ArrayAdapter.createFromResource(this,
                R.array.tolerancia_array, android.R.layout.simple_spinner_item);

        adapta.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sBandaTolerancia.setAdapter(adapta);

        sBandaTolerancia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                bandatolerancias = adapterView.getItemAtPosition(i).toString();
                bandatole = adapterView.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }

    public void Calcularesistencia(View view) {

        resistencia = 0;
        tolerancia = 0;
        resistencia = banda1*10+banda2;
        prueba = resistencia;

        switch (bandatole) {
            case (8):
                tolerancia = 10;
                break;
            case (7):
                tolerancia = 5;
                break;
            case (6):
                tolerancia = 0.05;
                break;
            case (5):
                tolerancia = 0.1;
                break;
            case (4):
                tolerancia = 0.25;
                break;
            case (3):
                tolerancia = 0.5;
                break;
            case (2):
                tolerancia = 2;
                break;
            case (1):
                tolerancia = 1;
                break;
            default:
                tolerancia = 20;
                break;
        }

        switch (bandamul){
            case (11):
                resistencia = resistencia*0.01;
                break;
            case (10):
                resistencia = resistencia*0.1;
                simbolo = " ";
                break;
            case (9):
                //resistencia = resistencia*Math.pow(10.0,9.0);
                //resistencia = resistencia/1000000000;
                simbolo = "G";
                break;
            case (8):
                //resistencia = resistencia*Math.pow(10.0,8.0);
                //resistencia = resistencia/1000000000;
                resistencia = resistencia/10;
                simbolo = "G";
                break;
            case (7):
                //resistencia = resistencia*Math.pow(10.0,7.0);
                //resistencia = resistencia/1000000;
                resistencia = resistencia*10;
                simbolo = "M";
                break;
            case (6):
                //resistencia = resistencia*Math.pow(10.0,6.0);
                //resistencia = resistencia/1000000;
                simbolo = "M";
                break;
            case (5):
                //resistencia = resistencia*Math.pow(10.0,5.0);
                //resistencia = resistencia/1000000;
                resistencia = resistencia/10;
                simbolo = "M";
                break;
            case (4):
                //resistencia = resistencia*10000;
                //resistencia = resistencia/1000;
                resistencia = resistencia*10;
                simbolo = "K";
                break;
            case (3):
                //resistencia = resistencia*1000;
                //resistencia = resistencia/1000;
                simbolo = "K";
                break;
            case (2):
                //resistencia = resistencia*Math.pow(10.0,2.0);
                //resistencia = resistencia/1000;
                resistencia = resistencia/10;
                simbolo = "K";
                break;
            case (1):
                resistencia = resistencia*10;
                simbolo = " ";
                break;
            default:
                resistencia = resistencia*1;
                simbolo = " ";
                break;
        }

        if (banda1 == 0){
            tValoresistencia.setText("No es valor válido para una resistencia");
        }
        else {
            tValoresistencia.setText("El valor de la resistencia es: "+resistencia+" "+simbolo+"Ω"+"\nLa tolerancia de la resistencia es: ±"+
                    +tolerancia+"%");
        }

      //  tValoresistencia.setText("El valor de la resistencia es: "+resistencia+" "+simbolo+"Ω"+"\nLa tolerancia de la resistencia es: ±"+
        //        +tolerancia+"%\n"+banda1s+banda2s+bandamultiplicadoras+bandatolerancias+"\n"+banda1+banda2+bandamul+bandatole+"\n"+prueba);

    }
}
