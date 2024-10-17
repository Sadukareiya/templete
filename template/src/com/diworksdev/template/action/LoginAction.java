package com.diworksdev.template.action;

import java.util.Map; // セッション情報を扱うためにMapを使用

import org.apache.struts2.interceptor.SessionAware; // セッションを管理するためのインターフェース

import com.diworksdev.template.dao.BuyItemDAO; // 購入アイテム情報を取得するためのDAOクラス
import com.diworksdev.template.dao.LoginDAO; // ログイン情報を取得するためのDAOクラス
import com.diworksdev.template.dto.BuyItemDTO; // 購入アイテムのデータを保持するDTOクラス
import com.diworksdev.template.dto.LoginDTO; // ログイン情報を保持するDTOクラス
import com.opensymphony.xwork2.ActionSupport; // Struts2でActionクラスをサポートするためのクラス

// LoginActionクラスは、ユーザーのログイン処理とセッション管理を行うクラスです。
// Struts2のActionSupportクラスを継承し、SessionAwareインターフェースを実装しています。
public class LoginAction extends ActionSupport implements SessionAware {

    // ユーザーが入力したログインIDとパスワードを保持するフィールド
    private String loginUserId; // ログインID
    private String loginPassword; // ログインパスワード

    // Struts2のアクション結果（SUCCESS, ERRORなど）を保持するフィールド
    private String result;

    // ユーザーのセッション情報を保持するMap
    private Map<String, Object> session;

    // executeメソッドは、ログイン処理のエントリーポイントです。
    // Struts2のアクションが実行されるとこのメソッドが呼ばれます。
    public String execute() {
        // ログインユーザー情報を取得するためのLoginDAOオブジェクトを生成
        LoginDAO loginDAO = new LoginDAO();
        LoginDTO loginDTO = new LoginDTO(); // ログイン結果を保持するDTOオブジェクト
        BuyItemDAO buyItemDAO = new BuyItemDAO(); // 購入アイテム情報を取得するためのDAOオブジェクト

        // 処理結果の初期値としてERRORを設定
        result = ERROR;

        // DAOを使って、入力されたログインIDとパスワードに基づくユーザー情報を取得
        loginDTO = loginDAO.getLoginUserInfo(loginUserId, loginPassword);

        // 取得したログイン情報をセッションに保存
        session.put("loginUser", loginDTO);

        // ログイン成功判定：loginFlgがtrueの場合
        if (((LoginDTO) session.get("loginUser")).getLoginFlg()) {
            // 成功した場合、処理結果をSUCCESSに設定
            result = SUCCESS;

            // 購入アイテム情報をDAOを使って取得
            BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();

            // 取得したユーザー情報やアイテム情報をセッションに保存
            session.put("login_user_id", loginDTO.getLoginId());
            session.put("id", buyItemDTO.getId());
            session.put("buyItem_name", buyItemDTO.getItemName());
            session.put("buyItem_price", buyItemDTO.getItemPrice());

            // 処理が成功した場合の結果を返す
            return result;
        }

        // ログインに失敗した場合、ERRORを返す
        return result;
    }

    // 以下のメソッドは、ログインIDとパスワードを取得・設定するためのgetterとsetterです。

    // ログインIDを取得するgetterメソッド
    public String getLoginUserId() {
        return loginUserId;
    }

    // ログインIDを設定するsetterメソッド
    public void setLoginUserId(String loginUserId) {
        this.loginUserId = loginUserId;
    }

    // ログインパスワードを取得するgetterメソッド
    public String getLoginPassword() {
        return loginPassword;
    }

    // ログインパスワードを設定するsetterメソッド
    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    // セッション情報を取得するgetterメソッド
    public Map<String, Object> getSession() {
        return session;
    }

    // セッション情報を設定するsetterメソッド
    // SessionAwareインターフェースを実装することで、セッションの管理が可能になります。
    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
