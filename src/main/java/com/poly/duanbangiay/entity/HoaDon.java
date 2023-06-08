package com.poly.duanbangiay.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "hoa_don", schema = "dbo", catalog = "ShopShoe")
public class HoaDon {
    private long id;
    private Date ngayTao;
    private String ghiChu;
    private int trangThai;
    private Long taiKhoanId;
    private Long thanhToanId;

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
    @Column(name = "ngay_tao", nullable = false)
    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    @Basic
    @Column(name = "ghi_chu", nullable = false, length = 255)
    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
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
    @Column(name = "tai_khoan_id", nullable = true)
    public Long getTaiKhoanId() {
        return taiKhoanId;
    }

    public void setTaiKhoanId(Long taiKhoanId) {
        this.taiKhoanId = taiKhoanId;
    }

    @Basic
    @Column(name = "thanh_toan_id", nullable = true)
    public Long getThanhToanId() {
        return thanhToanId;
    }

    public void setThanhToanId(Long thanhToanId) {
        this.thanhToanId = thanhToanId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HoaDon hoaDon = (HoaDon) o;
        return id == hoaDon.id && trangThai == hoaDon.trangThai && Objects.equals(ngayTao, hoaDon.ngayTao) && Objects.equals(ghiChu, hoaDon.ghiChu) && Objects.equals(taiKhoanId, hoaDon.taiKhoanId) && Objects.equals(thanhToanId, hoaDon.thanhToanId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ngayTao, ghiChu, trangThai, taiKhoanId, thanhToanId);
    }
}
