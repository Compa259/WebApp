package masjav.nmd.spring.controller;

import masjav.nmd.spring.model.Item;
import masjav.nmd.spring.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    ItemService itemService;

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public Item getItemById(@PathVariable("id") long id) {
        return itemService.findById(id);
    }

    @RequestMapping(value = "/item", method = RequestMethod.GET)
    public List<Item> getAll() {
        return itemService.getAllItems();
    }

    @RequestMapping(value = "/item/sale", method = RequestMethod.GET)
    public List<Item> getItemSale() {
        return itemService.getItemSale();
    }

    @RequestMapping(value = "/item/new", method = RequestMethod.GET)
    public List<Item> getItemNew(){
        return itemService.getItemNew();
    }

    @RequestMapping(value = "/item/top", method = RequestMethod.GET)
    public List<Item> getItemTop(){
        return itemService.getItemTop();
    }

    @RequestMapping(value = "/category/itemcategory/{id}/top", method = RequestMethod.GET)
    public List<Item> getItemTopFollowItemCategory(@PathVariable("id") long id){
        return itemService.getItemTopFollowItemCategory(id);
    }

    @RequestMapping(value = "/category/{id}/allitem", method = RequestMethod.GET)
    public Page<Item> getAllByCategory(@PathVariable("id") long id){
        return itemService.getAllByCategory(id, 1, 2);
    }
}
