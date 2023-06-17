package com.poly.duanbangiay.service;


import com.poly.duanbangiay.entity.KichThuoc;
import org.springframework.stereotype.Service;

@Service
public interface KichThuocService {
    void add(KichThuoc kichThuoc);

    void delete(Long id);

    void update(KichThuoc kichThuoc);

    KichThuoc detail(Long id);

    KichThuoc findOne(Long id);
}
