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
    <title>UserCreate画面</title>

    <!-- CSSスタイルの定義 -->
    <style type="text/css">
        /* ========タグのレイアウト設定======== */
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

        /* ========IDによるレイアウト設定======== */
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
    <!-- ヘッダー部分 -->
    <div id="header">
        <div id="pr">
        </div>
    </div>

    <!-- メインコンテンツ部分 -->
    <div id="main">
        <div id="top">
            <p>UserCreate</p>
        </div>

        <!-- エラーメッセージが存在する場合に表示 -->
        <div>
            <s:if test="errorMessage != ''">
                <s:property value="errorMessage" escape="false" />
            </s:if>
        </div>

        <!-- ユーザー作成フォーム -->
        <table>
            <s:form action="UserCreateConfirmAction">
                <tr>
                    <td><label>ログインID:</label></td>
                    <td><input type="text" name="loginUserId" value="" /></td>
                </tr>
                <tr>
                    <td><label>ログインPASS:</label></td>
                    <td><input type="text" name="loginPassword" value="" /></td>
                </tr>
                <tr>
                    <td><label>ユーザー名:</label></td>
                    <td><input type="text" name="userName" value="" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <s:submit value="登録" />
                    </td>
                </tr>
            </s:form>
        </table>

        <!-- 前画面に戻るリンク -->
        <div>
            <span>前画面に戻る場合は</span>
            <a href='<s:url action="HomeAction" />'>こちら</a>
        </div>
    </div>

    <!-- フッター部分 -->
    <div id="footer">
        <div id="pr">
        </div>
    </div>
</body>
</html>

