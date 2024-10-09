package com.diworksdev.template.action;

// ActionSupportクラスをインポート
import com.opensymphony.xwork2.ActionSupport;

// HomeActionクラスを定義
public class HomeAction extends ActionSupport {

    // executeメソッドをオーバーライド
    public String execute() {
        // 成功を返す
        return SUCCESS;
    }
}
