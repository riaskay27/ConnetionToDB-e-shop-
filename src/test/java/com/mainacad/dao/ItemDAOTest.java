package com.mainacad.dao;

import com.mainacad.model.Item;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemDAOTest {

    private static List<Item> items=new ArrayList<>();
 //   @Test
//    void getById() {
//        Item item = new Item("testLogin", "testPass", "testName", "testLastName", "testEmail", "123456789");
//        ItemDAO.save(item);
//        items.add(item);
//        assertNotNull(item.getId());
//
//        Cart cart = new Cart(Status.OPEN, item, CURRENT_TIME);
//        CartDAO.save(cart);
//        carts.add(cart);
//
//        assertNotNull(cart.getId());
//
//        Cart savedCart = CartDAO.getById(cart.getId());
//
//        assertNotNull(savedCart);
//        assertNotNull(savedCart.getItem());
//        assertNotNull(savedCart.getItem().getId());
//    }

    @Test
    void update() {
        Item item=new Item("nameTest","codeTest",123,2);
        Item savedItem=ItemDAO.save(item);
        items.add(savedItem);
        assertNotNull(savedItem.getId());
        assertEquals(123,savedItem.getPrice());

        item.setId(savedItem.getId());
        item.setPrice(99);
        Item updatedItem=ItemDAO.update(item);

        assertNotNull(updatedItem);
        //assertNotEquals(updatedItem.getPassword(),savedItem.getPassword());
        assertEquals(99,updatedItem.getPrice());
    }

    @Test
    void save() {
        Item item=new Item("nameTest","codeTest",123,2);
        ItemDAO.save(item);
        items.add(item);
        assertNotNull(item.getId());
    }
}