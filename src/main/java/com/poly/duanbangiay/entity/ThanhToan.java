package com.poly.duanbangiay.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "thanh_toan", schema = "dbo", catalog = "ShopShoe")
public class ThanhToan {
    private long id;
    private String ten;
    private String trangThai;

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
    @Column(name = "trang_thai", nullable = false, length = 255)
    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ThanhToan thanhToan = (ThanhToan) o;
        return id == thanhToan.id && Objects.equals(ten, thanhToan.ten) && Objects.equals(trangThai, thanhToan.trangThai);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ten, trangThai);
    }
}
