-- データベースの文字セットをUTF-8に設定
set names utf8;

-- 外部キー制約を無効化
set foreign_key_checks = 0;

-- "ecsite" データベースが存在する場合は削除し、新しく作成
drop database if exists ecsite;
create database if not exists ecsite;
use ecsite;

-- login_user_transaction テーブルを削除してから再作成
drop table if exists login_user_transaction;

create table login_user_transaction (
    id int not null primary key auto_increment, -- ユーザーID（自動増加）
    login_id varchar(16) unique, -- ログインID（16文字以内の一意）
    login_pass varchar(16), -- ログインパスワード（16文字以内）
    user_name varchar(50), -- ユーザー名（50文字以内）
    insert_date datetime, -- データ作成日
    updated_date datetime -- データ更新日
);

-- item_info_transaction テーブルを削除してから再作成
drop table if exists item_info_transaction;

create table item_info_transaction (
    id int not null primary key auto_increment, -- 商品ID（自動増加）
    item_name varchar(30), -- 商品名（30文字以内）
    item_price int, -- 商品価格
    item_stock int, -- 在庫数
    insert_date datetime, -- データ作成日
    update_date datetime -- データ更新日
);

-- user_buy_item_transaction テーブルを削除してから再作成
drop table if exists user_buy_item_transaction;

create table user_buy_item_transaction (
    id int not null primary key auto_increment, -- トランザクションID（自動増加）
    item_transaction_id int, -- アイテムのトランザクションID
    total_price int, -- 合計価格
    total_count int, -- 購入数
    user_master_id varchar(16), -- ユーザーID
    pay varchar(30), -- 支払い方法（30文字以内）
    insert_date datetime, -- データ作成日
    delete_date datetime -- データ削除日（削除された場合に使用）
);

-- 商品情報を item_info_transaction テーブルに挿入
INSERT INTO item_info_transaction (item_name, item_price, item_stock)
VALUES ("ノートBook", 100, 50);


-- ログイン情報を login_user_transaction テーブルに挿入
INSERT INTO login_user_transaction (login_id, login_pass, user_name)
VALUES ("internous", "internous01", "test" );
