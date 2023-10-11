package com.example.loansimulation.calculation;

import android.util.Log;

import com.example.loansimulation.dto.LoanRequest;
import com.example.loansimulation.dto.LoanResponse;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class LoanCalculation {

    public LoanResponse loancal(LoanRequest req) {
        float rate = req.getInteres_rate()/100;
        Log.i("Loan", "Bunga" + rate);
        BigDecimal intTotal = req.getPrincipal().multiply(new BigDecimal(rate/12)).multiply(new BigDecimal(req.getTenor()));
        BigDecimal intAMonth = ceiling(intTotal.divide(new BigDecimal(req.getTenor())),1);
        BigDecimal instPrincipal = ceiling(req.getPrincipal().divide(new BigDecimal(req.getTenor()), MathContext.DECIMAL64),1);
        Log.i("Loan", "instPrincipal" + instPrincipal);
        LoanResponse res  = new LoanResponse();
        res.setInstallment(req.getPrincipal());
        res.setPrincipal(instPrincipal);
        res.setInterest(intAMonth);
        res.setInstallment(ceiling(intAMonth.add(instPrincipal),1));
        return  res;
    }

    public static BigDecimal ceiling(BigDecimal number, int sign) {
        BigDecimal tmp = number.setScale(2, RoundingMode.HALF_UP)
                .divide(new BigDecimal(sign));
        return tmp.setScale(0, RoundingMode.CEILING).multiply(new BigDecimal(sign));
    }
}
