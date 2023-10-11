package com.example.loansimulation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.loansimulation.calculation.LoanCalculation;
import com.example.loansimulation.dto.LoanRequest;
import com.example.loansimulation.dto.LoanResponse;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {

    EditText interestRate, principal, tenor, interestType;
    Button btnLoanCal;
    TextView installmentPrincipal, installmentInterest, totalInstallment;
    BigDecimal prin;
    Float rate;
    Integer tnr ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        interestRate = findViewById(R.id.interestRate);
        principal = findViewById(R.id.principal);
        tenor = findViewById(R.id.tenor);
        interestType = findViewById(R.id.interestType);

        installmentPrincipal = findViewById(R.id.installmentPrincipal);
        installmentInterest = findViewById(R.id.installmentInterest);
        totalInstallment = findViewById(R.id.totalInstallment);
        btnLoanCal = findViewById(R.id.btnLoanCal);
        btnLoanCal.setBackgroundColor(Color.parseColor("#4FB262"));
        btnLoanCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (principal.getText().length() <= 0 || tenor.getText().length() <= 0 || interestRate.getText().length() <= 0) {
                    Toast toast = Toast.makeText(MainActivity.this,"Enter The Required Numbers",Toast.LENGTH_LONG);
                    toast.show();
                    return;
                }
                rate = Float.parseFloat(interestRate.getText().toString());
                prin = new BigDecimal(principal.getText().toString());
                tnr = Integer.valueOf(tenor.getText().toString());
                LoanRequest req = new LoanRequest();
                req.setPrincipal(prin);
                req.setInteres_rate(rate);
                req.setTenor(tnr);

                LoanResponse res = new LoanCalculation().loancal(req);
                totalInstallment.setText(res.getInstallment().toString());
                installmentInterest.setText(res.getInterest().toString());
                installmentPrincipal.setText(res.getPrincipal().toString());
            }
        });
    }
}