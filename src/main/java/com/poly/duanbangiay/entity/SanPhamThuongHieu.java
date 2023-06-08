package com.poly.duanbangiay.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "san_pham_thuong_hieu", schema = "dbo", catalog = "ShopShoe")
public class SanPhamThuongHieu {
    private long id;
    private Long sanPhamId;
    private Long thuongHieuId;

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
    @Column(name = "san_pham_id", nullable = true)
    public Long getSanPhamId() {
        return sanPhamId;
    }

    public void setSanPhamId(Long sanPhamId) {
        this.sanPhamId = sanPhamId;
    }

    @Basic
    @Column(name = "thuong_hieu_id", nullable = true)
    public Long getThuongHieuId() {
        return thuongHieuId;
    }

    public void setThuongHieuId(Long thuongHieuId) {
        this.thuongHieuId = thuongHieuId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SanPhamThuongHieu that = (SanPhamThuongHieu) o;
        return id == that.id && Objects.equals(sanPhamId, that.sanPhamId) && Objects.equals(thuongHieuId, that.thuongHieuId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sanPhamId, thuongHieuId);
    }
}
