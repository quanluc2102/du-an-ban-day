package com.poly.duanbangiay.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "vai_tro", schema = "dbo", catalog = "ShopShoe")
public class VaiTro {
    private long id;
    private String ten;

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
    @Column(name = "ten", nullable = false, length = 255)
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VaiTro vaiTro = (VaiTro) o;
        return id == vaiTro.id && Objects.equals(ten, vaiTro.ten);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ten);
    }
}
