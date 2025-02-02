package com.komputerkit.konversisuhu;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    EditText etNilai;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        load();
    }
    /*
    public void isiSpinner(){
        String[] isi = {"Celcius to Fahrenheit", "Celcius to Reamur", "Celcius to Kelvin"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,isi);
        spinner.setAdapter(adapter);
    }
    */
    public void load(){
        spinner = findViewById(R.id.spinner);
        etNilai = findViewById(R.id.etNilai);
        tvHasil = findViewById(R.id.tvHasil);
    }
    
    public void btnKonversi(View view) {
        String pilihan = spinner.getSelectedItem().toString();

        if (etNilai.getText().toString().equals("")) {
            Toast.makeText(this, "Nilai tidak boleh kosong", Toast.LENGTH_SHORT).show();
        } else{
            if (pilihan.equals("Celcius to Reamur")){
                CtoR();
            }
            if (pilihan.equals("Celcius to Fahrenheit")){
                CtoF();
            }
            if (pilihan.equals("Celcius to Kelvin")){
                CtoK();
            }
            if (pilihan.equals("Reamur to Celcius")){
                RtoC();
            }
            if (pilihan.equals("Reamur to Fahrenheit")){
                RtoF();
            }
        }
    }

    public void CtoR(){
        double suhu = Double.parseDouble(etNilai.getText().toString());
        double hasil = (4.0/5.0) * suhu;
        tvHasil.setText(hasil+"");
    }

    public void CtoF(){
        double suhu = Double.parseDouble(etNilai.getText().toString());
        double hasil = (9.0/5.0 * suhu) + 32.0;
        tvHasil.setText(hasil+"");
    }

    public void CtoK(){
        double suhu = Double.parseDouble(etNilai.getText().toString());
        double hasil = suhu + 273.0;
        tvHasil.setText(hasil+"");
    }

    public void RtoC(){
        double suhu = Double.parseDouble(etNilai.getText().toString());
        double hasil = 5.0/4.0 * suhu;
        tvHasil.setText(hasil+"");
    }

    public void RtoF(){
        double suhu = Double.parseDouble(etNilai.getText().toString());
        double hasil = (9.0/4.0 * suhu) + 32.0;
        tvHasil.setText(hasil+"");
    }
}