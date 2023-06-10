package com.poly.duanbangiay.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "danh_muc", schema = "dbo", catalog = "ShopShoe")
public class DanhMuc {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "ten")
    private String ten;
    @Column(name = "trang_thai")
    private Integer trangThai;
}
