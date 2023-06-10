package com.poly.duanbangiay.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "thong_tin_nguoi_dung")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ThongTinNguoiDung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "diaChi")
    private String diaChi;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "ten")
    private String ten;

    @ManyToOne
    @JoinColumn(name = "tai_khoan_id",referencedColumnName = "id",nullable = true)
    private TaiKhoan taiKhoan;


}
