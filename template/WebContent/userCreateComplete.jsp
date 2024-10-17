<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="Content-Style-Type" content="text/css" />
    <meta http-equiv="Content-Script-Type" content="text/javascript" />
    <meta http-equiv="imagetoolbar" content="no" />
    <meta name="description" content="" />
    <meta name="keywords" content="" />
    <title>UserCreateComplete画面</title>
    <style type="text/css">
        /* ========TAG LAYOUT======== */
        body {
            margin: 0; /* マージンを0に設定 */
            padding: 0; /* パディングを0に設定 */
            line-height: 1.6; /* 行間を設定 */
            letter-spacing: 1px; /* 文字間隔を設定 */
            font-family: Verdana, Helvetica, sans-serif; /* フォントファミリーを設定 */
            font-size: 12px; /* フォントサイズを設定 */
            color: #333; /* 文字色を設定 */
            background: #fff; /* 背景色を白に設定 */
        }

        table {
            text-align: center; /* テーブル内のテキストを中央寄せ */
            margin: 0 auto; /* テーブルを中央に配置 */
        }

        /* ========ID LAYOUT======== */
        #top {
            width: 780px; /* 幅を設定 */
            margin: 30px auto; /* 上下30pxのマージンを設定し中央に配置 */
            border: 1px solid #333; /* 枠線を設定 */
        }

        #header {
            width: 100%; /* 幅を100%に設定 */
            height: 80px; /* 高さを80pxに設定 */
            background-color: black; /* 背景色を黒に設定 */
        }

        #main {
            width: 100%; /* 幅を100%に設定 */
            height: 500px; /* 高さを500pxに設定 */
            text-align: center; /* テキストを中央寄せ */
        }

        #footer {
            width: 100%; /* 幅を100%に設定 */
            height: 80px; /* 高さを80pxに設定 */
            background-color: black; /* 背景色を黒に設定 */
            clear: both; /* フロートを解除 */
        }
    </style>
</head>
<body>
    <div id="header">
        <div id="pr"></div> <!-- ヘッダー内のプレースホルダー -->
    </div>
    <div id="main">
        <div id="top">
            <p>User Create Complete</p> <!-- 完了メッセージ -->
        </div>
        <div>
            <h3>ユーザーの登録が完了致しました。</h3> <!-- ユーザー登録完了のメッセージ -->
            <div>
                <a href='<s:url action="HomeAction" />'>ログインへ</a> <!-- ホームアクションへのリンク -->
            </div>
        </div>
    </div>
    <div id="footer">
        <div id="pr"></div> <!-- フッター内のプレースホルダー -->
    </div>
</body>
</html>

