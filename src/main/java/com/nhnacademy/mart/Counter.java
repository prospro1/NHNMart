package com.nhnacademy.mart;

import java.util.ArrayList;
import java.util.Iterator;

public class Counter {

    // 카운터 에서 이뤄 져야 하는 것
    // 1. 계산대 위에 장 바구니 에 있던 제품 들을 꺼내 준다.
    // 2. 제품 하나 하나 가격을 고객이 보유한 돈에서 빼준다. -> 구매 완료
    // 3. 장 바구니 에서 삭제해 준다.

    // TODO pay 메서드 구현 (카운터에서 계산 처리 메서드)
    public int pay(Customer customer, Basket basket) {

        int money = customer.getMoney(); // 예산 고정 값

        ArrayList<Food> foods = basket.getFoods();

        for (Iterator<Food> iter = foods.iterator(); iter.hasNext(); ) {
            Food food = iter.next();

            // 남은 돈이 현재 상품 가격 보다 작다면 구매 불가
            if (money < food.getPrice()) {
                throw new IllegalArgumentException("돈을 초과하는 상품 구매");
//                System.out.println("돈이 부족하셔서 현재 제품부터 구매를 할 수 없습니다.");
            }
            // 아니면 게산 가능
            money -= food.getPrice();
            iter.remove();
        }

        return money; // 거스름 돈 제공
    }

}
