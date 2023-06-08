package com.poly.duanbangiay.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "kich_thuoc_mau_sac", schema = "dbo", catalog = "ShopShoe")
public class KichThuocMauSac {
    private long id;
    private int soLuong;
    private int trangThai;
    private Long mauSacId;
    private Long sanPhamId;
    private Long kichThuocId;

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
    @Column(name = "mau_sac_id", nullable = true)
    public Long getMauSacId() {
        return mauSacId;
    }

    public void setMauSacId(Long mauSacId) {
        this.mauSacId = mauSacId;
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
    @Column(name = "kich_thuoc_id", nullable = true)
    public Long getKichThuocId() {
        return kichThuocId;
    }

    public void setKichThuocId(Long kichThuocId) {
        this.kichThuocId = kichThuocId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KichThuocMauSac that = (KichThuocMauSac) o;
        return id == that.id && soLuong == that.soLuong && trangThai == that.trangThai && Objects.equals(mauSacId, that.mauSacId) && Objects.equals(sanPhamId, that.sanPhamId) && Objects.equals(kichThuocId, that.kichThuocId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, soLuong, trangThai, mauSacId, sanPhamId, kichThuocId);
    }
}
