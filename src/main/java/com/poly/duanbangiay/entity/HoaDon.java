package com.poly.duanbangiay.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Objects;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hoa_don", schema = "dbo", catalog = "ShopShoe")
public class HoaDon {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "ngay_tao")
    private Date ngayTao;
    @Column(name = "ghi_chu")
    private String ghiChu;
    @Column(name = "ngay_cap_nhat")
    private Date ngayCapNhat;
    @Column(name = "trang_thai")
    private int trangThai;
    @ManyToOne
    @JoinColumn(name = "tai_khoan_id",
    referencedColumnName = "id",
    nullable = false)
    private TaiKhoan tk;
    @ManyToOne
    @JoinColumn(name = "thanh_toan_id",
    referencedColumnName = "id",
    nullable = false)
    private ThanhToan tt;
}
