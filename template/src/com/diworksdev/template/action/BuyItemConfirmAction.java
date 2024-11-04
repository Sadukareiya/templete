package com.diworksdev.template.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.template.dao.BuyItemCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 商品購入を確定するアクション。
 * 商品購入情報をデータベースに保存するための処理を行います。
 */
public class BuyItemConfirmAction extends ActionSupport implements SessionAware {

    // セッション情報を保持するマップ
    private Map<String, Object> session;

    /**
     * executeメソッドは、商品の購入処理を行い、結果を返すメソッドです。
     * @return SUCCESS（購入処理が成功した場合）
     * @throws SQLException データベースエラーが発生した場合にスローされる例外
     */
    public String execute() throws SQLException {
        // 購入情報を保存するDAOクラスのインスタンスを作成
        BuyItemCompleteDAO buyItemCompleteDAO = new BuyItemCompleteDAO();

        // セッションから購入情報を取得し、データベースに保存
        buyItemCompleteDAO.buyItemeInfo(
            session.get("id").toString(),               // 商品ID
            session.get("login_user_id").toString(),     // ユーザーID
            session.get("buyItem_price").toString(),     // 商品価格
            session.get("stock").toString(),             // 購入数（在庫）
            session.get("pay").toString()                // 支払い方法
        );

        // 処理が成功した場合にSUCCESSを返す
        return SUCCESS;
    }

    /**
     * セッション情報を取得するためのゲッターメソッド。
     * @return セッション情報のマップ
     */
    public Map<String, Object> getSession() {
        return session;
    }

    /**
     * セッション情報を設定するためのセッターメソッド。
     * @param session セッション情報のマップ
     */
    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

}
