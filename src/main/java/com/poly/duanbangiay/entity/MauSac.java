package com.poly.duanbangiay.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity

@Table(name = "mau_sac", schema = "dbo", catalog = "ShopShoe")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MauSac {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "gia_tri")
    private int giaTri;

    @Column(name = "ten")
    private String ten;

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
        MauSac mauSac = (MauSac) o;
        return id == mauSac.id && giaTri == mauSac.giaTri && Objects.equals(ten, mauSac.ten);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, giaTri, ten);
    }
}
