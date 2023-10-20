package com.asiayo.asiayo_exercise.function;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


@Component
public class FileOperation {

    File projectPath = new File("");
    private String exchangeRatePath = projectPath.getAbsolutePath() + "/exchange_rate.txt";

    public String readExchangeRateFile(){
        String content = "";

        BufferedReader bufferedReader = null;
        try {
            FileReader fileReader = new FileReader(exchangeRatePath);
            bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content += line;
            }

        } catch (Exception e) {
            System.out.println("Read exchange rate file exception");
        }finally {
            try {
                bufferedReader.close();
            }catch (Exception e){
                System.out.println("close file exception");
            }
        }

        return content;

    }





}
