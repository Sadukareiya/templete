<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%> <!-- Struts2 タグライブラリの定義 -->
<!DOCTYPE html>
<html>
<head>
    <!-- ページのメタ情報 -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="Content-Style-Type" content="text/css" />
    <meta http-equiv="Content-Script-Type" content="text/javascript" />
    <meta http-equiv="imagetoolbar" content="no" />
    <meta name="description" content="" />
    <meta name="keywords" content="" />

    <!-- ページタイトル -->
    <title>buyItemConfirm画面</title>

    <!-- スタイル定義 -->
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
            border: 1px solid #333; /* ボーダーを追加 */
        }
        #header {
            width: 100%;
            height: 80px;
            background-color: black; /* ヘッダーの背景色を黒に設定 */
        }
        #main {
            width: 100%;
            height: 500px;
            text-align: center; /* 中央揃え */
        }
        #footer {
            width: 100%;
            height: 80px;
            background-color: black; /* フッターの背景色を黒に設定 */
            clear: both;
        }
    </style>
</head>
<body>
    <!-- ヘッダーエリア -->
    <div id="header">
        <div id="pr"></div> <!-- 空の要素（後でコンテンツを追加するかもしれない） -->
    </div>

    <!-- メインコンテンツエリア -->
    <div id="main">
        <div id="top">
            <p>BuyItemConfirm</p> <!-- ページタイトルの表示 -->
        </div>

        <!-- 商品購入確認フォーム -->
        <div>
            <!-- Struts2フォーム：BuyItemConfirmActionにデータを送信 -->
            <s:form action="BuyItemConfirmAction">
                <table>
                    <!-- 商品名の表示 -->
                    <tr>
                        <td>商品名</td>
                        <td><s:property value="session.buyItem_name" /></td> <!-- セッションから商品名を取得 -->
                    </tr>

                    <!-- 商品価格の表示 -->
                    <tr>
                        <td>値段</td>
                        <td>
                            <s:property value="session.buyItem_price" /> <!-- セッションから価格を取得 -->
                            <span>円</span>
                        </td>
                    </tr>

                    <!-- 購入個数の表示 -->
                    <tr>
                        <td>購入個数</td>
                        <td>
                            <s:property value="session.stock" /> <!-- セッションから購入個数を取得 -->
                            <span>個</span>
                        </td>
                    </tr>

                    <!-- 支払い方法の表示 -->
                    <tr>
                        <td>支払い方法</td>
                        <td>
                            <s:property value="session.pay" /> <!-- セッションから支払い方法を取得 -->
                        </td>
                    </tr>

                    <!-- 確認ボタン -->
                    <tr>
                        <td><s:submit value="完了" /></td> <!-- 完了ボタンでフォームを送信 -->
                    </tr>
                </table>
            </s:form>
        </div>
    </div>

    <!-- フッターエリア -->
    <div id="footer">
        <div id="pr"></div> <!-- 空の要素（後でコンテンツを追加するかもしれない） -->
    </div>
</body>
</html>

