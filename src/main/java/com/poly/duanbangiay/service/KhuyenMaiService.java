package com.poly.duanbangiay.service;

import com.poly.duanbangiay.entity.KhuyenMai;
import org.springframework.stereotype.Service;

@Service
public interface KhuyenMaiService {
    void add(KhuyenMai khuyenMai);

    void delete(Long id);

    void update(KhuyenMai khuyenMai);

    KhuyenMai detail(Long id);

    KhuyenMai findOne(Long id);
}
