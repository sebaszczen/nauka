package sebaszczen.unittesting.spring.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = HelloWorldcontroller.class)
public class HelloWorldcontrollerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void helloWorld_basic() throws Exception {
        //call GET "/hello-world" application/json

        RequestBuilder request= MockMvcRequestBuilders.get("/hello-world").accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(request).andExpect(status().is(200)).andExpect(content().
                string("hello-world")).andReturn();

//        verify "hello-world"
        assertEquals("hello-world",mvcResult.getResponse().getContentAsString());
    }

}