package com.poly.duanbangiay.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "san_pham")
public class SanPham {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "ngay_tao")
    private Date ngayTao;
    @Column(name = "gia_nhap")
    private double giaNhap;
    @Column(name = "ten")
    private String ten;
    @Column(name = "gia_ban")
    private double giaBan;
    @Column(name = "so_luong")
    private int soLuong;
    @Column(name = "trang_thai")
    private int trangThai;
    @Column(name = "ngay_cap_nhat")
    private Date ngayCapNhat;
    @Column(name = "mo_ta")
    private String moTa;
}
