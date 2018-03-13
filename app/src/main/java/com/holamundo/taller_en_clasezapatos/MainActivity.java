package com.holamundo.taller_en_clasezapatos;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private Spinner generos;
    private Spinner tipozapato;
    private Spinner marcas;
    private EditText num;
    private Button boton;
    private String op[];
    private String op2[];
    private String op3[];
    private Resources recursos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num = findViewById(R.id.txtn1);
        boton = findViewById(R.id.cotizando);
        recursos = this.getResources();
        op = recursos.getStringArray(R.array.generos);
        op = recursos.getStringArray(R.array.tipozapato);
        op = recursos.getStringArray(R.array.marcas);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, op);
        generos.setAdapter(adapter);
        ArrayAdapter<String> adapter1 =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, op2);
        tipozapato.setAdapter(adapter1);
        ArrayAdapter<String> adapter2 =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, op3);
        marcas.setAdapter(adapter2);

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i) {
            case 0:
                boton.setText(recursos.getString(R.string.masculino));
                break;
            case 1:
                boton.setText(recursos.getString(R.string.femenino));
                break;
        }}

    public boolean validar() {
        int opcion = generos.getSelectedItemPosition();
        if (num.getText().toString().isEmpty()) {
            num.requestFocus();
            n1.setError(recursos.getString(R.string.error_numero_uno));
            return false;
        }
        if (n2.getText().toString().isEmpty()) {
            n2.requestFocus();
            n2.setError(recursos.getString(R.string.error_numero_dos));
            return false;
        }
        if (opcion == 3 && Double.parseDouble(n2.getText().toString()) == 0)
            n2.requestFocus();
        n2.setError(recursos.getString(R.string.error_numero_tres));
        return true;
    }
}

}


