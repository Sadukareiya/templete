<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
    <!-- ページのメタ情報を設定 -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="Content-Style-Type" content="text/css" />
    <meta http-equiv="Content-Script-Type" content="text/javascript" />
    <meta http-equiv="imagetoolbar" content="no" />
    <meta name="description" content="" />
    <meta name="keywords" content="" />
    <!-- ページタイトルを設定 -->
    <title>Login画面</title>

    <!-- ページのスタイルを設定 -->
    <style type="text/css">
        /* ========TAG LAYOUT======== */
        body {
            margin: 0;
            padding: 0;
            line-height: 1.6;
            letter-spacing: 1px;
            font-family: Verdana, Helvetica, sans-serif;
            font-size: 12px;
            color: #333;
            background: #fff;
        }
        table {
            text-align: center;
            margin: 0 auto;
        }
        /* ========ID LAYOUT======== */
        #top {
            width: 780px;
            margin: 30px auto;
            border: 1px solid #333;
        }
        #header {
            width: 100%;
            height: 80px;
            background-color: black;
        }
        #main {
            width: 100%;
            height: 500px;
            text-align: center;
        }
        #footer {
            width: 100%;
            height: 80px;
            background-color: black;
            clear: both;
        }
    </style>
</head>
<body>
    <!-- ヘッダーセクション -->
    <div id="header">
        <div id="pr">
            <!-- 広告スペースやプロモーション用の領域 -->
        </div>
    </div>

    <!-- メインコンテンツセクション -->
    <div id="main">
        <div id="top">
            <!-- ログイン画面の見出し -->
            <p>Login</p>
        </div>

        <div>
            <!-- ログインの説明 -->
            <h3>商品を購入する際にはログインをお願いします。</h3>

            <!-- Struts2のフォームを使ったログインフォーム -->
            <s:form action="LoginAction">
                <!-- ユーザーIDの入力欄 -->
                <s:textfield name="loginUserId"/>
                <!-- パスワードの入力欄 -->
                <s:password name="loginPassword"/>
                <!-- ログインボタン -->
                <s:submit value="ログイン"/>
            </s:form>

            <!-- 区切り用の空白 -->
            <br/>
    </div>

    <!-- 新規ユーザー登録へのリンク -->
    <div>
        <span>新規ユーザー登録は
            <a href='<s:url action="UserCreateAction" />'>こちら</a>
        </span>
    </div>
    </div>

    <!-- フッターセクション -->
    <div id="footer">
        <div id="pr">
            <!-- 広告スペースやプロモーション用の領域 -->
        </div>
    </div>
</body>
</html>

