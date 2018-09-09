package com.jk.studies.restful.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HelloCardControllerTest1 {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void noParamForHello() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/hello"));
        resultActions = resultActions.andDo(MockMvcResultHandlers.print());
        StatusResultMatchers statusResultMatchers = MockMvcResultMatchers.status();
        ContentResultMatchers contentResultMatchers = MockMvcResultMatchers.content();
        resultActions.andExpect(statusResultMatchers.isOk());
        ResultMatcher stringResultMatcher = contentResultMatchers.string("{\"id\":1,\"content\":\"Hello, World!\"}");
        resultActions.andExpect(stringResultMatcher);
        JsonPathResultMatchers jsonPathResultMatchers = MockMvcResultMatchers.jsonPath("$.content");
        String expectedContent = "Hello, World!";
        resultActions.andExpect(jsonPathResultMatchers.value(expectedContent));
        resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"));
    }


}
