package com.poly.duanbangiay.service;

import com.poly.duanbangiay.entity.SanPham;

import java.util.List;

public interface HoaDon {
    void add(HoaDon sp);
    void delete(Long id);
    void update(Long id,HoaDon sp);
    List<SanPham> getAll();
    SanPham getOne(Long id);
    void chuyenTrangThai(HoaDon sp);
}
