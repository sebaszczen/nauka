package sebaszczen.unittesting.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sebaszczen.unittesting.spring.model.Item;
import sebaszczen.unittesting.spring.services.ItemBusinessService;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemBusinessService itemBusinessService;

    @GetMapping("/dummy-item")
    public Item getItem() {
        return new Item(1,"Ball",10,100);
    }

    @GetMapping("/item-from-business-service")
    public Item getItem2() {
        return itemBusinessService.retrieveHardcodedItem();
    }

    @GetMapping("/all-items-from-database")
    public List<Item> allItemsFromDatabase() {
        return itemBusinessService.retrieveAllItems();
    }
}
