package com.nhnacademy.mart;

import java.util.Scanner;

public class NhnMartShell { // main 으로 실행 하는 곳

    public static void main(String[] args) {
        NhnMart mart = new NhnMart(); // 마트 건물 완성
        mart.prepareMart(); // 마트 개업 준비 (상품 매대 채워 넣기)

        BuyList buyList = inputBuyListFromShell(); // 스캐너 로 입력 받아 구매 목록 생성

        // TODO 본인이름 영어로 변수명 작성! (끝)
        Customer choiYunHwa = new Customer(buyList, 20_000); // 구매 목록을 가진 고객 생성 (예산 고정)

        // 장바구니를 챙긴다.
        choiYunHwa.bring(mart.provideBasket()); // 고객 에게 장 바구니 제공

        // 식품을 담는다.
        choiYunHwa.pickFoods(mart.getFoodStand()); // 고객이 상품 매대로 가서 상품을 담기

        // 카운터에서 계산한다.
        choiYunHwa.payTox(mart.getCounter()); // 고객이 카운터 로 가서 상품을 계산 하기
    }

    private static BuyList inputBuyListFromShell() {
        // TODO Scanner 입력을 받아 buyList 만들기 (끝)
        Scanner sc = new Scanner(System.in);

        BuyList buyList = new BuyList(); // 빈 구매 목록 생성

        System.out.println("NHN 마트에 오신 것을 환영합니다. 사고 싶은 물건을 골라주세요.\n");
        System.out.print("> ");

        String[] tmpList = sc.nextLine().strip().split(" "); // 양파 2 계란 2 파 4

        for (int i = 0; i < tmpList.length / 2; i++) {
            // 구매 목록에 한 상품씩 추가
            buyList.add(new BuyList.Item(tmpList[i*2], Integer.parseInt(tmpList[i*2+1]) ) );
        }

        return buyList; // 구매 목록 리턴
    }
}
