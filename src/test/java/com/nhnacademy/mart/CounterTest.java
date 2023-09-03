package com.nhnacademy.mart;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CounterTest {

    @Test
    void counterPayTest() {

        Counter counter = new Counter();
        BuyList buyList = new BuyList();
        ArrayList<BuyList.Item> items = new ArrayList<>();
        items.add(new BuyList.Item("양파",2));

        Basket basket = new Basket();

//        ArrayList<BuyList.Item> items = new ArrayList<>();
        basket.add(new Food("양파", 1_000));
        basket.add(new Food("계란", 5_000));
        basket.add(new Food("파", 500));

        Customer customer = new Customer(buyList, 20000);

        Assertions.assertEquals(18_000, counter.pay(customer,basket));

    }
}