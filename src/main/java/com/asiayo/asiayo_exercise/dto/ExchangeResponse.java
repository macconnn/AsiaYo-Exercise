package com.asiayo.asiayo_exercise.dto;

public class ExchangeResponse {
    String msg;
    String amount;

    public String getMsg() {
        return msg;
    }

    public String getAmount() {
        return amount;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String toJsonString(){
        return String.format("{\"msg\":\"%s\",\"amount\":\"%s\"}", msg, amount);
    }//{"msg":"success","amount":"36690.0"}

}
