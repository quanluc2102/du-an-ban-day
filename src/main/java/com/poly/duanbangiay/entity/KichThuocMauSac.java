package com.poly.duanbangiay.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "kich_thuoc_mau_sac", schema = "dbo", catalog = "ShopShoe")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class KichThuocMauSac {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "so_luong")
    private int soLuong;
    @Column(name = "trang_thai")
    private int trangThai;

    @ManyToOne()
    @JoinColumn(
            name = "mau_sac_id",
            referencedColumnName = "id",
            nullable = true
    )

    private MauSac mauSac;
    @ManyToOne()
    @JoinColumn(
            name = "san_pham_id",
            referencedColumnName = "id",
            nullable = true
    )

    private SanPham sanPham;
    @ManyToOne()
    @JoinColumn(
            name = "kich_thuoc_id",
            referencedColumnName = "id",
            nullable = true
    )

    private KichThuoc kichThuoc;
}