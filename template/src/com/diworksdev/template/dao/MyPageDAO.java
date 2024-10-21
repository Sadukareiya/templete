package com.diworksdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.diworksdev.template.dto.MyPageDTO;
import com.diworksdev.template.util.DBConnector;

public class MyPageDAO {

    // ユーザーが購入した商品の情報を取得するメソッド
    public MyPageDTO getMyPageUserInfo(String item_transaction_id, String user_master_id)
            throws SQLException {

        // データベースに接続するためのオブジェクトを生成
        DBConnector dbConnector = new DBConnector();
        Connection connection = dbConnector.getConnection();

        // 購入情報を格納するDTOオブジェクトを作成
        MyPageDTO myPageDTO = new MyPageDTO();

        // SQLクエリを定義（ユーザーの購入情報を取得）
        String sql = "SELECT iit.item_name, ubit.total_price, ubit.total_count, ubit.pay " +
                     "FROM user_buy_item_transaction ubit " +
                     "LEFT JOIN item_info_transaction iit ON ubit.item_transaction_id = iit.id " +
                     "WHERE ubit.item_transaction_id = ? AND ubit.user_master_id = ? " +
                     "ORDER BY ubit.insert_date DESC";

        try {
            // SQLを実行するための準備
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // プレースホルダーにパラメータをセット（購入トランザクションIDとユーザーID）
            preparedStatement.setString(1, item_transaction_id);
            preparedStatement.setString(2, user_master_id);

            // クエリを実行して結果を取得
            ResultSet resultSet = preparedStatement.executeQuery();

            // 結果が存在する場合、DTOに値をセット
            if(resultSet.next()) {
                myPageDTO.setItemName(resultSet.getString("item_name"));
                myPageDTO.setTotalPrice(resultSet.getString("total_price"));
                myPageDTO.setTotalCount(resultSet.getString("total_count"));
                myPageDTO.setPayment(resultSet.getString("pay"));
            }
        } catch(Exception e) {
            e.printStackTrace(); // エラーが発生した場合は、エラーメッセージを表示
        } finally {
            connection.close(); // 接続を閉じる
        }

        // DTOを返す
        return myPageDTO;
    }

    // ユーザーの購入履歴を削除するメソッド
    public int buyItemHistoryDelete(String item_transaction_id, String user_master_id)
            throws SQLException {

        // データベースに接続するためのオブジェクトを生成
        DBConnector dbConnector = new DBConnector();
        Connection connection = dbConnector.getConnection();

        // 購入履歴を削除するSQLクエリを定義
        String sql = "DELETE FROM user_buy_item_transaction WHERE item_transaction_id = ? AND user_master_id = ?";

        PreparedStatement preparedStatement;
        int result = 0;

        try {
            // SQLを実行するための準備
            preparedStatement = connection.prepareStatement(sql);

            // プレースホルダーにパラメータをセット（購入トランザクションIDとユーザーID）
            preparedStatement.setString(1, item_transaction_id);
            preparedStatement.setString(2, user_master_id);

            // クエリを実行して削除の結果を取得
            result = preparedStatement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace(); // エラーが発生した場合は、エラーメッセージを表示
        } finally {
            connection.close(); // 接続を閉じる
        }

        // 削除が成功したかどうかを返す
        return result;
    }

}

