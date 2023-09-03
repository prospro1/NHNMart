package com.nhnacademy.mart;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BuyListTest {

    @Test
    void buyListAddTest() {
        BuyList.Item item = new BuyList.Item("양파",2);
        Assertions.assertEquals("양파", item.getName());
        Assertions.assertEquals(2, item.getAmount());
    }
}