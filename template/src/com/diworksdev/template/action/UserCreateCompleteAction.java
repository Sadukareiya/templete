package com.diworksdev.template.action;

import java.sql.SQLException; // SQL関連の例外を処理するためのインポート
import java.util.Map; // マップを使用するためのインポート

import org.apache.struts2.interceptor.SessionAware; // セッションを扱うためのインターフェース

import com.diworksdev.template.dao.UserCreateCompleteDAO; // DAOクラスのインポート
import com.opensymphony.xwork2.ActionSupport; // ActionSupportクラスのインポート

public class UserCreateCompleteAction extends ActionSupport implements SessionAware {
    // フィールドの定義
    private String loginUserId; // ログインID
    private String loginPassword; // ログインパスワード
    private String userName; // ユーザー名
    private Map<String, Object> session; // セッション情報を格納するマップ

    // executeメソッド
    public String execute() throws SQLException {
        UserCreateCompleteDAO userCreateCompleteDAO = new UserCreateCompleteDAO(); // DAOのインスタンスを作成

        // セッションからユーザー情報を取得してユーザーを作成
        userCreateCompleteDAO.createUser(
            session.get("loginUserId").toString(),
            session.get("loginPassword").toString(),
            session.get("userName").toString()
        );

        String result = SUCCESS; // 成功結果を返す
        return result; // 成功を返す
    }

    // getterメソッド
    public String getLoginUserId() {
        return loginUserId; // ログインIDを返す
    }

    // setterメソッド
    public void setLoginUserId(String loginUserId) {
        this.loginUserId = loginUserId; // ログインIDを設定
    }

    // getterメソッド
    public String getLoginPassword() {
        return loginPassword; // ログインパスワードを返す
    }

    // setterメソッド
    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword; // ログインパスワードを設定
    }

    // getterメソッド
    public String getUserName() {
        return userName; // ユーザー名を返す
    }

    // setterメソッド
    public void setUserName(String userName) {
        this.userName = userName; // ユーザー名を設定
    }

    // getterメソッド
    public Map<String, Object> getSession() {
        return session; // セッション情報を返す
    }

    // setterメソッド
    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session; // セッション情報を設定
    }
}
