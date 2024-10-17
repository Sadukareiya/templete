package com.diworksdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.diworksdev.template.util.DBConnector;
import com.diworksdev.template.util.DateUtil;

/**
 * UserCreateCompleteDAOクラスは、ユーザー情報をデータベースに保存するためのDAOクラスです。
 */
public class UserCreateCompleteDAO {

    // DateUtilクラスのインスタンスを作成して、現在日時を取得できるようにする
    private DateUtil dateUtil = new DateUtil();

    // ユーザー情報を保存するためのSQLクエリ
    private String sql = "INSERT INTO login_user_transaction (login_id, login_pass, user_name, insert_date) VALUES(?, ?, ?, ?)";

    /**
     * ユーザー情報をデータベースに挿入します。
     *
     * @param loginUserId        ユーザーID
     * @param loginUserPassword   ユーザーパスワード
     * @param userName            ユーザー名
     * @throws SQLException SQL実行中に発生した例外
     */
    public void createUser(String loginUserId, String loginUserPassword, String userName) throws SQLException {
        // DBConnectorインスタンスを作成し、データベース接続を取得
    	DBConnector dbConnector = new DBConnector();
        Connection connection = dbConnector.getConnection();

        try {
            // SQL文をプリペアドステートメントにセット
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // プレースホルダーにパラメータをセット
            preparedStatement.setString(1, loginUserId);
            preparedStatement.setString(2, loginUserPassword);
            preparedStatement.setString(3, userName);
            preparedStatement.setString(4, dateUtil.getDate());  // 現在日時をセット

            // SQLクエリを実行
            preparedStatement.execute();

        } catch (Exception e) {
            // エラーが発生した場合、スタックトレースを表示
            e.printStackTrace();

        } finally {
            // 接続を閉じる
            connection.close();
        }
    }
}
