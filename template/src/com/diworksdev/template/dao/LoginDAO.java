package com.diworksdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; // SQLExceptionを追加

import com.diworksdev.template.dto.LoginDTO;
import com.diworksdev.template.util.DBConnector;

public class LoginDAO {

    /**
     * ユーザーIDとパスワードを使って、データベースからログイン情報を取得します。
     *
     * @param loginUserId ログインユーザーID
     * @param loginPassword ログインパスワード
     * @return LoginDTO ログイン情報を格納したDTOオブジェクト
     */
    public LoginDTO getLoginUserInfo(String loginUserId, String loginPassword) {
        DBConnector dbConnector = new DBConnector(); // DB接続を行うクラスのインスタンスを生成
        Connection connection = dbConnector.getConnection(); // DB接続を取得
        LoginDTO loginDTO = new LoginDTO(); // ログイン情報を格納するDTO

        // SQLクエリ
        String sql = "SELECT * FROM login_user_transaction WHERE login_id = ? AND login_pass = ?";

        try {
            // SQLクエリの準備とパラメータの設定
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, loginUserId);  // 1つ目のパラメータ（loginUserId）をセット
            preparedStatement.setString(2, loginPassword);  // 2つ目のパラメータ（loginPassword）をセット

            // クエリを実行し、結果セットを取得
            ResultSet resultSet = preparedStatement.executeQuery();

            // 結果が存在するか確認
            if (resultSet.next()) {
                // 結果セットからログイン情報を取得
                loginDTO.setLoginId(resultSet.getString("login_id"));
                loginDTO.setLoginPassword(resultSet.getString("login_pass"));
                loginDTO.setUserName(resultSet.getString("user_name"));

                // ログインIDが存在する場合はログインフラグをtrueに設定
                if (resultSet.getString("login_id") != null) {
                    loginDTO.setLoginFlg(true);
                }
            }

        } catch (SQLException e) {
            // SQL例外が発生した場合のエラーハンドリング
            e.printStackTrace();
        } catch (Exception e) {
            // その他の例外が発生した場合のエラーハンドリング
            e.printStackTrace();
        }

        // ログインDTOを返す
        return loginDTO;
        }
}
