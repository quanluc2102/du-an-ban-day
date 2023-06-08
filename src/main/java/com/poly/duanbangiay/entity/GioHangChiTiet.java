package com.poly.duanbangiay.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "gio_hang_chi_tiet", schema = "dbo", catalog = "ShopShoe")
public class GioHangChiTiet {
    private long id;
    private Long gioHangId;
    private Long sanPhamId;
    private int soLuong;

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
    @Column(name = "gio_hang_id", nullable = true)
    public Long getGioHangId() {
        return gioHangId;
    }

    public void setGioHangId(Long gioHangId) {
        this.gioHangId = gioHangId;
    }

    @Basic
    @Column(name = "san_pham_id", nullable = true)
    public Long getSanPhamId() {
        return sanPhamId;
    }

    public void setSanPhamId(Long sanPhamId) {
        this.sanPhamId = sanPhamId;
    }

    @Basic
    @Column(name = "so_luong", nullable = false)
    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GioHangChiTiet that = (GioHangChiTiet) o;
        return id == that.id && soLuong == that.soLuong && Objects.equals(gioHangId, that.gioHangId) && Objects.equals(sanPhamId, that.sanPhamId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gioHangId, sanPhamId, soLuong);
    }
}
