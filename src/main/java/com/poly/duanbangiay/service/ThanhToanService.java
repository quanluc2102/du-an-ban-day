package com.poly.duanbangiay.service;

import com.poly.duanbangiay.entity.SanPham;
import com.poly.duanbangiay.entity.TaiKhoan;
import com.poly.duanbangiay.entity.ThanhToan;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ThanhToanService {
    void add(ThanhToan thanhToan);
    void delete(Long id);
    void update(Long id,ThanhToan thanhToan);
    List<SanPham> getAll();
    SanPham getOne(Long id);
    void chuyenTrangThai(ThanhToan thanhToan);
}
