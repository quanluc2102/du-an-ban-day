package com.poly.duanbangiay.service;

import com.poly.duanbangiay.entity.HoaDonKhuyenMai;
import org.springframework.stereotype.Service;

@Service
public interface HoaDonKhuyenMaiService {
    void add(HoaDonKhuyenMai hoaDonKhuyenMai);

    void delete(Long id);

    void update(HoaDonKhuyenMai hoaDonKhuyenMai);

    HoaDonKhuyenMai detail(Long id);

    HoaDonKhuyenMai findOne(Long id);
}
