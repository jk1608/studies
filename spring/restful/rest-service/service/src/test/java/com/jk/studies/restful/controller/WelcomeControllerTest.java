package com.jk.studies.restful.controller;

import com.jk.studies.restful.WelcomeService;
import org.hamcrest.core.StringContains;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
public class WelcomeControllerTest {

    @MockBean
    private WelcomeService welcomeService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void welcomeWithNoParam() throws Exception {

        Mockito.when(welcomeService.getWelcomeMessage(Mockito.anyString())).thenReturn("Hello dude");
        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.get("/welcome"));
        actions.andDo(MockMvcResultHandlers.print());

        StatusResultMatchers statusResultMatchers = MockMvcResultMatchers.status();
        actions.andExpect(statusResultMatchers.is2xxSuccessful());

        ContentResultMatchers contentResultMatchers = MockMvcResultMatchers.content();
        actions.andExpect(contentResultMatchers.string(StringContains.containsString("Hello dude")));

        MvcResult mvcResult = actions.andReturn();
        mvcResult.getInterceptors();
        mvcResult.getResponse().getContentAsString().contains("Hello dude");
    }


}
