# CREATE TABLE Users(
#     id BIGINT PRIMARY KEY AUTO_INCREMENT,
#     username NVARCHAR(50),
#     password NVARCHAR(50),
#     email  NVARCHAR(100),
#     fullname  NVARCHAR(50),
#     gender BIT,
#     phone_number VARCHAR(10) ,
#     address VARCHAR(200) DEFAULT '',
#     roleid BIGINT,
#     is_Activity INTEGER
# );

# CREATE TABLE Role(
#     id BIGINT PRIMARY KEY AUTO_INCREMENT,
#     name ENUM('ADMIN','CUSTOMER','STAFF') default 'STAFF'
# );
#
# CREATE TABLE category(
#     id BIGINT PRIMARY KEY AUTO_INCREMENT,
#     name nvarchar(50)
# );
# CREATE TABLE size(
#     id BIGINT PRIMARY KEY AUTO_INCREMENT,
#     name nvarchar(50)
# );
# CREATE TABLE sole(
#     id BIGINT PRIMARY KEY AUTO_INCREMENT,
#     name nvarchar(50)
# );
# CREATE TABLE color(
#     id BIGINT PRIMARY KEY AUTO_INCREMENT,
#     name nvarchar(50)
# );
# CREATE TABLE material(
#     id BIGINT PRIMARY KEY AUTO_INCREMENT,
#     name nvarchar(50)
# );
# CREATE TABLE brand(
#     id BIGINT PRIMARY KEY AUTO_INCREMENT,
#     name nvarchar(50)
# );
#
# CREATE TABLE payment(
#     id BIGINT  primary key ,
#     order_id BIGINT,
#     payment_date DATETIME,
#     mount INT,
#     payment_method enum('CAST','BANKING','TWO'),
#     note NVARCHAR(100),
#     status BIT,
#     Code NVARCHAR(100)
# );
# CREATE TABLE discount (
#     id BIGINT PRIMARY KEY,
#     order_id BIGINT,
#     type ENUM('PERCENTAGE', 'AMOUNT'),
#     kind ENUM('NORMAL', 'FREESHIP'),
#     value INT,
#     quantity INT,
#     start_date DATETIME,
#     end_date DATETIME
# );
#
# CREATE TABLE product(
#     id BIGINT PRIMARY KEY AUTO_INCREMENT,
#     name NVARCHAR(50),
#     price FLOAT NOT NULL CHECK (price>0),
#     description NVARCHAR(255),
#     created_at DATETIME,
#     updated_at DATETIME
# );
#
# CREATE TABLE product_detail(
#     id BIGINT PRIMARY KEY AUTO_INCREMENT,
#     product_id BIGINT,
#     brand_id BIGINT,
#     category_id BIGINT,
#     color_id BIGINT,
#     size_id BIGINT,
#     sole_id BIGINT,
#     material_id BIGINT,
#     created_at DATETIME,
#     updated_at DATETIME
# );
# #update
# create table orders(
#     id BIGINT AUTO_INCREMENT primary key ,
#     madonhang nvarchar(50),
#     ngaytao DATETIME default NOW(),
#     ngaycapnhat datetime,
#     ngaygiaohang datetime,
#     ngaynhan datetime,
#     tennguoinhan nvarchar(50),
#     diachi nvarchar(50),
#     phone nvarchar(50),
#     tennguoigiao nvarchar(50),
#     sdtnguoigiao nvarchar(50),
#     giatrigiam nvarchar(50),
#     tiengiaohang float,
#     tienship float,
#     tienmat float,
#     tienck float,
#     tienthua float check ( tienthua>=0 ),
#     thanhtien float,
#     paymentid bigint,
#     discountid bigint,
#     trangthai int
# );
# create table order_detail(
#     id bigint auto_increment primary key,
#     productdetailid bigint,
#     soluong float,
#     trangthai int,
#     orderid bigint
# )
#
#
#
#
# create table cart(
#     id bigint auto_increment primary key,
#     ngaytao datetime default now(),
#     ngaycapnhat datetime,
#     ghichu nvarchar(255),
#     cartdetailid bigint,
#     userid bigint
# );
#
# create table cartdetail(
#     id bigint primary key auto_increment,
#     soluong int,
#     dongia float,
#     productdetailid bigint,
#     orderid bigint,
#     trangthai int
# )
