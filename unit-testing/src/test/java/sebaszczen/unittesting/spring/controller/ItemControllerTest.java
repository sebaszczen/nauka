package sebaszczen.unittesting.spring.controller;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import sebaszczen.unittesting.spring.model.Item;
import sebaszczen.unittesting.spring.services.ItemBusinessService;
import sun.plugin.javascript.JSObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService itemBusinessService;

    @Test
    public void getItem() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/dummy-item").accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andExpect(status().is(200)).andReturn();
        MvcResult mvcResult2 = mockMvc.perform(requestBuilder).andExpect(status().is(200)).andExpect(content().json("\n" +
                "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}")).andReturn();
        MvcResult mvcResult3 = mockMvc.perform(requestBuilder).andExpect(status().is(200)).andExpect(content().json("\n" +
                "{\"id\":1}")).andReturn();
        assertEquals("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100,\"value\":0}", mvcResult.getResponse().getContentAsString());
        JSONAssert.assertEquals("\n" +
                "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}", mvcResult.getResponse().getContentAsString(), false);
    }

    @Test
    public void getItem2() throws Exception {
        when(itemBusinessService.retrieveHardcodedItem()).thenReturn(new Item(2, "Item2", 10, 10));
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/item-from-business-service").accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andExpect(status().is(200)).andReturn();
        JSONAssert.assertEquals(
                "{id:2,name:Item2,price:10,quantity:10}", mvcResult.getResponse().getContentAsString(), false);
    }

    @Test
    public void allItemsFromDatabase() throws Exception {
        List<Item> listOfItems = new ArrayList<>();
        listOfItems.add(new Item(1, "item1", 22, 2));
        listOfItems.add(new Item(2, "item2", 22, 2));
        when(itemBusinessService.retrieveAllItems()).thenReturn(listOfItems);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/all-items-from-database").accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andExpect(status().is(200)).andReturn();
        JSONAssert.assertEquals(
                "[{id:1,name:item1,price:22,quantity:2},{id:2,name:item2,price:22,quantity:2}]", mvcResult.getResponse().getContentAsString(), false);

    }


}