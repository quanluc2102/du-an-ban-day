package com.poly.duanbangiay.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "san_pham", schema = "dbo", catalog = "ShopShoe")
public class SanPham {
    private long id;
    private Date ngayTao;
    private double giaNhap;
    private String ten;
    private double giaBan;
    private int soLuong;
    private int trangThai;
    private Date ngayCapNhat;
    private String anh;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ngay_tao", nullable = false)
    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    @Basic
    @Column(name = "gia_nhap", nullable = false, precision = 0)
    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    @Basic
    @Column(name = "ten", nullable = false, length = 255)
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @Basic
    @Column(name = "gia_ban", nullable = false, precision = 0)
    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    @Basic
    @Column(name = "so_luong", nullable = false)
    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Basic
    @Column(name = "trang_thai", nullable = false)
    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Basic
    @Column(name = "ngay_cap_nhat", nullable = true)
    public Date getNgayCapNhat() {
        return ngayCapNhat;
    }

    public void setNgayCapNhat(Date ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
    }

    @Basic
    @Column(name = "anh", nullable = true, length = 255)
    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SanPham sanPham = (SanPham) o;
        return id == sanPham.id && Double.compare(sanPham.giaNhap, giaNhap) == 0 && Double.compare(sanPham.giaBan, giaBan) == 0 && soLuong == sanPham.soLuong && trangThai == sanPham.trangThai && Objects.equals(ngayTao, sanPham.ngayTao) && Objects.equals(ten, sanPham.ten) && Objects.equals(ngayCapNhat, sanPham.ngayCapNhat) && Objects.equals(anh, sanPham.anh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ngayTao, giaNhap, ten, giaBan, soLuong, trangThai, ngayCapNhat, anh);
    }
}
