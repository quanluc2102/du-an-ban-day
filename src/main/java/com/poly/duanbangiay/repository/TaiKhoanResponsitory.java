package com.poly.duanbangiay.repository;


import com.poly.duanbangiay.entity.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaiKhoanResponsitory extends JpaRepository<TaiKhoan,Long> {
}
