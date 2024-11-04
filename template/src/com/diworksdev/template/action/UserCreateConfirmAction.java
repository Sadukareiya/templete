package com.diworksdev.template.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

/**
 * UserCreateConfirmAction クラス
 * ユーザー作成確認画面におけるアクションを実行し、入力チェックを行います。
 */
public class UserCreateConfirmAction extends ActionSupport implements SessionAware {

    // ユーザーIDを格納する変数
    private String loginUserId;
    // ユーザーパスワードを格納する変数
    private String loginPassword;
    // ユーザー名を格納する変数
    private String userName;
    // セッション情報を格納するマップ
    public Map<String, Object> session;
    // エラーメッセージを格納する変数
    private String errorMessage;

    /**
     * execute メソッド
     * ユーザー入力のチェックを行い、エラーがなければセッションにデータを保存して SUCCESS を返します。
     * @return SUCCESS（入力が正しい場合）、ERROR（未入力がある場合）
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

    // 以下は、各フィールドのゲッターおよびセッターメソッド

    /**
     * ユーザーIDを取得します。
     * @return ユーザーID
     */
    public String getLoginUserId() {
        return loginUserId;
    }

    /**
     * ユーザーIDを設定します。
     * @param loginUserId ユーザーID
     */
    public void setLoginUserId(String loginUserId) {
        this.loginUserId = loginUserId;
    }

    /**
     * ユーザーパスワードを取得します。
     * @return ユーザーパスワード
     */
    public String getLoginPassword() {
        return loginPassword;
    }

    /**
     * ユーザーパスワードを設定します。
     * @param loginPassword ユーザーパスワード
     */
    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    /**
     * ユーザー名を取得します。
     * @return ユーザー名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * ユーザー名を設定します。
     * @param userName ユーザー名
     */
    public void setUserName(String userName) {
        this.userName = userName;
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

    /**
     * エラーメッセージを取得します。
     * @return エラーメッセージ
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * エラーメッセージを設定します。
     * @param errorMessage エラーメッセージ
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}

