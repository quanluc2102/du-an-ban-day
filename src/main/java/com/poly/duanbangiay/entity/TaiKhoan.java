package com.poly.duanbangiay.entity;

import jakarta.persistence.*;
<<<<<<< HEAD
import lombok.*;
=======
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
>>>>>>> GiangBranch

import java.sql.Date;
import java.util.Objects;

@Entity
<<<<<<< HEAD
@Table(name = "tai_khoan", schema = "dbo", catalog = "ShopShoe")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaiKhoan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "ten")
    private String ten;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "ngay_tao")
    private Date ngayTao;

    @Column(name = "ngay_cap_nhat")
    private Date ngayCapNhat;

    @Column(name = "password")
    private String password;

    @Column(name = "anh")
    private String anh;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "trang_thai")
    private boolean trangThai;

=======
@Table(name = "tai_khoan")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TaiKhoan {

    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "ten")
    private String ten;
    @Column(name = "dia_chi")
    private String diaChi;
    @Column(name = "ngay_tao")
    private Date ngayTao;
    @Column(name = "ngay_cap_nhat")
    private Date ngayCapNhat;
    @Column(name = "password")
    private String password;
    @Column(name = "anh")
    private String anh;
    @Column(name = "sdt")
    private String sdt;
    @Column(name = "trangThai")
    private boolean trangThai;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;

    public TaiKhoan(String username, String email, String ten, String diaChi, Date ngayTao, Date ngayCapNhat, String password, String anh, String sdt, boolean trangThai) {
        this.username = username;
        this.email = email;
        this.ten = ten;
        this.diaChi = diaChi;
        this.ngayTao = ngayTao;
        this.ngayCapNhat = ngayCapNhat;
        this.password = password;
        this.anh = anh;
        this.sdt = sdt;
        this.trangThai = trangThai;

    }
>>>>>>> GiangBranch
}
