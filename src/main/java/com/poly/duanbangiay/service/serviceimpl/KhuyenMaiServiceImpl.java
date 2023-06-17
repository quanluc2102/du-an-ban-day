package com.poly.duanbangiay.service.serviceimpl;

import com.poly.duanbangiay.entity.KhuyenMai;
import com.poly.duanbangiay.repository.KhuyenMaiRepository;
import com.poly.duanbangiay.service.KhuyenMaiService;
import org.springframework.beans.factory.annotation.Autowired;

public class KhuyenMaiServiceImpl implements KhuyenMaiService {

    @Autowired
    KhuyenMaiRepository khuyenMaiRepository;

    @Override
    public void add(KhuyenMai khuyenMai) {
        khuyenMaiRepository.save(khuyenMai);
    }

    @Override
    public void delete(Long id) {
        khuyenMaiRepository.deleteById(id);
    }

    @Override
    public void update(KhuyenMai khuyenMai) {
        KhuyenMai khuyenMai1 = khuyenMaiRepository.findById(khuyenMai.getId()).get();
        khuyenMai1.setBatDau(khuyenMai.getBatDau());
        khuyenMai1.setGiamGia(khuyenMai.getGiamGia());
        khuyenMai1.setKetThuc(khuyenMai.getKetThuc());
        khuyenMai1.setTen(khuyenMai.getTen());
        khuyenMai1.setMoTa(khuyenMai.getMoTa());
        this.khuyenMaiRepository.save(khuyenMai1);

    }

    @Override
    public KhuyenMai detail(Long id) {
        return khuyenMaiRepository.findById(id).get();
    }

    @Override
    public KhuyenMai findOne(Long id) {
        return khuyenMaiRepository.findById(id).get();
    }
}
