package com.nhnacademy.mart;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BasketTest {

    @Test
    void basketAddTest() {
        Food food = new Food("양파", 1_000);
        Assertions.assertEquals("양파", food.getName());
        Assertions.assertEquals(1_000,food.getPrice());
    }
}