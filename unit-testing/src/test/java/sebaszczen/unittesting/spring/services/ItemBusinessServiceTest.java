package sebaszczen.unittesting.spring.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;
import sebaszczen.unittesting.spring.model.Item;
import sebaszczen.unittesting.spring.repository.ItemRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceTest {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemBusinessService itemBusinessService;

    @Test
    public void retrieveAllItems() {
        List<Item> list = new ArrayList<>();
        list.add(new Item(1,"Item1", 1, 2));
        list.add(new Item(2,"Item2", 1, 2));
        when(itemRepository.findAll()).thenReturn(list);
        List<Item> items = itemBusinessService.retrieveAllItems();
        assertEquals(list,items);
        assertEquals(2,items.get(0).getValue());
    }
}