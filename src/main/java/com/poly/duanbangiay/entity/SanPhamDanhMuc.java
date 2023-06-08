package com.poly.duanbangiay.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "san_pham_danh_muc", schema = "dbo", catalog = "ShopShoe")
public class SanPhamDanhMuc {
    private long id;
    private Long sanPhamId;
    private Long danhMucId;

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
    @Column(name = "danh_muc_id", nullable = true)
    public Long getDanhMucId() {
        return danhMucId;
    }

    public void setDanhMucId(Long danhMucId) {
        this.danhMucId = danhMucId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SanPhamDanhMuc that = (SanPhamDanhMuc) o;
        return id == that.id && Objects.equals(sanPhamId, that.sanPhamId) && Objects.equals(danhMucId, that.danhMucId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sanPhamId, danhMucId);
    }
}
