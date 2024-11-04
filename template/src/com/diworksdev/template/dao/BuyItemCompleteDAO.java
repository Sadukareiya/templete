package com.diworksdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.diworksdev.template.util.DBConnector;
import com.diworksdev.template.util.DateUtil;

/**
 * BuyItemCompleteDAO クラス
 * 商品購入情報をデータベースに保存するためのクラスです。
 */
public class BuyItemCompleteDAO {

    // 日付を取得するためのユーティリティクラス
    private DateUtil dateUtil = new DateUtil();

    // SQL文：購入情報を user_buy_item_transaction テーブルに挿入
    private String sql = "INSERT INTO user_buy_item_transaction (item_transaction_id, total_price, total_count, user_master_id, pay, insert_date) "
                       + "VALUES(?, ?, ?, ?, ?, ?)";

    /**
     * 商品購入情報をデータベースに保存するメソッド。
     * @param item_transaction_id 商品取引ID
     * @param user_master_id ユーザーマスターID
     * @param total_price 合計金額
     * @param total_count 購入数
     * @param pay 支払い方法
     * @throws SQLException データベースエラーが発生した場合
     */
    public void buyItemeInfo(String item_transaction_id, String user_master_id, String total_price, String total_count, String pay) throws SQLException {
        // データベース接続用のクラスインスタンスを生成
        DBConnector dbConnector = new DBConnector();
        // データベース接続を取得
        Connection connection = dbConnector.getConnection();

        try {
            // SQL文を実行するための PreparedStatement を作成
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // SQL文のプレースホルダに値を設定
            preparedStatement.setString(1, item_transaction_id);  // 商品取引ID
            preparedStatement.setString(2, total_price);          // 合計金額
            preparedStatement.setString(3, total_count);          // 購入数
            preparedStatement.setString(4, user_master_id);       // ユーザーマスターID
            preparedStatement.setString(5, pay);                  // 支払い方法
            preparedStatement.setString(6, dateUtil.getDate());   // 挿入日

            // SQL文を実行してデータベースに購入情報を保存
            preparedStatement.execute();

        } catch (Exception e) {
            // エラーが発生した場合はエラーメッセージを出力
            e.printStackTrace();

        } finally {
            // 最後にデータベース接続を閉じる
            connection.close();
        }
    }
}

