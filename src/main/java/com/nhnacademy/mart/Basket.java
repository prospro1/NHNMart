package com.nhnacademy.mart;

import java.util.ArrayList;

public class Basket {


    private final ArrayList<Food> foods = new ArrayList<>();

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public void add(Food food) {
        // 식품 매대 에 없는 상품
        if (!foods.contains(food)) {
            throw new IllegalArgumentException("식품 매대에 없는 상품 구매");
//            System.out.println("식품 매대에 없는 상품을 구매하려고 해요. 구매할 수가 없어요. 해당 제품을 구매하시려면 다른 곳을 이용해주세요.");
        }
        else {
            foods.add(food);
        }
    }
}
