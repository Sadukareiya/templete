package com.diworksdev.template.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware {

    // 商品の在庫数を保持
    private int stock;
    // 支払い方法（現金かクレジットカード）を保持
    private String pay;
    // セッション情報を格納するためのマップ
    public Map<String, Object> session;
    // 実行結果を格納するための変数
    private String result;

    // executeメソッド：商品購入時の処理を行う
    public String execute() {
        // 実行結果をSUCCESSに設定
        result = SUCCESS;

        // セッションに在庫数を保存
        session.put("stock", stock);

        // 在庫数と商品の価格を取得し、合計価格を計算してセッションに保存
        int intStock = Integer.parseInt(session.get("stock").toString());
        int intPrice = Integer.parseInt(session.get("buyItem_price").toString());
        session.put("buyItem_price", intStock * intPrice);

        // 支払い方法が現金の場合の処理
        String payment;
        if (pay.equals("1")) {
            payment = "現金払い";
            session.put("pay", payment);
        }
        // 支払い方法がクレジットカードの場合の処理
        else {
            payment = "クレジットカード";
            session.put("pay", payment);
        }

        // 実行結果を返す
        return result;
    }

    // 在庫数を取得するためのゲッターメソッド
    public int getStock() {
        return stock;
    }

    // 在庫数を設定するためのセッターメソッド
    public void setStock(int stock) {
        this.stock = stock;
    }

    // 支払い方法を取得するためのゲッターメソッド
    public String getPay() {
        return pay;
    }

    // 支払い方法を設定するためのセッターメソッド
    public void setPay(String pay) {
        this.pay = pay;
    }

    // セッションを取得するためのゲッターメソッド
    public Map<String, Object> getSession() {
        return session;
    }

    // セッションを設定するためのメソッド（SessionAwareインターフェースの実装）
    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

}

