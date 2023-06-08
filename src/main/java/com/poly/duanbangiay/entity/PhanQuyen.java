package com.poly.duanbangiay.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "phan_quyen", schema = "dbo", catalog = "ShopShoe")
public class PhanQuyen {
    private long id;
    private Long taiKhoanId;
    private Long roleId;

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
    @Column(name = "tai_khoan_id", nullable = true)
    public Long getTaiKhoanId() {
        return taiKhoanId;
    }

    public void setTaiKhoanId(Long taiKhoanId) {
        this.taiKhoanId = taiKhoanId;
    }

    @Basic
    @Column(name = "role_id", nullable = true)
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhanQuyen phanQuyen = (PhanQuyen) o;
        return id == phanQuyen.id && Objects.equals(taiKhoanId, phanQuyen.taiKhoanId) && Objects.equals(roleId, phanQuyen.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, taiKhoanId, roleId);
    }
}
