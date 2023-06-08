package com.poly.duanbangiay.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "san_pham_khuyen_mai", schema = "dbo", catalog = "ShopShoe")
public class SanPhamKhuyenMai {
    private long id;
    private Long sanPhamId;
    private Long khuyenMaiId;

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
    @Column(name = "khuyen_mai_id", nullable = true)
    public Long getKhuyenMaiId() {
        return khuyenMaiId;
    }

    public void setKhuyenMaiId(Long khuyenMaiId) {
        this.khuyenMaiId = khuyenMaiId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SanPhamKhuyenMai that = (SanPhamKhuyenMai) o;
        return id == that.id && Objects.equals(sanPhamId, that.sanPhamId) && Objects.equals(khuyenMaiId, that.khuyenMaiId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sanPhamId, khuyenMaiId);
    }
}
