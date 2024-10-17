package com.diworksdev.template.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * UserCreateConfirmAction クラス
 * ユーザー作成確認画面におけるアクションを実行します。
 */
public class UserCreateConfirmAction extends ActionSupport implements SessionAware {

    // ユーザーID、パスワード、ユーザー名、セッション、エラーメッセージの変数
    private String loginUserId;
    private String loginPassword;
    private String userName;
    public Map<String, Object> session;
    private String errorMessage;

    /**
     * execute メソッド
     * 入力チェックを行い、エラーがなければセッションにデータを保存して成功を返します。
     * @return SUCCESSまたはERROR
     */
    public String execute() {
        String result = SUCCESS;

        // 入力された値が全て空でないかを確認
        if (!(loginUserId.equals("")) && !(loginPassword.equals("")) && !(userName.equals(""))) {
            // セッションにユーザーID、パスワード、ユーザー名を保存
            session.put("loginUserId", loginUserId);
            session.put("loginPassword", loginPassword);
            session.put("userName", userName);
        } else {
            // 未入力項目があればエラーメッセージをセットし、結果をERRORに設定
            setErrorMessage("未入力の項目があります。");
            result = ERROR;
        }
        return result;
    }

    // ゲッターとセッター
    public String getLoginUserId() {
        return loginUserId;
    }

    public void setLoginUserId(String loginUserId) {
        this.loginUserId = loginUserId;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
