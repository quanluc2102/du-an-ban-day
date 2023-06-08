package com.poly.duanbangiay.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "thong_tin_nguoi_dung", schema = "dbo", catalog = "ShopShoe")
public class ThongTinNguoiDung {
    private long id;
    private String diaChi;
    private String sdt;
    private String ten;
    private Long taiKhoanId;

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
    @Column(name = "dia_chi", nullable = false, length = 255)
    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Basic
    @Column(name = "sdt", nullable = false, length = 255)
    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
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
    @Column(name = "tai_khoan_id", nullable = true)
    public Long getTaiKhoanId() {
        return taiKhoanId;
    }

    public void setTaiKhoanId(Long taiKhoanId) {
        this.taiKhoanId = taiKhoanId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ThongTinNguoiDung that = (ThongTinNguoiDung) o;
        return id == that.id && Objects.equals(diaChi, that.diaChi) && Objects.equals(sdt, that.sdt) && Objects.equals(ten, that.ten) && Objects.equals(taiKhoanId, that.taiKhoanId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, diaChi, sdt, ten, taiKhoanId);
    }
}
