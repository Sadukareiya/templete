package com.diworksdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.diworksdev.template.util.DBConnector;
import com.diworksdev.template.util.DateUtil;

public class BuyItemCompleteDAO {

    // 日付取得ユーティリティ
    private DateUtil dateUtil = new DateUtil();

    // SQL文：商品購入情報をuser_buy_item_transactionテーブルに挿入
    private String sql = "INSERT INTO user_buy_item_transaction (item_transaction_id, total_price, total_count, user_master_id, pay, insert_date) "
                       + "VALUES(?, ?, ?, ?, ?, ?)";

    // 商品購入情報をデータベースに保存するメソッド
    public void buyItemeInfo(String item_transaction_id, String user_master_id, String total_price, String total_count, String pay) throws SQLException {
        DBConnector dbConnector = new DBConnector(); // DB接続用クラスのインスタンスを生成
        Connection connection = dbConnector.getConnection(); // データベース接続

        try {
            // SQL文を実行するためのPreparedStatementを作成
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // プレースホルダに値を設定
            preparedStatement.setString(1, item_transaction_id);
            preparedStatement.setString(2, total_price);
            preparedStatement.setString(3, total_count);
            preparedStatement.setString(4, user_master_id);
            preparedStatement.setString(5, pay);
            preparedStatement.setString(6, dateUtil.getDate());

            // SQL文を実行
            preparedStatement.execute();

        } catch (Exception e) {
            // エラー発生時の処理
            e.printStackTrace();

        } finally {
            // データベース接続を閉じる
            connection.close();
        }
    }
}
