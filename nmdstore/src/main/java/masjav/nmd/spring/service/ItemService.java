package masjav.nmd.spring.service;


import masjav.nmd.spring.model.Item;
import masjav.nmd.spring.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ItemService {
    @Autowired
    ItemRepository itemRepository;

    @Transactional
    public Item findById(Long id) {
        return (Item) itemRepository.findById(id);
    }

    @Transactional
    public List<Item> getAllItems() {
        return (List<Item>) itemRepository.findAll();
    }

    @Transactional
    public List<Item> getItemSale() {
        return itemRepository.findByStatus("sale");
    }

    @Transactional
    public List<Item> getItemNew() {
        return itemRepository.findByNew();
    }
}
