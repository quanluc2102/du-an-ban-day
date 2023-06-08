--create database ShopShoe
--drop database ShopShoe
CREATE TABLE tai_khoan (
  id BIGINT PRIMARY KEY IDENTITY(1,1),
  username NVARCHAR(255) NOT NULL,
  email NVARCHAR(255) NOT NULL,
  ten NVARCHAR(255) NOT NULL,
  dia_chi NVARCHAR(255) NOT NULL,
  ngay_sinh DATETIME,
  password NVARCHAR(255) NOT NULL,
  anh NVARCHAR(255),
  sdt NVARCHAR(255) NOT NULL,
  trang_thai BIT NOT NULL
);
-- Create vai_tro table
CREATE TABLE vai_tro (
  id BIGINT PRIMARY KEY IDENTITY(1,1),
  ten NVARCHAR(255) NOT NULL
);
-- Create phan_quyen table
CREATE TABLE phan_quyen (
  id BIGINT PRIMARY KEY IDENTITY(1,1),
  tai_khoan_id BIGINT,
  role_id BIGINT,
  FOREIGN KEY (tai_khoan_id) REFERENCES tai_khoan(id),
  FOREIGN KEY (role_id) REFERENCES vai_tro(id)
);



-- Create kich_thuoc table
CREATE TABLE kich_thuoc (
  id BIGINT PRIMARY KEY IDENTITY(1,1),
  gia_tri INT NOT NULL
);

-- Create danh_muc table
CREATE TABLE danh_muc (
  id BIGINT PRIMARY KEY IDENTITY(1,1),
  ten NVARCHAR(255) NOT NULL
);

-- Create kich_thuocmau_sacchi_tiet table


-- Create mau_sac table
CREATE TABLE mau_sac (
  id BIGINT PRIMARY KEY IDENTITY(1,1),
  gia_tri INT NOT NULL,
  ten NVARCHAR(255) NOT NULL
);


-- Create thanh_toan table
CREATE TABLE thanh_toan (
  id BIGINT PRIMARY KEY IDENTITY(1,1),
  ten NVARCHAR(255) NOT NULL,
  trang_thai NVARCHAR(255) NOT NULL
);

-- Create thuong_hieu table
CREATE TABLE thuong_hieu (
  id BIGINT PRIMARY KEY IDENTITY(1,1),
  ten NVARCHAR(255) NOT NULL
);

-- Create thong_tin_nguoi_dung table
CREATE TABLE thong_tin_nguoi_dung (
  id BIGINT PRIMARY KEY IDENTITY(1,1),
  dia_chi NVARCHAR(255) NOT NULL,
  sdt NVARCHAR(255) NOT NULL,
  ten NVARCHAR(255) NOT NULL,
  tai_khoan_id BIGINT,
  FOREIGN KEY (tai_khoan_id) REFERENCES tai_khoan(id)
);

-- Create san_pham table
CREATE TABLE san_pham (
  id BIGINT PRIMARY KEY IDENTITY(1,1),
  ngay_tao DATE NOT NULL,
  gia_nhap float NOT NULL,
  ten NVARCHAR(255) NOT NULL,
  gia_ban float NOT NULL,
  so_luong INT NOT NULL,
  trang_thai INT NOT NULL,	
  ngay_cap_nhat DATE,

  anh NVARCHAR(255),

 
);

CREATE TABLE kich_thuoc_mau_sac (
  id BIGINT PRIMARY KEY IDENTITY(1,1),
  so_luong INT NOT NULL,
  trang_thai INT NOT NULL,
  mau_sac_id BIGINT,
  san_pham_id BIGINT,
  kich_thuoc_id BIGINT,
  FOREIGN KEY (mau_sac_id) REFERENCES mau_sac(id),
  FOREIGN KEY (san_pham_id) REFERENCES san_pham(id),
  FOREIGN KEY (kich_thuoc_id) REFERENCES kich_thuoc(id)
);
--hoa don
CREATE TABLE hoa_don (
  id BIGINT PRIMARY KEY IDENTITY(1,1),
  ngay_tao DATE NOT NULL,
  ghi_chu NVARCHAR(255) NOT NULL,

  trang_thai INT NOT NULL,
  tai_khoan_id BIGINT,
  thanh_toan_id BIGINT,
  FOREIGN KEY (tai_khoan_id) REFERENCES tai_khoan(id),

  FOREIGN KEY (thanh_toan_id) REFERENCES thanh_toan(id)
);

CREATE TABLE gio_hang (
  id BIGINT PRIMARY KEY IDENTITY(1,1),
  ngay_tao DATE NOT NULL,
  ghi_chu NVARCHAR(255) NOT NULL,

  trang_thai INT NOT NULL,
  tai_khoan_id BIGINT,

  FOREIGN KEY (tai_khoan_id) REFERENCES tai_khoan(id),

);
-- Create hoa_donchi_tiet table
CREATE TABLE hoa_don_chi_tiet (
  id BIGINT PRIMARY KEY IDENTITY(1,1),
  ghi_chu NVARCHAR(255),

  so_luong INT NOT NULL,
  hoa_don_id BIGINT,
  san_pham_id BIGINT,

  FOREIGN KEY (hoa_don_id) REFERENCES hoa_don(id),
  FOREIGN KEY (san_pham_id) REFERENCES san_pham(id),
 
)

-- Create san_pham_danh_muc table
CREATE TABLE san_pham_danh_muc (
  id BIGINT PRIMARY KEY IDENTITY(1,1),
  san_pham_id BIGINT,
  danh_muc_id BIGINT,
  FOREIGN KEY (san_pham_id) REFERENCES san_pham(id),
  FOREIGN KEY (danh_muc_id) REFERENCES danh_muc(id)
);

-- Create san_pham_thuong_hieu table

CREATE TABLE san_pham_thuong_hieu (
  id BIGINT PRIMARY KEY IDENTITY(1,1),
  san_pham_id BIGINT,
  thuong_hieu_id BIGINT,
  FOREIGN KEY (san_pham_id) REFERENCES san_pham(id),
  FOREIGN KEY (thuong_hieu_id) REFERENCES thuong_hieu(id)
);

-- Create san_pham_anh table
CREATE TABLE san_pham_anh (
  id BIGINT PRIMARY KEY IDENTITY(1,1),
  san_pham_id BIGINT,
  anh NVARCHAR(255),
  FOREIGN KEY (san_pham_id) REFERENCES san_pham(id)
);
-- Create gio_hang table
CREATE TABLE gio_hang_chi_tiet (
id BIGINT PRIMARY KEY IDENTITY(1,1),
gio_hang_id BIGINT,
san_pham_id BIGINT,
so_luong INT NOT NULL,

 FOREIGN KEY (gio_hang_id) REFERENCES gio_hang(id),
FOREIGN KEY (san_pham_id) REFERENCES san_pham(id)
);
CREATE TABLE khuyen_mai (
  id BIGINT PRIMARY KEY IDENTITY(1,1),
  ten VARCHAR(255) NOT NULL,
  mo_ta VARCHAR(255),
  bat_dau DATE NOT NULL,
  ket_thuc DATE NOT NULL,
  giam_gia FLOAT NOT NULL,
 
);

-- Create doc_nhat table
CREATE TABLE doc_nhat (
id BIGINT PRIMARY KEY IDENTITY(1,1),
san_pham_id BIGINT,
thuoc_tinh_doc_nhat NVARCHAR(255),
FOREIGN KEY (san_pham_id) REFERENCES san_pham(id)
);

-- Create san_pham_khuyen_mai table
CREATE TABLE san_pham_khuyen_mai (
id BIGINT PRIMARY KEY IDENTITY(1,1),
san_pham_id BIGINT,
khuyen_mai_id BIGINT,
FOREIGN KEY (san_pham_id) REFERENCES san_pham(id),
FOREIGN KEY (khuyen_mai_id) REFERENCES khuyen_mai(id)
);

-- Create hoa_don_khuyen_mai table
CREATE TABLE hoa_don_khuyen_mai (
id BIGINT PRIMARY KEY IDENTITY(1,1),
hoa_don_id BIGINT,
khuyen_mai_id BIGINT,
FOREIGN KEY (hoa_don_id) REFERENCES hoa_don,
FOREIGN KEY (khuyen_mai_id) REFERENCES khuyen_mai(id)
);

-- INSERT INTO tai_khoan
INSERT INTO tai_khoan (username, email, ten, dia_chi, ngay_sinh, password, anh, sdt, trang_thai)
VALUES
('user1', 'user1@example.com', 'User 1', 'Address 1', '1990-01-01', 'password1', 'image1.jpg', '1234567890', 1),
('user2', 'user2@example.com', 'User 2', 'Address 2', '1990-02-02', 'password2', 'image2.jpg', '1234567891', 1),
('user3', 'user3@example.com', 'User 3', 'Address 3', '1990-03-03', 'password3', 'image3.jpg', '1234567892', 1),
('user4', 'user4@example.com', 'User 4', 'Address 4', '1990-04-04', 'password4', 'image4.jpg', '1234567893', 1),
('user5', 'user5@example.com', 'User 5', 'Address 5', '1990-05-05', 'password5', 'image5.jpg', '1234567894', 1),
('user6', 'user6@example.com', 'User 6', 'Address 6', '1990-06-06', 'password6', 'image6.jpg', '1234567895', 1),
('user7', 'user7@example.com', 'User 7', 'Address 7', '1990-07-07', 'password7', 'image7.jpg', '1234567896', 1),
('user8', 'user8@example.com', 'User 8', 'Address 8', '1990-08-08', 'password8', 'image8.jpg', '1234567897', 1),
('user9', 'user9@example.com', 'User 9', 'Address 9', '1990-09-09', 'password9', 'image9.jpg', '1234567898', 1),
('user10', 'user10@example.com', 'User 10', 'Address 10', '1990-10-10', 'password10', 'image10.jpg', '1234567899', 1);

-- INSERT INTO vai_tro
INSERT INTO vai_tro (ten)
VALUES
('Role 1'),
('Role 2'),
('Role 3'),
('Role 4'),
('Role 5'),
('Role 6'),
('Role 7'),
('Role 8'),
('Role 9'),
('Role 10');

-- INSERT INTO phan_quyen
INSERT INTO phan_quyen (tai_khoan_id, role_id)
VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);

-- INSERT INTO kich_thuoc
INSERT INTO kich_thuoc (gia_tri)
VALUES
(1),
(2),
(3),
(4),
(5),
(6),
(7),
(8),
(9),
(10);

-- INSERT INTO danh_muc
INSERT INTO danh_muc (ten)
VALUES
('Category 1'),
('Category 2'),
('Category 3'),
('Category 4'),
('Category 5'),
('Category 6'),
('Category 7'),
('Category 8'),
('Category 9'),
('Category 10');

-- INSERT INTO mau_sac
INSERT INTO mau_sac (gia_tri, ten)
VALUES
(1, 'Color 1'),
(2, 'Color 2'),
(3, 'Color 3'),
(4, 'Color 4'),
(5, 'Color 5'),
(6, 'Color 6'),
(7, 'Color 7'),
(8, 'Color 8'),
(9, 'Color 9'),
(10, 'Color 10');

-- INSERT INTO thanh_toan
INSERT INTO thanh_toan (ten, trang_thai)
VALUES
('Payment 1', 'Active'),
('Payment 2', 'Active'),
('Payment 3', 'Active'),
('Payment 4', 'Active'),
('Payment 5', 'Active'),
('Payment 6', 'Active'),
('Payment 7', 'Active'),
('Payment 8', 'Active'),
('Payment 9', 'Active'),
('Payment 10', 'Active');

-- INSERT INTO thuong_hieu
INSERT INTO thuong_hieu (ten)
VALUES
('Brand 1'),
('Brand 2'),
('Brand 3'),
('Brand 4'),
('Brand 5'),
('Brand 6'),
('Brand 7'),
('Brand 8'),
('Brand 9'),
('Brand 10');

-- INSERT INTO thong_tin_nguoi_dung
INSERT INTO thong_tin_nguoi_dung (dia_chi, sdt, ten, tai_khoan_id)
VALUES
('Address 1', '1234567890', 'User 1 Info', 1),
('Address 2', '1234567891', 'User 2 Info', 2),
('Address 3', '1234567892', 'User 3 Info', 3),
('Address 4', '1234567893', 'User 4 Info', 4),
('Address 5', '1234567894', 'User 5 Info', 5),
('Address 6', '1234567895', 'User 6 Info', 6),
('Address 7', '1234567896', 'User 7 Info', 7),
('Address 8', '1234567897', 'User 8 Info', 8),
('Address 9', '1234567898', 'User 9 Info', 9),
('Address 10', '1234567899', 'User 10 Info', 10);

-- INSERT INTO san_pham
INSERT INTO san_pham (ngay_tao, gia_nhap, ten, gia_ban, so_luong, trang_thai, ngay_cap_nhat, anh)
VALUES
('2021-01-01', 10.0, 'Product 1', 20.0, 50, 1, '2021-01-01', 'product1.jpg'),
('2021-02-02', 15.0, 'Product 2', 25.0, 60, 1, '2021-02-02', 'product2.jpg'),
('2021-03-03', 20.0, 'Product 3', 30.0, 70, 1, '2021-03-03', 'product3.jpg'),
('2021-04-04', 25.0, 'Product 4', 35.0, 80, 1, '2021-04-04', 'product4.jpg'),
('2021-05-05', 30.0, 'Product 5', 40.0, 90, 1, '2021-05-05', 'product5.jpg'),
('2021-06-06', 35.0, 'Product 6', 45.0, 100, 1, '2021-06-06', 'product6.jpg'),
('2021-07-07', 40.0, 'Product 7', 50.0, 110, 1, '2021-07-07', 'product7.jpg'),
('2021-08-08', 45.0, 'Product 8', 55.0, 120, 1, '2021-08-08', 'product8.jpg'),
('2021-09-09', 50.0, 'Product 9', 60.0, 130, 1, '2021-09-09', 'product9.jpg'),
('2021-10-10', 55.0, 'Product 10', 65.0, 140, 1, '2021-10-10', 'product10.jpg');

-- INSERT INTO kich_thuoc_mau_sac
INSERT INTO kich_thuoc_mau_sac (so_luong, trang_thai, mau_sac_id, san_pham_id, kich_thuoc_id)
VALUES
(10, 1, 1, 1, 1),
(20, 1, 2, 2, 2),
(30, 1, 3, 3, 3),
(40, 1, 4, 4, 4),
(50, 1, 5, 5, 5),
(60, 1, 6, 6, 6),
(70, 1, 7, 7, 7),
(80, 1, 8, 8, 8),
(90, 1, 9, 9, 9),
(100, 1, 10, 10, 10);

-- INSERT INTO hoa_don
INSERT INTO hoa_don (ngay_tao, ghi_chu, trang_thai, tai_khoan_id, thanh_toan_id)
VALUES
('2021-01-01', 'Note 1', 1, 1, 1),
('2021-02-02', 'Note 2', 1, 2, 2),
('2021-03-03', 'Note 3', 1, 3, 3),
('2021-04-04', 'Note 4', 1, 4, 4),
('2021-05-05', 'Note 5', 1, 5, 5),
('2021-06-06', 'Note 6', 1, 6, 6),
('2021-07-07', 'Note 7', 1, 7, 7),
('2021-08-08', 'Note 8', 1, 8, 8),
('2021-09-09', 'Note 9', 1, 9, 9),
('2021-10-10', 'Note 10', 1, 10, 10);

-- INSERT INTO gio_hang
INSERT INTO gio_hang (ngay_tao, ghi_chu, trang_thai, tai_khoan_id)
VALUES
('2021-01-01', 'Note 1',
1, 1),
('2021-02-02', 'Note 2', 1, 2),
('2021-03-03', 'Note 3', 1, 3),
('2021-04-04', 'Note 4', 1, 4),
('2021-05-05', 'Note 5', 1, 5),
('2021-06-06', 'Note 6', 1, 6),
('2021-07-07', 'Note 7', 1, 7),
('2021-08-08', 'Note 8', 1, 8),
('2021-09-09', 'Note 9', 1, 9),
('2021-10-10', 'Note 10', 1, 10);

-- INSERT INTO hoa_don_chi_tiet
INSERT INTO hoa_don_chi_tiet (ghi_chu, so_luong, hoa_don_id, san_pham_id)
VALUES
('Note 1', 5, 1, 1),
('Note 2', 10, 2, 2),
('Note 3', 15, 3, 3),
('Note 4', 20, 4, 4),
('Note 5', 25, 5, 5),
('Note 6', 30, 6, 6),
('Note 7', 35, 7, 7),
('Note 8', 40, 8, 8),
('Note 9', 45, 9, 9),
('Note 10', 50, 10, 10);

-- INSERT INTO san_pham_danh_muc
INSERT INTO san_pham_danh_muc (san_pham_id, danh_muc_id)
VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);

-- INSERT INTO san_pham_thuong_hieu
INSERT INTO san_pham_thuong_hieu (san_pham_id, thuong_hieu_id)
VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);

-- INSERT INTO san_pham_anh
INSERT INTO san_pham_anh (san_pham_id, anh)
VALUES
(1, 'product1_1.jpg'),
(2, 'product2_1.jpg'),
(3, 'product3_1.jpg'),
(4, 'product4_1.jpg'),
(5, 'product5_1.jpg'),
(6, 'product6_1.jpg'),
(7, 'product7_1.jpg'),
(8, 'product8_1.jpg'),
(9, 'product9_1.jpg'),
(10, 'product10_1.jpg');

-- INSERT INTO gio_hang_chi_tiet
INSERT INTO gio_hang_chi_tiet (gio_hang_id, san_pham_id, so_luong)
VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 3),
(4, 4, 4),
(5, 5, 5),
(6, 6, 6),
(7, 7, 7),
(8, 8, 8),
(9, 9, 9),
(10, 10, 10);

-- INSERT INTO khuyen_mai
INSERT INTO khuyen_mai (ten, mo_ta, bat_dau, ket_thuc, giam_gia)
VALUES
('Promotion 1', 'Description 1', '2022-01-01', '2022-01-15', 0.1),
('Promotion 2', 'Description 2', '2022-02-01', '2022-02-15', 0.2),
('Promotion 3', 'Description 3', '2022-03-01', '2022-03-15', 0.3),
('Promotion 4', 'Description 4', '2022-04-01', '2022-04-15', 0.4),
('Promotion 5', 'Description 5', '2022-05-01', '2022-05-15', 0.5),
('Promotion 6', 'Description 6', '2022-06-01', '2022-06-15', 0.6),
('Promotion 7', 'Description 7', '2022-07-01', '2022-07-15', 0.7),
('Promotion 8', 'Description 8', '2022-08-01', '2022-08-15', 0.8),
('Promotion 9', 'Description 9', '2022-09-01', '2022-09-15', 0.9),
('Promotion 10', 'Description 10', '2022-10-01', '2022-10-15', 1.0);

-- INSERT INTO doc_nhat
INSERT INTO doc_nhat (san_pham_id, thuoc_tinh_doc_nhat)
VALUES
(1, 'Unique Property 1'),
(2, 'Unique Property 2'),
(3, 'Unique Property 3'),
(4, 'Unique Property 4'),
(5, 'Unique Property 5'),
(6, 'Unique Property 6'),
(7, 'Unique Property 7'),
(8, 'Unique Property 8'),
(9, 'Unique Property 9'),
(10, 'Unique Property 10');

-- INSERT INTO san_pham_khuyen_mai
INSERT INTO san_pham_khuyen_mai (san_pham_id, khuyen_mai_id)
VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);

-- INSERT INTO hoa_don_khuyen_mai
INSERT INTO hoa_don_khuyen_mai (hoa_don_id, khuyen_mai_id)
VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);