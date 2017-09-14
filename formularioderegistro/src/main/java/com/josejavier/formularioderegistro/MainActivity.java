package com.josejavier.formularioderegistro;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText eNombre, eApellido, eCelular, eMail, eContraseña, eReContraseña, eFecha;
    private String nombre, apellido, sexo="Masculino", hobbies="",celular, correo, ciudad, fechana, contraseña, recontraseña;
    private TextView tInfo;
    private Button bFecha, bRegistrar;
    private CheckBox cCine, cComer, cDeporte, cDormir;
    private Spinner sCiudad;
    private int dia, mes, año;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eNombre = (EditText) findViewById (R.id.eNombre);
        eApellido = (EditText) findViewById(R.id.eApellido);
        eCelular = (EditText) findViewById(R.id.eCelular);
        eMail = (EditText) findViewById(R.id.eMail);
        bRegistrar = (Button) findViewById(R.id.bRegistrar);
        tInfo = (TextView) findViewById(R.id.tInfo);
        cCine = (CheckBox) findViewById(R.id.cCine);
        cComer = (CheckBox) findViewById(R.id.cComer);
        cDeporte = (CheckBox) findViewById(R.id.cDeporte);
        cDormir = (CheckBox) findViewById(R.id.cDormir);
        sCiudad = (Spinner) findViewById(R.id.sCiudad);
        eContraseña = (EditText) findViewById(R.id.eContraseña);
        eReContraseña = (EditText) findViewById(R.id.eReContraseña);
        bFecha = (Button) findViewById(R.id.bFecha);
        eFecha = (EditText) findViewById(R.id.eFecha);

        //  Spinner spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.ciudad_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        sCiudad.setAdapter(adapter);

        sCiudad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ciudad = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final Calendar calendario = Calendar.getInstance();
        dia = calendario.get(Calendar.DAY_OF_MONTH);
        mes = calendario.get(Calendar.MONTH);
        año = calendario.get(Calendar.YEAR);

        bFecha.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                DatePickerDialog datepicker = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener(){
                    @Override
                    public void onDateSet(DatePicker datePicker, int anhoi, int mesi, int diai){
                        eFecha.clearFocus();
                        eFecha.setText(diai+"/"+ (mesi+1)+"/"+anhoi);
                        eFecha.setSelection(eFecha.getText().length());
                    }
                } , dia, mes, año
                );
                datepicker.updateDate(año, mes, dia);
                datepicker.show();
            }
        });

        eFecha.setEnabled(false);

    }

    public void Registrar(View view) {
        hobbies = "";
        if (cCine.isChecked()){hobbies = hobbies+" "+"Cine";}
        if (cComer.isChecked()){hobbies = hobbies+" "+"Comer";}
        if (cDeporte.isChecked()){hobbies = hobbies+" "+"Deporte";}
        if (cDormir.isChecked()){hobbies = hobbies+" "+"Dormir";}

        nombre = eNombre.getText().toString();
        apellido = eApellido.getText().toString();
        celular = eCelular.getText().toString();
        correo = eMail.getText().toString();
        fechana = eFecha.getText().toString();
        contraseña = eContraseña.getText().toString();
        recontraseña = eReContraseña.getText().toString();

        if (TextUtils.isEmpty(nombre.trim())){
            eNombre.setError("Ingrese un nombre");
            eNombre.requestFocus();
        }
        else if (TextUtils.isEmpty(apellido.trim())){
            eApellido.setError("Ingrese un apellido");
            eApellido.requestFocus();
        }
        else if (TextUtils.isEmpty(celular.trim())){
            eCelular.setError("Ingrese un numero de celular");
            eCelular.requestFocus();
        }
        else if (TextUtils.isEmpty(correo.trim())){
            eMail.setError("Ingrese una direccion de correo");
            eMail.requestFocus();
        }
        else if (TextUtils.isEmpty(fechana.trim())){
            eFecha.setError("Ingrese una fecha de nacimiento");
            eFecha.requestFocus();
        }
        else if (TextUtils.isEmpty(contraseña.trim())){
            eContraseña.setError("Ingrese una contraseña");
            eContraseña.requestFocus();
        }
        else if (TextUtils.isEmpty(recontraseña.trim())){
            eReContraseña.setError("Ingrese nuevamente la contraseña");
            eReContraseña.requestFocus();
        }
        else {
            if (contraseña.equals(recontraseña)) {
                tInfo.setText("Nombre: " + nombre + "\nApellido: " + apellido + "\nCelular: " + celular + "\nEmail: " + correo + "\nCiudad de nacimiento: " + ciudad
                        + "\nSexo: " + sexo + "\nFecha de nacimiento: " + fechana + "\nHobbies: " + hobbies);
            } else {
                tInfo.setText("Vuelva a intentar sus contraseñas no coninciden");
            }
        }

        /*
        if (contraseña.equals(recontraseña)){
            contraseña = "todo bn";
        }
        tInfo.setText("Nombre: "+nombre+"\nApellido: "+apellido+"\nCelular: "+celular+"\nEmail: "+correo+"\nCiudad de nacimiento: "+ciudad
                +"\nSexo: "+sexo+"\nFecha de nacimiento: "+fechana+"\nHobbies: "+hobbies+"\n"+contraseña+"\n"+recontraseña);*/
    }

    public void onRadioButtonClicked(View view) {
        int id = view.getId();

        if (id == R.id.rMasculino){
            sexo = "Masculino";
        }
        if (id == R.id.rFemenino){
            sexo = "Femenino";
        }
    }

    public void onCheckboxClicked(View view) {
    }
}
