package com.diworksdev.template.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DateUtilクラスは、現在の日付と時刻を特定のフォーマットで取得するためのユーティリティクラスです。
 */
public class DateUtil {

    /**
     * 現在の日付と時刻を "yyyy/MM/dd HH.mm:ss" フォーマットで取得します。
     *
     * @return フォーマットされた日付文字列
     */
    public String getDate() {
        // 現在の日付を取得
        Date date = new Date();

        // 日付フォーマットを定義
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH.mm:ss");

        // 日付をフォーマットして返す
        return simpleDateFormat.format(date);
    }
}
