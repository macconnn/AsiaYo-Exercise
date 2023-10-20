package com.asiayo.asiayo_exercise.function;

public class Calculate {

    Parser parser = new Parser();

    public double calculateAmount(String source, String target, int amount){
        double result = 0;

        double rate = parser.getRateByCurrency(source, target);
        if(rate == 0){
            return result;
        }

        result = (double) Math.round(amount * rate * 100) / 100;

        return result;
    }




}
