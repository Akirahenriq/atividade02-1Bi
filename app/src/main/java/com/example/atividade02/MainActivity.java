package com.example.atividade02;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

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
    }

    public void calcIr(View view) {

        EditText rMensal =findViewById(R.id.rMensal);
        EditText dedu = findViewById(R.id.dedu);
        EditText depen = findViewById(R.id.depen);


        TextView txtrAnual =findViewById(R.id.txtrAnual);
        TextView txtbCalc = findViewById(R.id.txtbCalc);
        TextView txtiDevido = findViewById(R.id.txtiDevido);
        TextView txtAviso = findViewById(R.id.txtAviso);

        if (
                rMensal.getText().toString().trim().isEmpty() ||
                        dedu.getText().toString().trim().isEmpty() ||
                        depen.getText().toString().trim().isEmpty()
        ) {
            txtAviso.setText("Preencha todos os campos");
            txtbCalc.setText("");
            txtiDevido.setText("");
            txtrAnual.setText("");
            return;
        }

        txtAviso.setText("");

    double M = Double.parseDouble(rMensal.getText().toString());
    double De = Double.parseDouble(dedu.getText().toString());
    int depe = Integer.parseInt(depen.getText().toString());

    double rAnual;
    double baseCalc;
    double Idevd;
    double calcDepen;

    
    rAnual = (M * 12);
        txtrAnual.setText("Sua renda bruta anual é: " + rAnual);

    calcDepen = (depe * 300 * 12);

    baseCalc = rAnual - calcDepen - De;
        txtbCalc.setText("Base de calculo: " + baseCalc);


        if (baseCalc <= 18000) {
            Idevd = 0;
        }
        else if (baseCalc <= 27000) {
            Idevd = (baseCalc - 18000) * 0.15;
        }
        else {
            Idevd = 1350 + (baseCalc - 27000) * 0.275;
        }

    txtiDevido.setText("Imposto devido: "+ Idevd);


    }
}