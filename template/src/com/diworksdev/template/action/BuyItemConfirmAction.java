package com.diworksdev.template.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.template.dao.BuyItemCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemConfirmAction extends ActionSupport implements SessionAware {

    private Map<String, Object> session;

    // 商品購入処理を行うメソッド
    public String execute() throws SQLException {
        BuyItemCompleteDAO buyItemCompleteDAO = new BuyItemCompleteDAO();

        // 購入情報をDBに保存
        buyItemCompleteDAO.buyItemeInfo(
            session.get("id").toString(),
            session.get("login_user_id").toString(),
            session.get("buyItem_price").toString(),
            session.get("stock").toString(),
            session.get("pay").toString()
        );

        // 実行結果を返す
        String result = SUCCESS;
        return result;
    }

    // セッションを取得するためのゲッターメソッド
    public Map<String, Object> getSession() {
        return session;
    }

    // セッションを設定するためのセッターメソッド
    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

}
