<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
    <!-- ページのメタ情報を指定しています。文字コードやスタイル、スクリプトなどの基本設定です。 -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="Content-Style-Type" content="text/css" />
    <meta http-equiv="Content-Script-Type" content="text/javascript" />
    <meta http-equiv="imagetoolbar" content="no" />
    <meta name="description" content="" />
    <meta name="keywords" content="" />

    <!-- タイトルを設定しています。ブラウザのタブに表示される内容です。 -->
    <title>MyPage画面</title>

    <!-- ページのデザイン（CSS）を記述します。 -->
    <style type="text/css">
        /* ======== ページ全体の設定 ======== */
        body {
            margin: 0; /* 余白なし */
            padding: 0; /* パディングなし */
            line-height: 1.6; /* 行の高さ */
            letter-spacing: 1px; /* 文字の間隔 */
            font-family: Verdana, Helvetica, sans-serif; /* 使用するフォント */
            font-size: 12px; /* 文字のサイズ */
            color: #333; /* 文字色 */
            background: #fff; /* 背景色 */
        }
        /* テーブルの中央揃え設定 */
        table {
            text-align: center;
            margin: 0 auto; /* テーブルを中央に配置 */
        }

        /* ======== IDごとのレイアウト設定 ======== */
        #top {
            width: 780px;
            margin: 30px auto; /* 上下に30px、左右は中央 */
            border: 1px solid #333; /* 枠線 */
        }
        #header {
            width: 100%;
            height: 80px;
            background-color: black; /* 背景色を黒に設定 */
        }
        #main {
            width: 100%;
            height: 500px;
            text-align: center; /* テキストを中央揃えに */
        }
        #footer {
            width: 100%;
            height: 80px;
            background-color: black; /* 背景色を黒に設定 */
            clear: both; /* レイアウトの崩れを防ぐため */
        }
    </style>
</head>

<body>
    <!-- ヘッダー部分の開始 -->
    <div id="header">
        <div id="pr">
            <!-- ヘッダー部分の中身は空にしていますが、必要に応じて内容を追加します。 -->
        </div>
    </div>
    <!-- ヘッダー部分の終了 -->

    <!-- メインコンテンツ部分の開始 -->
    <div id="main">
        <div id="top">
            <!-- ページのタイトルを表示します。 -->
            <p>MyPage</p>
        </div>

        <!-- session.message が空の場合、購入情報を表示します -->
        <div>
            <s:if test="session.message == ''">
                <h3>ご購入情報は以下になります。</h3>
                <!-- 購入した商品の情報をテーブルで表示 -->
                <table>
                    <tr>
                        <td>商品名</td>
                        <td><s:property value="session.buyItem_name" /></td>
                    </tr>
                    <tr>
                        <td>値段</td>
                        <td><s:property value="session.total_price" /><span>円</span></td>
                    </tr>
                    <tr>
                        <td>購入個数</td>
                        <td><s:property value="session.total_count" /><span>個</span></td>
                    </tr>
                    <tr>
                        <td>支払い方法</td>
                        <td><s:property value="session.total_payment" /></td>
                    </tr>
                </table>

                <!-- 削除用のフォームを表示します。 -->
                <s:form action="MyPageAction">
                    <!-- 削除フラグを隠しパラメータとして送信 -->
                    <input type="hidden" name="deleteFlg" value="1">
                    <!-- 削除ボタンを表示 -->
                    <s:submit value="削除" method="delete" />
                </s:form>
            </s:if>

            <!-- session.message が存在する場合は、その内容を表示します -->
            <s:if test="session.message != null">
                <!-- メッセージを表示 -->
                <h3><s:property value="session.message" /></h3>
            </s:if>

            <!-- 前のページに戻るためのリンクを表示 -->
            <div>
                <br>
                <span>前画面に戻る場合は</span>
                <a href='<s:url action="HomeAction" />'>ログアウト</a>
                <span>をお願いします</span>
            </div>
        </div>
    </div>
    <!-- メインコンテンツ部分の終了 -->

    <!-- フッター部分の開始 -->
    <div id="footer">
        <div id="pr">
            <!-- フッター部分の中身は空にしていますが、必要に応じて内容を追加します。 -->
        </div>
    </div>
    <!-- フッター部分の終了 -->
</body>
</html>
