package com.asiayo.asiayo_exercise.controller;


import com.asiayo.asiayo_exercise.dto.ExchangeResponse;
import com.asiayo.asiayo_exercise.function.Calculate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    private final List<String> allowedCurrencies = Arrays.asList("USD", "EUR", "JPY", "TWD");
    private String s_errorMessage;


    @RequestMapping(value = "/exchange", method = RequestMethod.GET)
    public ExchangeResponse calculateExchangeRate(@RequestParam("source") String source,
                                        @RequestParam("target") String target,
                                        @RequestParam("amount") String amount){
        ExchangeResponse exchangeResponse = new ExchangeResponse();
        Calculate calculate = new Calculate();

process:{
            if (source == null || target == null || amount == null ||
                source.isEmpty() || target.isEmpty() || amount.isEmpty()) {
                s_errorMessage = "The parameters cannot be null or empty";
                exchangeResponse.setMsg(s_errorMessage);
                exchangeResponse.setAmount("xxxxx");
                System.out.println(s_errorMessage);
                break process;
            }

            if(!allowedCurrencies.contains(source) || !allowedCurrencies.contains(target)){
                s_errorMessage = "The currency is not allowed";
                exchangeResponse.setMsg(s_errorMessage);
                exchangeResponse.setAmount("xxxxx");
                System.out.println(s_errorMessage);
                break process;
            }
            int i_amount = 0;
            try {
                i_amount = Integer.parseInt(amount);
            }catch (NumberFormatException e){
                s_errorMessage = "The amount it's over";
                exchangeResponse.setMsg(s_errorMessage);
                exchangeResponse.setAmount("xxxxx");
                System.out.println(s_errorMessage);
                break process;
            }

            if(i_amount < 0){
                s_errorMessage = "Amount cannot be minus number";
                exchangeResponse.setMsg(s_errorMessage);
                exchangeResponse.setAmount("xxxxx");
                System.out.println(s_errorMessage);
                break process;
            }

            double calculatedAmount = calculate.calculateAmount(source, target, i_amount);
            System.out.println("calculatedAmount : " + calculatedAmount);
            String [] amountArray = String.valueOf(calculatedAmount).split("\\.");
            DecimalFormat decimalFormat = new DecimalFormat("#,###");
            String finalAmount = String.format("$%s.%s", decimalFormat.format(Integer.parseInt(amountArray[0])), amountArray[1]);

            exchangeResponse.setMsg("success");
            exchangeResponse.setAmount(String.valueOf(finalAmount));

} // process end

        return exchangeResponse;

    }


}
