package com.nhnacademy.mart;

import java.util.ArrayList;
import java.util.Iterator;

public class Customer {

    private int money = 20000;

    // 고객 구매 목록
    private final BuyList buyList;

    // 고객 장바구니
    private Basket basket;

    // 고객 생성자 (setter 같은) : 구매 목록을 미리 지닌 고객을 생성
    public Customer(BuyList buyList, int money) {
        this.buyList = buyList;
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    // 장바구니 챙기기 (생성자 같은 setter) : 마트 에서 주는 장 바구니 받아서 사용
    public void bring(Basket basket) {
        this.basket = basket;
    }


    // TODO pickFoods 메서드 구현 : 장바구니에 푸드 넣기 (끝)
    public void pickFoods(FoodStand foodStand) {

        // 상품 매대의 모든 상품 정보 들을 알아야 하고
        // 내가 사려고 하는 구매 목록의 모든 정보 들을 알아야 한다.
        ArrayList<Food> foods = foodStand.getFoods();
        ArrayList<BuyList.Item> items = buyList.getItems();

        // 구매 목록 에서 하나 하나 접근
        for (Iterator<BuyList.Item> iter = items.iterator(); iter.hasNext(); ) {
            BuyList.Item item = iter.next();

            int amount = item.getAmount(); // 해당 제품 장 바구니 에 넣을 개수
            int count = 0; // 장 바구니 에 넣은 개수

            // 상품 매대의 상품 들을 모두 순차적 으로 접근
            for (Iterator<Food> iter2 = foods.iterator(); iter2.hasNext(); ) {
                Food food = iter2.next();

                // 1. item 이름과 food 이름이 같다면 : 내가 사려고 한 제품 발견!
                if (item.getName().equals(food.getName())) {

                    // 2. 제품을 장 바구니 에 amount 개 넣었는 지 체크 하면서 넣기
                    if (count < amount) {
                        basket.add(food); // 가격 정보와 제품 명이 있는 food 넣기 (중복 허용)
                        count++;

                    } else break;

                }
            }
        }


        // 장 바구니 에  다 담으면 이제 매대 에서 삭제 처리 해주기
        // 매대 에서 작업 하기
        foodStand.delete(buyList.getItems());
    }



    // TODO payTox 메서드 구현
    public void payTox(Counter counter) {
        int leftMoney = counter.pay(this, basket);

        System.out.println("총 가격은 " + (this.money -  leftMoney) + "원 입니다.");
        System.out.println("고객님 결제 후 잔액 : " + leftMoney);
    }

}
