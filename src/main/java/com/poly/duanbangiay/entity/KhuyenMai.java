package com.poly.duanbangiay.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "khuyen_mai", schema = "dbo", catalog = "ShopShoe")
public class KhuyenMai {
    private long id;
    private String ten;
    private String moTa;
    private Date batDau;
    private Date ketThuc;
    private double giamGia;

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
    @Column(name = "ten", nullable = false, length = 255)
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @Basic
    @Column(name = "mo_ta", nullable = true, length = 255)
    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Basic
    @Column(name = "bat_dau", nullable = false)
    public Date getBatDau() {
        return batDau;
    }

    public void setBatDau(Date batDau) {
        this.batDau = batDau;
    }

    @Basic
    @Column(name = "ket_thuc", nullable = false)
    public Date getKetThuc() {
        return ketThuc;
    }

    public void setKetThuc(Date ketThuc) {
        this.ketThuc = ketThuc;
    }

    @Basic
    @Column(name = "giam_gia", nullable = false, precision = 0)
    public double getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(double giamGia) {
        this.giamGia = giamGia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KhuyenMai khuyenMai = (KhuyenMai) o;
        return id == khuyenMai.id && Double.compare(khuyenMai.giamGia, giamGia) == 0 && Objects.equals(ten, khuyenMai.ten) && Objects.equals(moTa, khuyenMai.moTa) && Objects.equals(batDau, khuyenMai.batDau) && Objects.equals(ketThuc, khuyenMai.ketThuc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ten, moTa, batDau, ketThuc, giamGia);
    }
}
