package sebaszczen.unittesting.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sebaszczen.unittesting.spring.model.Item;
import sebaszczen.unittesting.spring.repository.ItemRepository;

import java.util.List;

@Service
public class ItemBusinessService {

    @Autowired
    private ItemRepository itemRepository;

    public Item retrieveHardcodedItem() {
        return new Item(1, "Ball", 10, 100);
    }

    public List<Item> retrieveAllItems() {
        List<Item> all = itemRepository.findAll();
        for (Item item : all) {
            item.setValue(item.getPrice()*item.getQuantity());
        }
        return all;
    }

}
