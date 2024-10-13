package com.diworksdev.template.dto;

/**
 * LoginDTOクラスは、ログインに関連するデータを管理するためのデータ転送オブジェクトです。
 * DTO (Data Transfer Object) は、データを一時的に保持するために使用されます。
 */
public class LoginDTO {

    // ログインIDを保持する変数
    private String loginId;

    // ログインパスワードを保持する変数
    private String loginPassword;

    // ユーザー名を保持する変数
    private String userName;

    // ログインしているかどうかを判定するフラグ (true: ログイン中, false: ログアウト)
    private boolean loginFlg = false;

    // ログインIDを取得するメソッド
    public String getLoginId() {
        return loginId;
    }

    // ログインIDを設定するメソッド
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    // ログインパスワードを取得するメソッド
    public String getLoginPassword() {
        return loginPassword;
    }

    // ログインパスワードを設定するメソッド
    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    // ユーザー名を取得するメソッド
    public String getUserName() {
        return userName;
    }

    // ユーザー名を設定するメソッド
    public void setUserName(String userName) {
        this.userName = userName;
    }

    // ログインフラグを取得するメソッド
    public boolean getLoginFlg() {
        return loginFlg;
    }

    // ログインフラグを設定するメソッド
    public void setLoginFlg(boolean loginFlg) {
        this.loginFlg = loginFlg;
    }
}
