-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 21, 2020 lúc 04:22 PM
-- Phiên bản máy phục vụ: 10.4.13-MariaDB
-- Phiên bản PHP: 7.4.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `doanjava`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitiet_ctgiamgia`
--

CREATE TABLE `chitiet_ctgiamgia` (
  `ID_GIAMGIA` int(10) NOT NULL,
  `ID_SP` int(10) NOT NULL,
  `NOIDUNG_GG` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `chitiet_ctgiamgia`
--

INSERT INTO `chitiet_ctgiamgia` (`ID_GIAMGIA`, `ID_SP`, `NOIDUNG_GG`) VALUES
(2, 2, 0.4),
(4, 3, 0.6),
(4, 5, 0.6),
(6, 2, 0.5);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitiet_hoadon`
--

CREATE TABLE `chitiet_hoadon` (
  `ID_HD` int(10) NOT NULL,
  `ID_SP` int(10) NOT NULL,
  `SL_CTHD` int(11) NOT NULL,
  `DONGIA` double NOT NULL,
  `THANHTIEN_CTHD` double NOT NULL,
  `TIENGG` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `chitiet_hoadon`
--

INSERT INTO `chitiet_hoadon` (`ID_HD`, `ID_SP`, `SL_CTHD`, `DONGIA`, `THANHTIEN_CTHD`, `TIENGG`) VALUES
(1, 2, 3, 23000, 69000, 0),
(1, 5, 3, 48000, 144000, 0),
(1, 10, 3, 23000, 69000, 0),
(3, 1, 10, 16000, 160000, 0),
(4, 2, 10, 23000, 230000, 0),
(4, 3, 10, 9000, 90000, 0),
(5, 5, 7, 48000, 336000, 0),
(6, 9, 10, 3500, 35000, 0),
(7, 3, 4, 9000, 36000, 0),
(7, 9, 5, 3500, 17500, 0),
(8, 1, 4, 16000, 64000, 0),
(8, 5, 4, 48000, 192000, 0),
(9, 1, 5, 16000, 80000, 0),
(9, 3, 5, 9000, 45000, 0),
(9, 9, 5, 3500, 17500, 0),
(9, 10, 5, 23000, 115000, 0),
(11, 1, 10, 16000, 160000, -1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitiet_phieunhap`
--

CREATE TABLE `chitiet_phieunhap` (
  `ID_PN` int(10) NOT NULL,
  `ID_SP` int(10) NOT NULL,
  `SL_CTPN` int(11) NOT NULL,
  `GIANHAP` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `chitiet_phieunhap`
--

INSERT INTO `chitiet_phieunhap` (`ID_PN`, `ID_SP`, `SL_CTPN`, `GIANHAP`) VALUES
(1, 1, 10, 16000),
(2, 1, 10, 13000),
(2, 5, 10, 47000),
(2, 8, 20, 6000),
(3, 5, 5, 48000),
(7, 1, 30, 14400),
(10, 10, 10, 20700),
(14, 2, 10, 20700),
(15, 1, 20, 14400);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chuongtrinh_giamgia`
--

CREATE TABLE `chuongtrinh_giamgia` (
  `ID_GIAMGIA` int(10) NOT NULL,
  `TEN_CT` varchar(50) NOT NULL,
  `LOAI_CT` int(10) NOT NULL,
  `TG_BD` varchar(20) NOT NULL,
  `TG_KT` varchar(20) NOT NULL,
  `NOIDUNG_GG` double NOT NULL,
  `DIEUKIEN_GG` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `chuongtrinh_giamgia`
--

INSERT INTO `chuongtrinh_giamgia` (`ID_GIAMGIA`, `TEN_CT`, `LOAI_CT`, `TG_BD`, `TG_KT`, `NOIDUNG_GG`, `DIEUKIEN_GG`) VALUES
(1, 'Giảm 50000', 1, '03/05/2020', '20/05/2020', 50000, 150000),
(2, '', 2, '13/05/2020', '16/06/2020', 0, 0),
(3, 'Bình thường', 0, '', '', 0, 0),
(4, 'giam', 2, '18/06/2020', '18/06/2020', 0, 0),
(5, 'giam 10', 1, '18/06/2020', '18/06/2020', 10000, 1000000),
(6, 'asd', 2, '18/06/2020', '18/06/2020', 0, 0),
(7, 'awe', 2, '18/06/2020', '18/06/2020', 0, 0),
(8, 'asd', 2, '18/06/2020', '18/06/2020', 0, 0),
(9, 'asd', 2, '18/06/2020', '18/06/2020', 0, 0),
(10, 'asd', 2, '18/06/2020', '18/06/2020', 0, 0),
(11, 'ccds', 1, '09/06/2020', '18/06/2020', 0, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `ID_HD` int(10) NOT NULL,
  `ID_KH` int(10) NOT NULL,
  `ID_NV` int(10) NOT NULL,
  `ID_GIAMGIA` int(10) NOT NULL,
  `NGAYLAP_HD` varchar(20) NOT NULL,
  `TONGTIEN_HD` double NOT NULL,
  `TIENGIAMGIA` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `hoadon`
--

INSERT INTO `hoadon` (`ID_HD`, `ID_KH`, `ID_NV`, `ID_GIAMGIA`, `NGAYLAP_HD`, `TONGTIEN_HD`, `TIENGIAMGIA`) VALUES
(1, 2, 1, 3, '18/06/2020', 282000, 1),
(2, 6, 2, 3, '18/06/2020', 0, 1),
(3, 2, 1, 3, '18/06/2020', 160000, 1),
(4, 3, 5, 3, '18/06/2020', 320000, 1),
(5, 1, 1, 3, '18/06/2020', 336000, 1),
(6, 4, 3, 3, '18/06/2020', 35000, 1),
(7, 3, 2, 3, '18/06/2020', 53500, 1),
(8, 6, 1, 3, '18/06/2020', 256000, 1),
(9, 2, 5, 3, '18/06/2020', 257500, 1),
(10, 3, 1, 3, '18/06/2020', 0, 0),
(11, 1, 1, 3, '18/06/2020', 160000, 1),
(12, 1, 1, 3, '03/11/2020', 0, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `ID_KH` int(10) NOT NULL,
  `HO_KH` varchar(50) NOT NULL,
  `TEN_KH` varchar(50) NOT NULL,
  `SDT_KH` varchar(10) NOT NULL,
  `MAIL_KH` varchar(30) NOT NULL,
  `GIOITINH_KH` varchar(4) NOT NULL,
  `TONGCHITIEU` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `khachhang`
--

INSERT INTO `khachhang` (`ID_KH`, `HO_KH`, `TEN_KH`, `SDT_KH`, `MAIL_KH`, `GIOITINH_KH`, `TONGCHITIEU`) VALUES
(1, 'Nguyễn', 'Thị Yến', '123456789', 'yen@gmail.com', 'Nữ', 13000000),
(2, 'Lê', 'Thanh Bách', '123456789', 'bach@gmail.com', 'Nam', 1500000),
(3, 'Phan', 'Thanh An', '1234567899', 'an@gmail.com', 'Nam', 27000000),
(4, 'Trần', 'Hữu Chí', '123456789', 'chi@gmail.com', 'Nam', 7000000),
(6, 'Trịnh', 'Thị Lệ', '123456789', 'le@gmail.com', 'Nữ', 145000000),
(7, 'Bành ', 'Thị Nở', '0113113113', 'nono@gmail.com', 'Nữ', 1000000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `ID_NCC` int(10) NOT NULL,
  `TEN_NCC` varchar(50) NOT NULL,
  `SDT_NCC` varchar(10) NOT NULL,
  `MAIL_NCC` varchar(30) NOT NULL,
  `DIACHI_NCC` varchar(100) NOT NULL,
  `TINHTRANG` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `nhacungcap`
--

INSERT INTO `nhacungcap` (`ID_NCC`, `TEN_NCC`, `SDT_NCC`, `MAIL_NCC`, `DIACHI_NCC`, `TINHTRANG`) VALUES
(1, 'ABC Bakery', '123456789', 'ABC@gmail.com', '222 Nguyễn Trãi, phường 2, quận 5, thành phố Hồ Chí Minh', 1),
(2, 'Hảo Hảo Acecook', '123456789', 'haohao@gmai.com', 'KCN Tiên Sơn, xã Hoàn Sơn, huyện Tiên Du tỉnh Bắc Ninh', 1),
(3, 'Coca Cola', '123456789', 'coca@gmail.com', '485 xa lộ Hà Nội', 1),
(4, 'Kinh đô Mondelez', '123456789', 'kinhdo@gmail.com', 'số 26 đường số 8 KCN Singapore, An Phú, Thuận An, Bình Dương', 0),
(5, 'Pepsico', '123456789', 'pepsi@gmail.com', 'KCN Amata, Long Bình, Biên Hòa, Đồng Nai', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `ID_NV` int(10) NOT NULL,
  `HO_NV` varchar(50) NOT NULL,
  `TEN_NV` varchar(50) NOT NULL,
  `SDT_NV` varchar(10) NOT NULL,
  `MAIL_NV` varchar(50) NOT NULL,
  `GIOITINH_NV` varchar(4) NOT NULL,
  `CHUCVU_NV` varchar(30) NOT NULL,
  `PASS_NV` varchar(50) NOT NULL,
  `ID_PQ` int(11) NOT NULL,
  `TINHTRANG` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`ID_NV`, `HO_NV`, `TEN_NV`, `SDT_NV`, `MAIL_NV`, `GIOITINH_NV`, `CHUCVU_NV`, `PASS_NV`, `ID_PQ`, `TINHTRANG`) VALUES
(1, 'admin', 'admin', '0101010101', 'admin@gmail.com', 'Nam', 'Quản lý', '21232f297a57a5a743894a0e4a801fc3', 1, 1),
(2, 'Thái', 'Phi Sơn', '123456789', 'son@gmail.com', 'Nam', 'Thủ kho', '1885e46b0ec4e787fad11754c7319b50', 2, 1),
(3, 'Lê', 'Đặng Khánh Dung', '123456789', 'dung@gmail.com', 'Nữ', 'Nhân viên bán hàng', 'd30ef5569a0a3f315e0b91b0a129ae9f', 2, 1),
(4, 'Đoàn', 'Quốc Hùng', '0987654321', 'hung@gmail.com', 'Nam', 'Developer', '003f9db37dd8479520d16c6c141e888c', 2, 1),
(5, 'Cung', 'Xương Hồng Thiên', '123456789', 'thien@gmail.com', 'Nam', 'Quản lý', 'acfcc085ad799082d0aaf9c497ad6e3e', 2, 1),
(6, 'Nguyễn', 'Thanh Sang', '0123456789', 'sang@gmail.com', 'Nam', 'Teacher', 'bb1fd84f3c93eecf02e3153cccf98d98', 2, 1),
(7, 'Phùng', 'Thái Thiên Trang', '0928847375', 'trang@gmail.com', 'Nữ', 'Teacher ca lý thuyết', '1e184ab537f0d6d6d94bbb5790b1fee0', 2, 1),
(8, 'Trẻ', 'Con', '0123456789', 'tre@gmail.com', 'Nữ', 'phá', '7aad741bd57b7c9c5c445e161353c3ea', 2, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phanquyen`
--

CREATE TABLE `phanquyen` (
  `id_pq` int(11) NOT NULL,
  `ten_pq` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `phanquyen`
--

INSERT INTO `phanquyen` (`id_pq`, `ten_pq`) VALUES
(1, 'admin'),
(2, 'nhanvien');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieunhap`
--

CREATE TABLE `phieunhap` (
  `ID_PN` int(10) NOT NULL,
  `ID_NV` int(10) NOT NULL,
  `ID_NCC` int(10) NOT NULL,
  `NGAYNHAP_PN` varchar(30) NOT NULL,
  `TONGTIEN_PN` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `phieunhap`
--

INSERT INTO `phieunhap` (`ID_PN`, `ID_NV`, `ID_NCC`, `NGAYNHAP_PN`, `TONGTIEN_PN`) VALUES
(1, 5, 1, '23/05/2020', 160000),
(2, 2, 2, '01/06/2020', 720000),
(3, 4, 1, '15/06/2020', 240000),
(4, 3, 2, '15/06/2020', 0),
(5, 2, 3, '17/06/2020', 0),
(6, 1, 3, '17/06/2020', 0),
(7, 1, 3, '18/06/2020', 432000),
(8, 1, 1, '12/11/2020', 0),
(9, 1, 2, '12/11/2020', 0),
(10, 1, 1, '12/11/2020', 207000),
(11, 2, 2, '12/11/2020', 0),
(12, 2, 1, '12/11/2020', 0),
(13, 1, 1, '12/11/2020', 0),
(14, 1, 2, '14/12/2020', 207000),
(15, 1, 4, '14/12/2020', 288000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `ID_SP` int(10) NOT NULL,
  `TEN_SP` varchar(50) NOT NULL,
  `SL_SP` int(11) NOT NULL,
  `DONGIA_SP` double NOT NULL,
  `LOAI_SP` varchar(30) NOT NULL,
  `TINHTRANG` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`ID_SP`, `TEN_SP`, `SL_SP`, `DONGIA_SP`, `LOAI_SP`, `TINHTRANG`) VALUES
(1, 'Bánh cua mini ABC', 70, 16000, 'Bánh', 1),
(2, 'Bánh bao khoai môn', 10, 23000, 'Bánh', 1),
(3, 'Coca Cola', 0, 9000, 'Nước uống', 0),
(4, 'Pepsi', 71, 8000, 'Nước uống', 0),
(5, 'Xúc xích Đức', 0, 48000, 'Hàng đông lạnh', 1),
(6, 'Kẹo trái cây', 12, 4000, 'Kẹo', 0),
(8, 'Mì chay', 30, 6500, 'Thực phẩm đóng gói', 0),
(9, 'Mì gói Hảo Hảo', 15, 3500, 'Thực phẩm đóng gói', 0),
(10, 'Bánh quế', 0, 23000, 'Bánh', 1),
(11, 'Xúc xích', 14, 5000, 'Ăn nhanh', 1);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chitiet_ctgiamgia`
--
ALTER TABLE `chitiet_ctgiamgia`
  ADD PRIMARY KEY (`ID_GIAMGIA`,`ID_SP`),
  ADD KEY `ID_SP` (`ID_SP`);

--
-- Chỉ mục cho bảng `chitiet_hoadon`
--
ALTER TABLE `chitiet_hoadon`
  ADD PRIMARY KEY (`ID_HD`,`ID_SP`),
  ADD KEY `ID_SP` (`ID_SP`);

--
-- Chỉ mục cho bảng `chitiet_phieunhap`
--
ALTER TABLE `chitiet_phieunhap`
  ADD PRIMARY KEY (`ID_PN`,`ID_SP`),
  ADD KEY `ID_SP` (`ID_SP`);

--
-- Chỉ mục cho bảng `chuongtrinh_giamgia`
--
ALTER TABLE `chuongtrinh_giamgia`
  ADD PRIMARY KEY (`ID_GIAMGIA`);

--
-- Chỉ mục cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`ID_HD`),
  ADD KEY `ID_GIAMGIA` (`ID_GIAMGIA`),
  ADD KEY `ID_KH` (`ID_KH`),
  ADD KEY `ID_NV` (`ID_NV`);

--
-- Chỉ mục cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`ID_KH`);

--
-- Chỉ mục cho bảng `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`ID_NCC`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`ID_NV`);

--
-- Chỉ mục cho bảng `phanquyen`
--
ALTER TABLE `phanquyen`
  ADD PRIMARY KEY (`id_pq`);

--
-- Chỉ mục cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`ID_PN`),
  ADD KEY `ID_NCC` (`ID_NCC`),
  ADD KEY `ID_NV` (`ID_NV`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`ID_SP`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `chuongtrinh_giamgia`
--
ALTER TABLE `chuongtrinh_giamgia`
  MODIFY `ID_GIAMGIA` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `ID_HD` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `ID_KH` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT cho bảng `nhacungcap`
--
ALTER TABLE `nhacungcap`
  MODIFY `ID_NCC` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  MODIFY `ID_NV` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;

--
-- AUTO_INCREMENT cho bảng `phanquyen`
--
ALTER TABLE `phanquyen`
  MODIFY `id_pq` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  MODIFY `ID_PN` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `ID_SP` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `chitiet_ctgiamgia`
--
ALTER TABLE `chitiet_ctgiamgia`
  ADD CONSTRAINT `chitiet_ctgiamgia_ibfk_1` FOREIGN KEY (`ID_GIAMGIA`) REFERENCES `chuongtrinh_giamgia` (`ID_GIAMGIA`),
  ADD CONSTRAINT `chitiet_ctgiamgia_ibfk_2` FOREIGN KEY (`ID_SP`) REFERENCES `sanpham` (`ID_SP`);

--
-- Các ràng buộc cho bảng `chitiet_hoadon`
--
ALTER TABLE `chitiet_hoadon`
  ADD CONSTRAINT `chitiet_hoadon_ibfk_1` FOREIGN KEY (`ID_HD`) REFERENCES `hoadon` (`ID_HD`),
  ADD CONSTRAINT `chitiet_hoadon_ibfk_2` FOREIGN KEY (`ID_SP`) REFERENCES `sanpham` (`ID_SP`);

--
-- Các ràng buộc cho bảng `chitiet_phieunhap`
--
ALTER TABLE `chitiet_phieunhap`
  ADD CONSTRAINT `chitiet_phieunhap_ibfk_1` FOREIGN KEY (`ID_PN`) REFERENCES `phieunhap` (`ID_PN`),
  ADD CONSTRAINT `chitiet_phieunhap_ibfk_2` FOREIGN KEY (`ID_SP`) REFERENCES `sanpham` (`ID_SP`);

--
-- Các ràng buộc cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`ID_GIAMGIA`) REFERENCES `chuongtrinh_giamgia` (`ID_GIAMGIA`),
  ADD CONSTRAINT `hoadon_ibfk_2` FOREIGN KEY (`ID_KH`) REFERENCES `khachhang` (`ID_KH`),
  ADD CONSTRAINT `hoadon_ibfk_3` FOREIGN KEY (`ID_NV`) REFERENCES `nhanvien` (`ID_NV`);

--
-- Các ràng buộc cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD CONSTRAINT `phieunhap_ibfk_1` FOREIGN KEY (`ID_NCC`) REFERENCES `nhacungcap` (`ID_NCC`),
  ADD CONSTRAINT `phieunhap_ibfk_2` FOREIGN KEY (`ID_NV`) REFERENCES `nhanvien` (`ID_NV`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
