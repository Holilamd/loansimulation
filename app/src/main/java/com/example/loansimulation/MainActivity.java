package com.example.loansimulation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.loansimulation.dto.LoanRequest;
import com.example.loansimulation.dto.LoanResponse;

import java.math.BigDecimal;
import java.math.BigInteger;

public class MainActivity extends AppCompatActivity {

    EditText interes_rate, principal, tenor;
    TextView result;
    Button btnCalculation;
    BigDecimal total, rate, prin;
    Integer tnr ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        interes_rate = findViewById(R.id.interes_rate);
//        principal = findViewById(R.id.principal);
//        tenor = findViewById(R.id.tenor);
//        btnCalculation = findViewById(R.id.btnCalculation);
//
//        result = findViewById(R.id.result);


//        btnCalculation.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (principal.getText().length() <= 0 || tenor.getText().length() <= 0 || interes_rate.getText().length() <= 0) {
//                    Toast toast = Toast.makeText(MainActivity.this,"Enter The Required Numbers",Toast.LENGTH_LONG);
//                    toast.show();
//                    return;
//                }
//                rate = new BigDecimal(interes_rate.getText().toString());
//                prin = new BigDecimal(principal.getText().toString());
//                tnr = Integer.valueOf(tenor.getText().toString());
//
//                LoanRequest req = new LoanRequest();
//                req.setPrincipal(prin);
//                req.setInteres_rate(rate);
//                req.setTenor(tnr);
//
//                LoanResponse res = loancal(req);
//                result.setText(res.getInstallment().toString());
//            }
//        });
    }

    /**
     * Loan calculation
     * @param req
     * @return res
     */
    private LoanResponse loancal(LoanRequest req) {
//        Integer intr = req.getInteres_rate()/100;
        LoanResponse res  = new LoanResponse();
        res.setInstallment(req.getPrincipal());
        return  res;
    }

}