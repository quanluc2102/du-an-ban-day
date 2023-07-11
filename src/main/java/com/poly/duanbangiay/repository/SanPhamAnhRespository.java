package com.poly.duanbangiay.repository;

import com.poly.duanbangiay.entity.SanPham;
import com.poly.duanbangiay.entity.SanPhamAnh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SanPhamAnhRespository extends JpaRepository<SanPhamAnh,Long> {
    SanPhamAnh findFirstBySanPham_id(Long id);
}
