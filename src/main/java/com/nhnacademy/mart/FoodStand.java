package com.nhnacademy.mart;

import java.util.ArrayList;
import java.util.Iterator;

public class FoodStand { // 상품 매대
    private final ArrayList<Food> foods = new ArrayList<>();

    public ArrayList<Food> getFoods() {
        return foods;
    }

    // TODO add 메서드 구현 (끝)
    public void add(Food food) {
        foods.add(food);
    }

    // TODO 장바구니에 담은 Food 매대에서 삭제 구현 : 구매 목록 에서 아이템 이름, 구매 갯수, 음식 정보 가져와서 지우기
    public void delete(ArrayList<BuyList.Item> items) {
        for (Iterator<BuyList.Item> iter = items.iterator(); iter.hasNext(); ) {
            BuyList.Item item = iter.next();

            int amount = item.getAmount(); // 구매 개수
            int count = 0; // 구매 개수 카운터

            for (Iterator<Food> iter2 = foods.iterator(); iter2.hasNext(); ) {
                Food food = iter2.next();

                // 1. item 이름과 food 이름이 같다면 : 내가 바구니 에 담은 제품 발견!
                if (item.getName().equals(food.getName())) {
                    if (count < amount) {
                        iter2.remove();
                        count++;
                    } else break;
                }
            }

            // 재고가 부족할 때
            if (count < amount) {
                throw new IllegalArgumentException("해당 상품 재고 부족");
//                System.out.println("해당 상품 재고가 부족해서 구매하지 못합니다.");
            }
        }
    }
}
