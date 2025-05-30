package uph.edu.m23si3.reagantapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class reagantactivity extends AppCompatActivity {

    EditText inputA, inputB;
    TextView textHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reagantactivity);

        inputA = findViewById(R.id.inputA);
        inputB = findViewById(R.id.inputB);
        textHasil = findViewById(R.id.textHasil);

        Button buttonTambah = findViewById(R.id.buttonTambah);
        Button buttonKali = findViewById(R.id.buttonKali);
        Button buttonBagi = findViewById(R.id.buttonBagi);

        buttonTambah.setOnClickListener(v -> hitung("+"));
        buttonKali.setOnClickListener(v -> hitung("*"));
        buttonBagi.setOnClickListener(v -> hitung("/"));
    }

    private void hitung(String operasi) {
        try {
            double a = Double.parseDouble(inputA.getText().toString());
            double b = Double.parseDouble(inputB.getText().toString());
            double hasil = 0;

            switch (operasi) {
                case "+":
                    hasil = a + b;
                    break;
                case "*":
                    hasil = a * b;
                    break;
                case "/":
                    hasil = b != 0 ? a / b : 0;
                    break;
            }

            textHasil.setText(String.valueOf(hasil));
        } catch (NumberFormatException e) {
            textHasil.setText("Input salah");
        }
    }
}