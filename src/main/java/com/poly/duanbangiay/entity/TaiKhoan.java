package com.poly.duanbangiay.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "tai_khoan", schema = "dbo", catalog = "ShopShoe")
public class TaiKhoan {
    private long id;
    private String username;
    private String email;
    private String ten;
    private String diaChi;
    private Date ngaySinh;
    private String password;
    private String anh;
    private String sdt;
    private boolean trangThai;

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
    @Column(name = "username", nullable = false, length = 255)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    @Column(name = "dia_chi", nullable = false, length = 255)
    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Basic
    @Column(name = "ngay_sinh", nullable = true)
    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "anh", nullable = true, length = 255)
    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
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
    @Column(name = "trang_thai", nullable = false)
    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaiKhoan taiKhoan = (TaiKhoan) o;
        return id == taiKhoan.id && trangThai == taiKhoan.trangThai && Objects.equals(username, taiKhoan.username) && Objects.equals(email, taiKhoan.email) && Objects.equals(ten, taiKhoan.ten) && Objects.equals(diaChi, taiKhoan.diaChi) && Objects.equals(ngaySinh, taiKhoan.ngaySinh) && Objects.equals(password, taiKhoan.password) && Objects.equals(anh, taiKhoan.anh) && Objects.equals(sdt, taiKhoan.sdt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, email, ten, diaChi, ngaySinh, password, anh, sdt, trangThai);
    }
}
