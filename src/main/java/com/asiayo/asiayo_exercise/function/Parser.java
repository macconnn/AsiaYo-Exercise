package com.asiayo.asiayo_exercise.function;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component

public class Parser {

    FileOperation fileOperation = new FileOperation();

    public double getRateByCurrency(String sourceCurrency, String targetCurrency){
        double d_rate = 0;
        String strExchangeRate = fileOperation.readExchangeRateFile();

        try {
            JSONObject jsonObject = new JSONObject(strExchangeRate);
            JSONObject currencies = jsonObject.getJSONObject("currencies");
            d_rate = currencies.getJSONObject(sourceCurrency).getDouble(targetCurrency);

        }catch (Exception e){
            System.out.println("Get exchange rate json exception");
        }

        return d_rate;
    }


}
