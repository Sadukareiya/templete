package com.diworksdev.template.dto;

public class BuyItemDTO {

    // 商品ID
    private int id;

    // 商品名
    private String itemName;

    // 商品価格
    private String itemPrice;

    // 商品名を取得
    public String getItemName() {
        return itemName;
    }

    // 商品名を設定
    public void setItemName(String itemName) {  // 修正: 'serItemName' -> 'setItemName'
        this.itemName = itemName;
    }

    // 商品価格を取得
    public String getItemPrice() {
        return itemPrice;
    }

    // 商品価格を設定
    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    // 商品IDを取得
    public int getId() {  // 修正: 'setId' -> 'getId'
        return id;
    }

    // 商品IDを設定
    public void setId(int id) {
        this.id = id;
    }
}
