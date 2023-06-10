package com.poly.duanbangiay.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "phan_quyen", schema = "dbo", catalog = "ShopShoe")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PhanQuyen {

    private Long taiKhoanId;
    private Long quyenId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @ManyToOne()
    @JoinColumn(
            name = "tai_khoan_id",
            referencedColumnName = "id",
            nullable = true
    )

    private TaiKhoan taiKhoan;

    @ManyToOne()
    @JoinColumn(
            name = "quyen_id",
            referencedColumnName = "id",
            nullable = true
    )

    private Quyen quyen;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "tai_khoan_id", nullable = true)
    public Long getTaiKhoanId() {
        return taiKhoanId;
    }

    public void setTaiKhoanId(Long taiKhoanId) {
        this.taiKhoanId = taiKhoanId;
    }

    @Basic
    @Column(name = "quyen_id", nullable = true)
    public Long getRoleId() {
        return quyenId;
    }

    public void setRoleId(Long roleId) {
        this.quyenId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhanQuyen phanQuyen = (PhanQuyen) o;
        return id == phanQuyen.id && Objects.equals(taiKhoanId, phanQuyen.taiKhoanId) && Objects.equals(quyenId, phanQuyen.quyenId);
    }
    //
    @Override
    public int hashCode() {
        return Objects.hash(id, taiKhoanId, quyenId);
    }
}
