package com.diworksdev.template.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.template.dao.MyPageDAO;
import com.diworksdev.template.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware {

    // ユーザーのセッション情報を格納するMap
    public Map<String, Object> session;

    // 商品履歴を削除するかどうかを判断するフラグ
    public String deleteFlg;

    // 処理結果を返すための変数
    private String result;

    // 実行メソッド（Strutsが自動的に呼び出す）
    public String execute() throws SQLException {
        // DAO（データアクセスオブジェクト）を使ってデータベース操作を行う
        MyPageDAO myPageDAO = new MyPageDAO();
        MyPageDTO myPageDTO = new MyPageDTO();

        // 商品履歴を削除しない場合の処理
        if (deleteFlg == null) {
            // セッションから商品IDとユーザーIDを取得
            String item_transaction_id = session.get("id").toString();
            String user_master_id = session.get("login_user_id").toString();

            // データベースからユーザーの購入履歴を取得
            myPageDTO = myPageDAO.getMyPageUserInfo(item_transaction_id, user_master_id);

            // 取得した情報をセッションに保存
            session.put("buyItem_name", myPageDTO.getItemName());
            session.put("total_price", myPageDTO.getTotalPrice());
            session.put("total_count", myPageDTO.getTotalCount());
            session.put("total_payment", myPageDTO.getPayment());
            session.put("message", "");  // メッセージは空にする
        }
        // 商品履歴を削除する場合の処理
        else if (deleteFlg.equals("1")) {
            delete();  // 削除メソッドを呼び出す
        }

        // 処理結果をSUCCESSとして返す
        result = SUCCESS;
        return result;
    }

    // 商品履歴を削除するメソッド
    public void delete() throws SQLException {
        MyPageDAO myPageDAO = new MyPageDAO();

        // セッションから商品IDとユーザーIDを取得
        String item_transaction_id = session.get("id").toString();
        String user_master_id = session.get("login_user_id").toString();

        // 商品履歴をデータベースから削除
        int res = myPageDAO.buyItemHistoryDelete(item_transaction_id, user_master_id);

        // 削除の結果に応じたメッセージをセッションに保存
        if (res > 0) {
            session.put("message", "商品情報を正しく削除しました。");
        } else if (res == 0) {
            session.put("message", "商品情報の削除に失敗しました。");
        }
    }

    // deleteFlgのゲッター
    public String getDeleteFlg() {
        return deleteFlg;
    }

    // deleteFlgのセッター
    public void setDeleteFlg(String deleteFlg) {
        this.deleteFlg = deleteFlg;
    }

    // セッションを設定するメソッド（SessionAwareインターフェースの実装）
    @Override
    public void setSession(Map<String, Object> loginSessionMap) {
        this.session = loginSessionMap;
    }
}

