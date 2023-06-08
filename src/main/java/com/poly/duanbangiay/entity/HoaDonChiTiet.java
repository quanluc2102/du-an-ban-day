package com.poly.duanbangiay.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "hoa_don_chi_tiet", schema = "dbo", catalog = "ShopShoe")
public class HoaDonChiTiet {
    private long id;
    private String ghiChu;
    private int soLuong;
    private Long hoaDonId;
    private Long sanPhamId;

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
    @Column(name = "ghi_chu", nullable = true, length = 255)
    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
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
    @Column(name = "hoa_don_id", nullable = true)
    public Long getHoaDonId() {
        return hoaDonId;
    }

    public void setHoaDonId(Long hoaDonId) {
        this.hoaDonId = hoaDonId;
    }

    @Basic
    @Column(name = "san_pham_id", nullable = true)
    public Long getSanPhamId() {
        return sanPhamId;
    }

    public void setSanPhamId(Long sanPhamId) {
        this.sanPhamId = sanPhamId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HoaDonChiTiet that = (HoaDonChiTiet) o;
        return id == that.id && soLuong == that.soLuong && Objects.equals(ghiChu, that.ghiChu) && Objects.equals(hoaDonId, that.hoaDonId) && Objects.equals(sanPhamId, that.sanPhamId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ghiChu, soLuong, hoaDonId, sanPhamId);
    }
}
