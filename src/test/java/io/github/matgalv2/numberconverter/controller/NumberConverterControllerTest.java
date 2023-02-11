package io.github.matgalv2.numberconverter.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.matgalv2.numberconverter.common.ConversionType;
import io.github.matgalv2.numberconverter.dto.Data;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;

import static io.github.matgalv2.numberconverter.common.ConversionType.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
public class NumberConverterControllerTest {

    @Autowired
    private WebApplicationContext context;
    private MockMvc mvc;

    private byte[] convertToJSON(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsBytes(object);
    }

    private Data createData(long value, ConversionType type) {
        return new Data(value, type);
    }

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @Test
    public void givenInvalidHexData_whenConvertNumber_thenStatus400() throws Exception {
        ResultActions resultActions =
                mvc.perform(
                        get("/convert").
                                contentType(MediaType.APPLICATION_JSON)
                                .content(convertToJSON(createData(-1, HEXADECIMAL))));

        resultActions.andExpect(status().isBadRequest());
    }

    @Test
    public void givenValidHexData_whenConvertNumber_thenStatus200() throws Exception {
        ResultActions resultActions =
                mvc.perform(
                        get("/convert").
                                contentType(MediaType.APPLICATION_JSON)
                                .content(convertToJSON(createData(255, HEXADECIMAL))));

        String result = resultActions.andReturn().getResponse().getContentAsString();
        String expected = "{\"value\":\"ff\"}";

        resultActions.andExpect(status().isOk());
        assertEquals(result, expected);
    }

    @Test
    public void givenInvalidRomanData_whenConvertNumber_thenStatus400() throws Exception {
        ResultActions resultActions =
                mvc.perform(
                        get("/convert").
                                contentType(MediaType.APPLICATION_JSON)
                                .content(convertToJSON(createData(8000, ROMAN_NUMERAL))));

        resultActions.andExpect(status().isBadRequest());
    }

    @Test
    public void givenValidRomanData_whenConvertNumber_thenStatus200() throws Exception {
        ResultActions resultActions =
                mvc.perform(
                        get("/convert").
                                contentType(MediaType.APPLICATION_JSON)
                                .content(convertToJSON(createData(1357, ROMAN_NUMERAL))));

        String result = resultActions.andReturn().getResponse().getContentAsString();
        String expected = "{\"value\":\"MCCCLVII\"}";

        resultActions.andExpect(status().isOk());
        assertEquals(result, expected);
    }

}
