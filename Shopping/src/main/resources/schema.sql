# CREATE TABLE Users
# (
#     id           BIGINT PRIMARY KEY AUTO_INCREMENT,
#     username     NVARCHAR(50),
#     password     NVARCHAR(50),
#     email        NVARCHAR(100),
#     full_name     NVARCHAR(50),
#     gender       BIT,
#     phone VARCHAR(10),
#     address      VARCHAR(200) DEFAULT '',
#     role_id       BIGINT,
#     status  INTEGER
# );
#
# CREATE TABLE Role
# (
#     id   BIGINT PRIMARY KEY AUTO_INCREMENT,
#     name ENUM('ADMIN','CUSTOMER','STAFF') default 'STAFF'
# );
#
# CREATE TABLE category
# (
#     id   BIGINT PRIMARY KEY AUTO_INCREMENT,
#     name nvarchar(50)
# );
# CREATE TABLE size
# (
#     id   BIGINT PRIMARY KEY AUTO_INCREMENT,
#     name nvarchar(50)
# );
# CREATE TABLE sole
# (
#     id   BIGINT PRIMARY KEY AUTO_INCREMENT,
#     name nvarchar(50)
# );
# CREATE TABLE color
# (
#     id   BIGINT PRIMARY KEY AUTO_INCREMENT,
#     name nvarchar(50)
# );
# CREATE TABLE material
# (
#     id   BIGINT PRIMARY KEY AUTO_INCREMENT,
#     name nvarchar(50)
# );
# CREATE TABLE brand
# (
#     id   BIGINT PRIMARY KEY AUTO_INCREMENT,
#     name nvarchar(50)
# );
#
# CREATE TABLE payment
# (
#     id             BIGINT primary key,
#     order_id       BIGINT,
#     payment_date   DATETIME,
#     mount          INT,
#     payment_method enum('CAST','BANKING','TWO'),
#     note           NVARCHAR(100),
#     status         BIT,
#     Code           NVARCHAR(100)
# );
# CREATE TABLE discount
# (
#     id         BIGINT PRIMARY KEY,
#     order_id   BIGINT,
#     type       ENUM('PERCENTAGE', 'AMOUNT'),
#     kind       ENUM('NORMAL', 'FREESHIP'),
#     value      INT,
#     quantity   INT,
#     start_date DATETIME,
#     end_date   DATETIME
# );
#
# CREATE TABLE product
# (
#     id          BIGINT PRIMARY KEY AUTO_INCREMENT,
#     name        NVARCHAR(50),
#     price       FLOAT NOT NULL CHECK (price > 0),
#     description NVARCHAR(255),
#     created_at  DATETIME,
#     updated_at  DATETIME
# );
#
# CREATE TABLE product_detail
# (
#     id          BIGINT PRIMARY KEY AUTO_INCREMENT,
#     product_id  BIGINT,
#     brand_id    BIGINT,
#     category_id BIGINT,
#     color_id    BIGINT,
#     size_id     BIGINT,
#     sole_id     BIGINT,
#     material_id BIGINT,
#     created_at  DATETIME,
#     updated_at  DATETIME
# );
# CREATE TABLE orders(
#     id BIGINT PRIMARY KEY AUTO_INCREMENT,
#     total_Money FLOAT,
#     quantity INTEGER,
#     payment_id BIGINT,
#     customer_id BIGINT,
#     user_id BIGINT,
#     created_at DATETIME,
#     status INTEGER
# );
#
# CREATE TABLE order_detail(
#     id BIGINT PRIMARY KEY AUTO_INCREMENT,
#     order_id BIGINT,
#     product_detail_id BIGINT,
#     quantity INTEGER,
#     total_money FLOAT
# );
# CREATE TABLE customer(
#     id BIGINT PRIMARY KEY AUTO_INCREMENT,
#     full_name  NVARCHAR(50),
#     birthday DATETIME,
#     phone   NVARCHAR(11),
#     address   NVARCHAR(50),
#     created_at DATETIME,
#     updated_at DATETIME
# )
#
