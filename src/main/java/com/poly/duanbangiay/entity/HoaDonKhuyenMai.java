package com.poly.duanbangiay.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "hoa_don_khuyen_mai", schema = "dbo", catalog = "ShopShoe")
public class HoaDonKhuyenMai {
    private long id;
    private Long hoaDonId;
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
    @Column(name = "hoa_don_id", nullable = true)
    public Long getHoaDonId() {
        return hoaDonId;
    }

    public void setHoaDonId(Long hoaDonId) {
        this.hoaDonId = hoaDonId;
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
        HoaDonKhuyenMai that = (HoaDonKhuyenMai) o;
        return id == that.id && Objects.equals(hoaDonId, that.hoaDonId) && Objects.equals(khuyenMaiId, that.khuyenMaiId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hoaDonId, khuyenMaiId);
    }
}
