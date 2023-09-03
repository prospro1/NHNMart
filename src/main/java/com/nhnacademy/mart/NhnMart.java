package com.nhnacademy.mart;

public class NhnMart {

    private final FoodStand foodStand = new FoodStand(); // 상품 매대 생성

    public void prepareMart() {
        fillFoodStand();
    } // 마트 개업 준비 (상품 매대 채워 넣기 호출)

    // 음식 세팅
    private void fillFoodStand() { // 상품 매대 채워 넣기
        for (int i = 0; i < 2; i++) { // 재고 2
            foodStand.add(new Food("양파", 1_000));
        }
        for (int i = 0; i < 5; i++) { // 재고 5
            foodStand.add(new Food("계란", 5_000));
        }
        for (int i = 0; i < 10; i++) { // 재고 10
            foodStand.add(new Food("파", 500));
        }
        for (int i = 0; i < 20; i++) { // 재고 20
            foodStand.add(new Food("사과", 2_000));
        }
    }

    public Basket provideBasket() {
        return new Basket();
    } // 장 바구니 제공 하기

    public FoodStand getFoodStand() {
        // 채워 넣은 상품 매대 가져오기
        return foodStand;
    }

    public Counter getCounter() {
        // 카운터 가져오기
        return new Counter();
    }
}