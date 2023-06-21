package com.poly.duanbangiay.service.serviceimpl;

import com.poly.duanbangiay.entity.MauSac;
import com.poly.duanbangiay.entity.MauSac;
import com.poly.duanbangiay.repository.MauSacRepository;
import com.poly.duanbangiay.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;

public class MauSacServiceImpl implements MauSacService {

    @Autowired
    MauSacRepository mauSacRepository;

    @Override
    public void add(MauSac mauSac) {
        mauSacRepository.save(mauSac);
    }

    @Override
    public void delete(Long id) {
        mauSacRepository.deleteById(id);
    }

    @Override
    public void update(MauSac mauSac) {
        MauSac mauSac1 = mauSacRepository.findById(mauSac.getId()).get();
        mauSac1.setGiaTri(mauSac.getGiaTri());
        mauSac1.setTen(mauSac.getTen());
        mauSac1.setTrangThai(mauSac.getTrangThai());
        this.mauSacRepository.save(mauSac1);

    }

    @Override
    public MauSac detail(Long id) {
        return mauSacRepository.findById(id).get();
    }

    @Override
    public MauSac findOne(Long id) {
        return mauSacRepository.findById(id).get();
    }
}
