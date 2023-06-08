package com.poly.duanbangiay.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "san_pham_anh", schema = "dbo", catalog = "ShopShoe")
public class SanPhamAnh {
    private long id;
    private Long sanPhamId;
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
    @Column(name = "san_pham_id", nullable = true)
    public Long getSanPhamId() {
        return sanPhamId;
    }

    public void setSanPhamId(Long sanPhamId) {
        this.sanPhamId = sanPhamId;
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
        SanPhamAnh that = (SanPhamAnh) o;
        return id == that.id && Objects.equals(sanPhamId, that.sanPhamId) && Objects.equals(anh, that.anh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sanPhamId, anh);
    }
}
