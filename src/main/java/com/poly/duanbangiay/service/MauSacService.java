package com.poly.duanbangiay.service;


import com.poly.duanbangiay.entity.MauSac;


public interface MauSacService {
    void add(MauSac mauSac);

    void delete(Long id);

    void update(MauSac mauSac);

    MauSac detail(Long id);

    MauSac findOne(Long id);
}
