package com.nhnacademy.mart;

public class Food {

    private final String name;
    private final int price;

    // Food 생성자 : 상품 이름과 가격 넣기
    public Food(String name, int price) {
        this.name = name;
        this.price = price;
    }


    // getter
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
