package com.diworksdev.template.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.template.dao.UserCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ユーザー新規作成を完了させるアクション。
 * ユーザー情報をデータベースに保存するための処理を行います。
 */
public class UserCreateCompleteAction extends ActionSupport implements SessionAware {

    // ユーザーID
    private String loginUserId;
    // ユーザーパスワード
    private String loginPassword;
    // ユーザー名
    private String userName;
    // セッション情報を格納するマップ
    private Map<String, Object> session;

    /**
     * executeメソッドは、ユーザー情報をデータベースに保存し、成功結果を返します。
     * @return SUCCESS（ユーザー作成が成功した場合）
     * @throws SQLException データベースエラーが発生した場合にスローされる例外
     */
    public String execute() throws SQLException {
        // ユーザー情報を保存するためのDAOクラスのインスタンスを作成
        UserCreateCompleteDAO userCreateCompleteDAO = new UserCreateCompleteDAO();

        // セッションから取得した情報を使用して新規ユーザーをデータベースに登録
        userCreateCompleteDAO.createUser(
            session.get("loginUserId").toString(),   // ユーザーID
            session.get("loginPassword").toString(), // パスワード
            session.get("userName").toString()       // ユーザー名
        );

        // 処理が成功した場合にSUCCESSを返す
        return SUCCESS;
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
}

