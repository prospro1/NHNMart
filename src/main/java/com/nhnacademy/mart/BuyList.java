package com.nhnacademy.mart;

import java.util.ArrayList;

public class BuyList {



    private static final ArrayList<Item> items = new ArrayList<>();

    // TODO add 메서드 생성 (끝)
    public void add(Item item) {
        items.add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public static class Item {


        private final String name; // 사려고 하는 제품명
        private final int amount; // 해당 제품 구매 원하는 개수

        public Item(String name, int amount) {
            this.name = name;
            this.amount = amount;
        }



        public String getName() {
            return name;
        }

        public int getAmount() {
            return amount;
        }
    }
}
