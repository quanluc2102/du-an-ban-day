package com.poly.duanbangiay.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "kich_thuoc", schema = "dbo", catalog = "ShopShoe")
public class KichThuoc {
    private long id;
    private int giaTri;

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
    @Column(name = "gia_tri", nullable = false)
    public int getGiaTri() {
        return giaTri;
    }

    public void setGiaTri(int giaTri) {
        this.giaTri = giaTri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KichThuoc kichThuoc = (KichThuoc) o;
        return id == kichThuoc.id && giaTri == kichThuoc.giaTri;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, giaTri);
    }
}
