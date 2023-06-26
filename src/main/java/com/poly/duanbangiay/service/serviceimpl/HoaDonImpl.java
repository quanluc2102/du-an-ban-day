package com.poly.duanbangiay.service.serviceimpl;

import com.poly.duanbangiay.entity.HoaDon;
import com.poly.duanbangiay.entity.SanPham;
import com.poly.duanbangiay.repository.HoaDonRepository;
import com.poly.duanbangiay.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HoaDonImpl implements HoaDonService {
    @Autowired
    HoaDonRepository hoaDonRepository;
    @Override
    public void add(HoaDonService sp) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Long id, HoaDonService hoaDon) {

    }

    @Override
    public List<HoaDon> getAll() {
        return hoaDonRepository.findAll();
    }

    @Override
    public SanPham getOne(Long id) {
        return null;
    }

    @Override
    public void chuyenTrangThai(HoaDonService hoaDon) {

    }
}
