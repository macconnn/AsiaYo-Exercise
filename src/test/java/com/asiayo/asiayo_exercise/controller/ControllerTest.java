package com.asiayo.asiayo_exercise.controller;


import com.asiayo.asiayo_exercise.dto.ExchangeResponse;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(controllers = Controller.class)
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ExchangeResponse exchangeResponse;
    private String s_ErrorMessage;


    /*
    Normal unit test
     */
    @Test
    public void test_TWD_To_JPY() throws Exception{
        exchangeResponse = new ExchangeResponse();
        exchangeResponse.setMsg("success");
        exchangeResponse.setAmount("$36,690.0");

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/exchange")
                .param("source", "TWD")
                .param("target", "JPY")
                .param("amount", "10000");

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String response = result.getResponse().getContentAsString();
        Assert.assertEquals(exchangeResponse.toJsonString(), response);
    }
    @Test
    public void test_TWD_To_USD() throws Exception{
        exchangeResponse = new ExchangeResponse();
        exchangeResponse.setMsg("success");
        exchangeResponse.setAmount("$328.1");

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/exchange")
                .param("source", "TWD")
                .param("target", "USD")
                .param("amount", "10000");

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String response = result.getResponse().getContentAsString();
        Assert.assertEquals(exchangeResponse.toJsonString(), response);
    }
    @Test
    public void test_TWD_To_TWD() throws Exception{
        exchangeResponse = new ExchangeResponse();
        exchangeResponse.setMsg("success");
        exchangeResponse.setAmount("$10,000.0");

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/exchange")
                .param("source", "TWD")
                .param("target", "TWD")
                .param("amount", "10000");

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String response = result.getResponse().getContentAsString();
        Assert.assertEquals(exchangeResponse.toJsonString(), response);
    }
    @Test
    public void test_JPY_To_TWD() throws Exception{
        exchangeResponse = new ExchangeResponse();
        exchangeResponse.setMsg("success");
        exchangeResponse.setAmount("$2,695.6");

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/exchange")
                .param("source", "JPY")
                .param("target", "TWD")
                .param("amount", "10000");

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String response = result.getResponse().getContentAsString();
        Assert.assertEquals(exchangeResponse.toJsonString(), response);
    }
    @Test
    public void test_JPY_To_USD() throws Exception{
        exchangeResponse = new ExchangeResponse();
        exchangeResponse.setMsg("success");
        exchangeResponse.setAmount("$88.5");

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/exchange")
                .param("source", "JPY")
                .param("target", "USD")
                .param("amount", "10000");

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String response = result.getResponse().getContentAsString();
        Assert.assertEquals(exchangeResponse.toJsonString(), response);
    }
    @Test
    public void test_JPY_To_JPY() throws Exception{
        exchangeResponse = new ExchangeResponse();
        exchangeResponse.setMsg("success");
        exchangeResponse.setAmount("$10,000.0");

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/exchange")
                .param("source", "JPY")
                .param("target", "JPY")
                .param("amount", "10000");

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String response = result.getResponse().getContentAsString();
        Assert.assertEquals(exchangeResponse.toJsonString(), response);
    }
    @Test
    public void test_USD_To_JPY() throws Exception{
        exchangeResponse = new ExchangeResponse();
        exchangeResponse.setMsg("success");
        exchangeResponse.setAmount("$1,118,010.0");

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/exchange")
                .param("source", "USD")
                .param("target", "JPY")
                .param("amount", "10000");

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String response = result.getResponse().getContentAsString();
        Assert.assertEquals(exchangeResponse.toJsonString(), response);
    }
    @Test
    public void test_USD_To_TWD() throws Exception{
        exchangeResponse = new ExchangeResponse();
        exchangeResponse.setMsg("success");
        exchangeResponse.setAmount("$304,440.0");

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/exchange")
                .param("source", "USD")
                .param("target", "TWD")
                .param("amount", "10000");

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String response = result.getResponse().getContentAsString();
        Assert.assertEquals(exchangeResponse.toJsonString(), response);
    }
    @Test
    public void test_USD_To_USD() throws Exception{
        exchangeResponse = new ExchangeResponse();
        exchangeResponse.setMsg("success");
        exchangeResponse.setAmount("$10,000.0");

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/exchange")
                .param("source", "USD")
                .param("target", "USD")
                .param("amount", "10000");

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String response = result.getResponse().getContentAsString();
        Assert.assertEquals(exchangeResponse.toJsonString(), response);
    }

    /*
    Error handle unit test
     */
    @Test
    public void test_Minus_Number() throws Exception{
        s_ErrorMessage = "Amount cannot be minus number";
        exchangeResponse = new ExchangeResponse();
        exchangeResponse.setMsg(s_ErrorMessage);
        exchangeResponse.setAmount("xxxxx");

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/exchange")
                .param("source", "TWD")
                .param("target", "JPY")
                .param("amount", "-10000");

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String response = result.getResponse().getContentAsString();
        Assert.assertEquals(exchangeResponse.toJsonString(), response);
    }
    @Test
    public void test_Source_Empty() throws Exception{
        s_ErrorMessage = "The parameters cannot be null or empty";
        exchangeResponse = new ExchangeResponse();
        exchangeResponse.setMsg(s_ErrorMessage);
        exchangeResponse.setAmount("xxxxx");

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/exchange")
                .param("source", "")
                .param("target", "JPY")
                .param("amount", "10000");

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String response = result.getResponse().getContentAsString();
        Assert.assertEquals(exchangeResponse.toJsonString(), response);
    }
    @Test
    public void test_Target_Empty() throws Exception{
        s_ErrorMessage = "The parameters cannot be null or empty";
        exchangeResponse = new ExchangeResponse();
        exchangeResponse.setMsg(s_ErrorMessage);
        exchangeResponse.setAmount("xxxxx");

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/exchange")
                .param("source", "TWD")
                .param("target", "")
                .param("amount", "10000");

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String response = result.getResponse().getContentAsString();
        Assert.assertEquals(exchangeResponse.toJsonString(), response);
    }
    @Test
    public void test_Source_Not_Allowed() throws Exception{
        s_ErrorMessage = "The currency is not allowed";
        exchangeResponse = new ExchangeResponse();
        exchangeResponse.setMsg(s_ErrorMessage);
        exchangeResponse.setAmount("xxxxx");

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/exchange")
                .param("source", "Not_allowed_currency")
                .param("target", "JPY")
                .param("amount", "10000");

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String response = result.getResponse().getContentAsString();
        Assert.assertEquals(exchangeResponse.toJsonString(), response);
    }
    @Test
    public void test_Target_Not_Allowed() throws Exception{
        s_ErrorMessage = "The currency is not allowed";
        exchangeResponse = new ExchangeResponse();
        exchangeResponse.setMsg(s_ErrorMessage);
        exchangeResponse.setAmount("xxxxx");

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/exchange")
                .param("source", "TWD")
                .param("target", "Not_allowed_currency")
                .param("amount", "10000");

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String response = result.getResponse().getContentAsString();
        Assert.assertEquals(exchangeResponse.toJsonString(), response);
    }
    @Test
    public void test_Amount_Over_Number() throws Exception{
        s_ErrorMessage = "The amount it's over";
        exchangeResponse = new ExchangeResponse();
        exchangeResponse.setMsg(s_ErrorMessage);
        exchangeResponse.setAmount("xxxxx");

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/exchange")
                .param("source", "TWD")
                .param("target", "JPY")
                .param("amount", "21474836470");

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String response = result.getResponse().getContentAsString();
        Assert.assertEquals(exchangeResponse.toJsonString(), response);
    }


}
