package com.diworksdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement; // 修正: PrepareStatement -> PreparedStatement
import java.sql.ResultSet;

import com.diworksdev.template.dto.BuyItemDTO;
import com.diworksdev.template.util.DBConnector;

public class BuyItemDAO {

    // 購入アイテム情報を取得するメソッド
    public BuyItemDTO getBuyItemInfo() {
        DBConnector dbConnector = new DBConnector();
        Connection connection = dbConnector.getConnection(); // 修正: 'getConnection'が正しい
        BuyItemDTO buyItemDTO = new BuyItemDTO();

        // SQLクエリの修正: 'if' -> 'id' に変更
        String sql = "SELECT id, item_name, item_price FROM item_info_transaction";

        try {
            // 修正: PrepparedStatement -> PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            // データが存在すればDTOに設定
            if (resultSet.next()) {
                buyItemDTO.setId(resultSet.getInt("id"));
                buyItemDTO.setItemName(resultSet.getString("item_name"));
                buyItemDTO.setItemPrice(resultSet.getString("item_price"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 修正: スペースが多すぎた部分を修正
        return buyItemDTO;
    }
}
