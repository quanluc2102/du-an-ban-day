package com.poly.duanbangiay.service;

import com.poly.duanbangiay.entity.HoaDon;
import com.poly.duanbangiay.entity.SanPham;

import java.util.List;

public interface HoaDonService {
    void add(HoaDonService sp);
    void delete(Long id);
    void update(Long id, HoaDonService hoaDon);
    List<HoaDon> getAll();
    SanPham getOne(Long id);
    void chuyenTrangThai(HoaDonService hoaDon);
}
