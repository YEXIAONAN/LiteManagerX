-- ===============================
-- 创建项目数据库
-- ===============================
CREATE DATABASE LiteManagerX;  -- 创建名为 LiteManagerX 的数据库

-- ===============================
-- 创建项目默认用户
-- ===============================
CREATE USER 'LMX'@'%' IDENTIFIED BY 'Admin#123..';
-- 'LMX'@'%'：用户名 LMX，可从任意主机连接
-- IDENTIFIED BY 'Admin#123..'：设置登录密码

-- ===============================
-- 授权用户操作数据库
-- ===============================
GRANT ALL PRIVILEGES ON LiteManagerX.* TO 'LMX'@'%';
-- 授权 LMX 用户对 LiteManagerX 数据库的所有操作权限
FLUSH PRIVILEGES;
-- 刷新权限，使修改立即生效

-- ===============================
-- 使用 LiteManagerX 数据库
-- ===============================
USE LiteManagerX;

-- ===============================
-- 创建用户表
-- ===============================
CREATE TABLE User (
    U_id INT AUTO_INCREMENT PRIMARY KEY,      -- 用户ID，自增主键
    U_name VARCHAR(20) NOT NULL,        -- 用户名
    U_password VARCHAR(255) NOT NULL,   -- 密码
    U_gender CHAR(1),                   -- 性别，M/F
    U_phone VARCHAR(15),                -- 电话，VARCHAR 避免丢失前导零
    U_group VARCHAR(10)                 -- 用户分组/角色
);

-- ===============================
-- 插入默认管理员用户
-- ===============================
INSERT INTO user (user_name, user_password, user_gender, user_phone, user_group)
VALUES ('admin', 'Admin#123..', 'M', '13800000000', 'admin');
VALUES ('user', 'Admin#123..', 'M', '13800000001', 'user');
-- 创建一个默认管理员账户，密码为明文，生产环境建议加密
