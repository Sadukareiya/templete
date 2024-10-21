package com.diworksdev.template.dto;

public class MyPageDTO {
    private String itemName;
    private String totalPrice;
    private String totalCount;
    private String payment;

    // 商品名を取得
    public String getItemName() {
        return this.itemName;
    }

    // 商品名を設定
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    // 合計金額を取得
    public String getTotalPrice() {
        return this.totalPrice;
    }

    // 合計金額を設定
    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    // 購入数を取得
    public String getTotalCount() {
        return this.totalCount;
    }

    // 購入数を設定
    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    // 支払い方法を取得
    public String getPayment() {
        return this.payment;
    }

    // 支払い方法を設定
    public void setPayment(String payment) {
        this.payment = payment;
    }
}

